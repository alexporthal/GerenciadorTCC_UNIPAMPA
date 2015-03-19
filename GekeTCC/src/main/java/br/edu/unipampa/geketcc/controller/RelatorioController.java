package br.edu.unipampa.geketcc.controller;

import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.MembroBanca;
import br.edu.unipampa.geketcc.model.Pessoa;
import br.edu.unipampa.geketcc.report.Relatorios;
import br.edu.unipampa.geketcc.service.MatriculaService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
 * Relatório Controller
 *
 * @author Alex becker
 * @since 07/01/2015
 */
@Controller
public class RelatorioController {

    private Relatorios relatorios;

    @RequestMapping(value = "/relatorio/ataDefesa/visualizar/{codigo}", method = RequestMethod.GET)
    @ResponseBody
    public Object ataDefesa(@PathVariable("codigo") int codigo, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String pathJasper = request.getSession().getServletContext().getRealPath(
                "/WEB-INF/reports/") + "/";
        relatorios = new Relatorios(response, pathJasper);
        try {
            MatriculaService matriculaService = new MatriculaService();
            Map<String, Object> parameters = new HashMap<String, Object>();
            Matricula matricula = matriculaService.buscar(codigo);

            String banca = "";
            for (MembroBanca mb : matricula.getMembroBancaCollection()) {
                banca += mb.getMembro().getNome() + "\n";
            }
            parameters.put("banca", banca);
            parameters.put("codigoMatricula", codigo);
            if (matricula.getAvaliado() && matricula.getStatus() == 3) {
                parameters.put("aprovado", "X");
                parameters.put("reprovado", "");
            } else {
                parameters.put("aprovado", "");
                parameters.put("reprovado", "X");
            }

            relatorios.gerarRelatorio(parameters, "ata_defesa.jasper");
        } catch (Exception e) {
            response.getWriter().println("Erro ao gerar o relatório: " + e);
        }
        return null;
    }

    @RequestMapping("/relatorio/ataDefesa")
    public ModelAndView convidar(HttpSession session) {
        MatriculaService matriculaService = new MatriculaService();
        Pessoa orientador = (Pessoa) session.getAttribute("usuarioLogado");

        ModelAndView mv = new ModelAndView("relatorio/gerarAtaDefesa");

        ArrayList<Matricula> matriculas = matriculaService.buscarMatriculasAvaliadasEAprovadas(orientador);
        mv.getModelMap().put("matriculas", matriculas);
        return mv;
    }
}
