package br.edu.unipampa.geketcc.service;

import br.edu.unipampa.geketcc.dao.*;
import br.edu.unipampa.geketcc.model.Matricula;
import br.edu.unipampa.geketcc.model.Matriculaarquivo;
import br.edu.unipampa.geketcc.model.Pessoa;
import java.util.ArrayList;
import java.util.List;

/*
 * Matricula Arquivo TCC
 *
 * @author Douglas Giordano
 * @since 07/12/2014
 */
public class MatriculaArquivoService {

    MatriculaArquivoDAO matriculaArquivoDao;
    public MatriculaArquivoService() {
        matriculaArquivoDao = new MatriculaArquivoDAO();
    }

    
    
    /**
     * Salvar o registro do arquivo de TCC
     *
     * @param matriculaArquivo
     * @return
     */
    public boolean salvar(Matriculaarquivo matriculaArquivo) {
        return matriculaArquivoDao.salvar(matriculaArquivo);
    }
    
    
    public Matricula buscarUltimaMatricula(int codigoAluno){
        return matriculaArquivoDao.buscarUltimaMatricula(codigoAluno);
    }
        
    /**
     * Método popula um objeto pertencente a classe Matricula com os arquivos de TCC referente a matricula
     * @param matricula
     * @return matricula populada com arquivos de TCC
     */
    public Matricula buscarUltimosArquivos(Matricula matricula){
        List<Matriculaarquivo> matriculasArquivos = matriculaArquivoDao.buscarUltimosArquivos(matricula.getCodigo());
        matricula.setMatriculaarquivoCollection(matriculasArquivos);
        return matricula;
    }

    public Matriculaarquivo buscarMatriculaArquivo(int codigoArquivo) {
        return matriculaArquivoDao.buscarMatriculaArquivo(codigoArquivo);
    }
    
    public Matriculaarquivo buscar(Matricula matricula){
        return matriculaArquivoDao.buscar(matricula);
    }

    public List<Matriculaarquivo> buscarMatriculasArquivosPendentes(int codigoOrientador) {
        return matriculaArquivoDao.buscarMatriculasArquivos(codigoOrientador, 0);
    }
    
    public Matriculaarquivo buscarMatriculaArquivoPendente(int codigoOrientador, int codigoAluno) {
        int status = 0;
        return matriculaArquivoDao.buscarMatriculaArquivo(codigoOrientador, codigoAluno, status);
    }
}
