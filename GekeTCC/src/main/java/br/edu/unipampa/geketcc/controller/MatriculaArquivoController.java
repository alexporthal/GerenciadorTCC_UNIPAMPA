package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Matriculaarquivo;
import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.service.MatriculaArquivoService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * Classe encarregada do controle das operações com os arquivos de tcc da matricula do aluno.
 *
 * @author Douglas Giordano
 * @since 07/12/2014
 */
@Controller
@RequestMapping("/matriculaArquivo")
public class MatriculaArquivoController {

    private final MatriculaArquivoService matriculaArquivoService;

    public MatriculaArquivoController() {
        matriculaArquivoService = new MatriculaArquivoService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session, RedirectAttributes redirectAttrs) {
        Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");
        Matricula matricula = matriculaArquivoService.buscarUltimaMatricula(pessoa.getCodigo());
        Matriculaarquivo matriculaArquivo = new Matriculaarquivo();
        matriculaArquivo.setMatricula(matricula);
        String mensagem = "";

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                matriculaArquivo.setArquivo(bytes);
            } catch (Exception e) {
                mensagem = "Ocorreu um erro ao enviar o arquivo!";
            }
        } else {
            mensagem = "Arquivo vazio, impossivel enviar!";
        }

        if (matriculaArquivoService.salvar(matriculaArquivo)) {
            mensagem = "Arquivo submetido com sucesso!!";
        } else {
            mensagem = "Erro ao submeter o arquivo!";
        }
        redirectAttrs.addAttribute("mensagem",mensagem).addFlashAttribute(mensagem);
        return "redirect:/mensagem/exibir";
    }

    @RequestMapping("/submeterTCC")
    public ModelAndView cadastrar(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("submeterArquivoTCC");
        Pessoa pessoa = (Pessoa) session.getAttribute("usuarioLogado");

        Matricula matricula = matriculaArquivoService.buscarUltimaMatricula(pessoa.getCodigo());
        if (matricula == null) {
            modelAndView.setViewName("solicitarPreMatricula");
            return modelAndView;
        }

        Matriculaarquivo matriculaArquivo = new Matriculaarquivo();
        matriculaArquivo.setMatricula(matricula);
        modelAndView.addObject("matriculaArquivo", matriculaArquivo);
        modelAndView.addObject("matricula", matricula);
        return modelAndView;
    }

    @RequestMapping("/visualizarArquivo")
    public ModelAndView abrirVisualizacaoArquivo(@RequestParam("matricula") int codigoMatricula) {
        ModelAndView modelAndView = new ModelAndView("matriculaArquivoAceitaRejeita");
        Matricula matricula = new Matricula();
        matricula.setCodigo(codigoMatricula);

        Matriculaarquivo matriculaArquivo = matriculaArquivoService.buscar(matricula);
        if (matriculaArquivo == null) {
            modelAndView.setViewName("/mensagem/mensagemSimples");
            modelAndView.addObject("mensagem", "Nenhum arquivo enviado pelo aluno.");
        } else {
            modelAndView.addObject("matriculaArquivo", matriculaArquivo);
        }
        return modelAndView;
    }

    @RequestMapping("/aceitar/{codigoArquivo}")
    public String aceitar(@PathVariable int codigoArquivo) {
        Matriculaarquivo matriculaArquivo = matriculaArquivoService.buscarMatriculaArquivo(codigoArquivo);
        matriculaArquivo.setStatus(1);
        if (matriculaArquivoService.salvar(matriculaArquivo)) {
            return "Arquivo TCC foi aceito!";
        } else {
            return "Arquivo TCC não foi aceito. Ocorreu algum problema!";
        }
    }

    @RequestMapping("/rejeitar/{codigoArquivo}")
    public String rejeitar(@PathVariable int codigoArquivo) {
        Matriculaarquivo matriculaArquivo = matriculaArquivoService.buscarMatriculaArquivo(codigoArquivo);
        matriculaArquivo.setStatus(2);
        if (matriculaArquivoService.salvar(matriculaArquivo)) {
            return "Arquivo TCC foi rejeitado!";
        } else {
            return "Arquivo TCC não foi rejeitado. Ocorreu algum problema!";
        }
    }

    @RequestMapping("/salvar")
    public String salvar(@ModelAttribute(value = "membroExterno") Matriculaarquivo matriculaArquivo,
            BindingResult result, RedirectAttributes redirectAttrs, HttpServletRequest request) throws NoSuchAlgorithmException, IOException {

        if (matriculaArquivoService.salvar(matriculaArquivo)) {
            redirectAttrs.addAttribute("mensagem",
                    "Arquivo submetido com sucesso!").addFlashAttribute(
                            "mensagem", "Arquivo submetido com sucesso!!");
        } else {
            redirectAttrs.addAttribute("mensagem",
                    "Erro ao submeter o arquivo!").addFlashAttribute(
                            "mensagem", "Erro ao submeter o arquivo!");
        }

        return "redirect:/mensagem/exibir";
    }

    @RequestMapping("/mostrarArquivo/{codigoArquivo}")
    public HttpEntity<byte[]> mostrarArquivo(@PathVariable int codigoArquivo) {
        Matriculaarquivo matriculaArquivo = matriculaArquivoService.buscarMatriculaArquivo(codigoArquivo);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
//    header.set("Content-Disposition",
//                   "attachment; filename=" + matriculaArquivo.getMatricula().getTema());//gera relatorio para download
        header.set("Content-Disposition",
                "inline; filename=" + matriculaArquivo.getMatricula().getTema());
        header.setContentLength(matriculaArquivo.getArquivo().length);

        return new HttpEntity<byte[]>(matriculaArquivo.getArquivo(), header);
    }

}
