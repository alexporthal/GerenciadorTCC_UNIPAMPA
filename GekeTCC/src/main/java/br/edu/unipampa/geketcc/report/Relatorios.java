package br.edu.unipampa.geketcc.report;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Douglas
 */
public class Relatorios {

    public static Connection con;
    public static String banco = "db_geke_tcc"; // Nome do banco de dados
    public static String usuario = "root"; // Usuario do banco
    public static String senha = ""; // Senha
    private final HttpServletResponse response;
    private final String pathJasper;

    public Relatorios(HttpServletResponse response, String pathJasper) {
        this.response = response;
        this.pathJasper = pathJasper;
    }

    public void gerarRelatorio(Map<String, Object> parameters, String nomeRelatorio) throws JRException, IOException {
        conexao();

        response.setContentType("application/pdf");

        ServletOutputStream servletOutputStream = response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        FileInputStream fis;
        BufferedInputStream bufferedInputStream;

        try {
            String reportLocation = pathJasper;
            fis = new FileInputStream(reportLocation + "/" + nomeRelatorio);
            bufferedInputStream = new BufferedInputStream(fis);

            JasperReport jasperReport = (JasperReport) JRLoader
                    .loadObject(bufferedInputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    jasperReport, parameters, con);
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

            response.setContentLength(baos.size());
            baos.writeTo(servletOutputStream);
            fis.close();
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            servletOutputStream.flush();
            servletOutputStream.close();
            baos.close();
        }
    }

    public void conexao() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + banco, usuario, senha);
            }
        } catch (Exception e) {
            System.out.println("não foi possível conectar ao banco ->" + e);
        }
    }
}
