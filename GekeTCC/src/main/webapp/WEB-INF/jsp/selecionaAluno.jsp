<%-- 
    Document   : selecionaAluno
    Created on : 15/12/2014, 22:48:58
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html lang="pt">
    <html>
        <head>

            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">

            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <meta name="description"
                  content="UNIPAMPA" />
            <meta name="author" content="" />

            <title> Seleção do Aluno para Cadastro de Banca | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                <nav class="navbar navbar-default navbar-cls-top navbar-inverse" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">

                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                            <span class="sr-only">Toggle navigation </span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/GekeTCC/login/loginForm">GekeTCC </a> 
                    </div>
                    <div style="color: black;
                         padding: 15px 50px 5px 50px;
                         float: right;
                         font-size: 16px;"> 
                        <label style="color: #ffffff; font-size: 20px">Cadastro de Banca</label>

                    </div>

                </nav>
                <!-- /. NAV SIDE  -->
                <div id="page-wrapper" >
                    <div id="page-inner">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>Selecionar Aluno<br> </h2>

                                <br>    
                                <h5>Para realizar o cadastro da banca , primeiramente selecione o aluno desejado. </h5>

                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <form:form  modelAttribute="matricula" action="/GekeTCC/banca/cadastrar/novaBanca" method="post">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="panel-body">
                                                <ul class="nav nav-tabs" id="tabMatriculas">
                                                    <li class="active"><a href="#" data-toggle="tab" id="tab_pendentes">Alunos com Banca Pendente</a>
                                                    </li>
                                                    <li><a href="#" data-toggle="tab" id="tab_aceitas">Alunos com Banca Marcada</a>
                                                    </li>
                                                </ul>

                                                <div class="tab-content">                                                
                                                    <div id="dados_banca"></div>                                                 
                                                </div>
                                            </div>

                                        </div>
                                    </form:form>
                                        <!-- /. ROW  -->
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

                                <script type="text/javascript">
                                    $('#tab_pendentes').click(function () {
                                        $('#dados_matriculas').html("");
                                        $.ajax({
                                            url: "<c:url value="/banca/pesquisaAlunosPendentes" />",
                                            dataType: "html",
                                            type: "GET",
                                            success: function (data) {
                                                $('#dados_banca').html(data);
                                            }
                                        });
                                    });
                                </script>

                                <script type="text/javascript">
                                    $('#tab_aceitas').click(function () {
                                        $('#dados_banca').html("");
                                        $.ajax({
                                            url: "<c:url value="/matricula/pesquisarMatriculasAceitas" />",
                                            dataType: "html",
                                            type: "GET",
                                            success: function (data) {
                                                $('#dados_matriculas').html(data);
                                            }
                                        });
                                    });
                                </script>
                                </body>
                                </html>