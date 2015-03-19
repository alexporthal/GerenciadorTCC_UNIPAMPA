<%-- 
    Document   : gerarAtaDefesa
    Created on : 07/01/2015, 10:20:32
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description"
              content="UNIPAMPA" />
        <meta name="author" content="" />

        <title>Ata de Defesa | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

        <!-- BOOTSTRAP STYLES-->
        <link href="<c:url value="/resources/assets/css/bootstrap.css"/>" rel="stylesheet">
        <!-- FONTAWESOME STYLES-->
        <link href="<c:url value="/resources/assets/css/font-awesome.css"/>" rel="stylesheet">
        <!-- CUSTOM STYLES-->
        <link href="<c:url value="/resources/assets/css/custom.css"/>" rel="stylesheet">
        <!-- GOOGLE FONTS-->
        <link href="<c:url value="http://fonts.googleapis.com/css?family=Open+Sans"/>" rel="stylesheet">
    </head>
    <body>
        <div id="wrapper">
            <c:import url="/WEB-INF/jsp/estrutura/menu.jsp"></c:import>   
                <!-- /. NAV SIDE  -->
                <div id="page-wrapper" >
                    <div id="page-inner">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>Ata de Defesa do TCC</h2>   
                                <h5>Selecione o tcc que deseja gerar a Ata de Defesa.</h5>
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">

                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="panel-body">
                                                <table class="table table-hover" id="dev-table">
                                                    <thead>
                                                        <tr>
                                                            <th>Aluno</th>
                                                            <th>Orientador</th>
                                                            <th>Tema</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="matricula" items="${matriculas}">
                                                        <tr>
                                                            <td>${matricula.aluno.nome}</td>
                                                            <td>${matricula.orientador.nome}</td>
                                                            <td>${matricula.tema}</td>
                                                            <td class="td-actions">
                                                                <form action="/GekeTCC/relatorio/ataDefesa/visualizar/${matricula.codigo}"
                                                                      method="get">
                                                                    <button type=submit class="btn btn-small btn-info" alt="Gerar Ata Defesa">
                                                                        <span class="fa fa-print"></span>
                                                                    </button>
                                                                </form>
                                                            </td>
                                                        </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>

                                    <!-- /. ROW  -->
                                </div>
                                <!-- /. PAGE INNER  -->

                                <!-- /. PAGE WRAPPER  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="<c:url value="/resources/assets/js/jquery-1.10.2.js"/>"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="<c:url value="/resources/assets/js/bootstrap.min.js"/>"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="<c:url value="/resources/assets/js/jquery.metisMenu.js"/>"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="<c:url value="/resources/assets/js/custom.js"/>"></script>



        <script>
            function gerarRelatorio(idMatricula) {
                alert(idMatricula);
                $.get("<c:url value="/GekeTCC/relatorio/ataDefesa/visualizar/"/>" + idMatricula, function () {
                });
            }
        </script>
    </body>
</html>

