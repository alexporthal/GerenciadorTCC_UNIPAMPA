<%-- 
    Document   : menu
    Created on : 13/12/2014, 23:10:01
    Author     : Douglas
--%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">

                <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                <meta name="description"
                      content="UNIPAMPA" />
                <meta name="author" content="" />

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
                                        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                                            <div class="navbar-header">
                                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                                                    <span class="sr-only">Toggle navigation</span>
                                                    <span class="icon-bar"></span>
                                                    <span class="icon-bar"></span>
                                                    <span class="icon-bar"></span>
                                                </button>
                                                <a class="navbar-brand" href="/GekeTCC/principal">GekeTCC</a> 
                                            </div>
                                            <div style="color: white;
                                                 padding: 15px 50px 5px 50px;
                                                 float: right;
                                                 font-size: 16px;"><a href="/GekeTCC/logout" class="btn btn-success square-btn-adjust">Logout</a> </div>
                                        </nav>   
                                        <!-- /. NAV TOP  -->
                                        <nav class="navbar-default navbar-side" role="navigation">
                                            <div class="sidebar-collapse">
                                                <ul class="nav" id="main-menu">
                                                    <li class="text-center">
                                                        <img src="<c:url value="/resources/assets/img/find_user.png"></c:url>" class="user-image img-responsive"/>
                                                        </li>


                                                        <li>
                                                            <a class="active-menu"  href="index.html"><i class="fa fa-dashboard fa-3x"></i> Perfil</a>
                                                        </li>
                                                        <li>
                                                            <a  href="/GekeTCC/matricula/preMatricula"><i class="fa fa-desktop fa-3x"></i> Pré - Matricula</a>
                                                        </li>
                                                        <li>
                                                            <a  href="/GekeTCC/matriculaArquivo/submeterTCC"><i class="fa fa-qrcode fa-3x"></i>Arquivo TCC</a>
                                                        </li>
                                                        <li>
                                                            <a  href="/GekeTCC/matricula/matriculasOrientador"><i class="fa fa-table fa-3x"></i>Matriculas</a>
                                                        </li>

                                                        <li  >
                                                            <a  href="/GekeTCC/membroExterno/convidar"><i class="fa fa-user fa-3x"></i> Convidar Membro Externo</a>
                                                        </li>
                                                        <li  >
                                                            <a  href="/GekeTCC/banca/selecionarAluno"><i class="fa fa-table fa-3x"></i>Cadastro Banca</a>
                                                        </li>		
                                                        <li>
                                                            <a  href="/GekeTCC/agendaBanca/agendar"><i class="fa fa-square-o fa-3x"></i>Agendar Banca</a>
                                                        </li>	
                                                        <li>
                                                            <a  href="blank.html"><i class="fa fa-square-o fa-3x"></i>Agenda de Defesas</a>
                                                        </li>	
                                                        <li>
                                                            <a href="#"><i class="fa fa-sitemap fa-3x"></i> Relatórios<span class="fa arrow"></span></a>
                                                            <ul class="nav nav-second-level">
                                                                <li>
                                                                    <a href="#">Ata de Reunião</a>
                                                                </li>
                                                                <li>
                                                                    <a href="/GekeTCC/relatorio/parecerFinal">Parecer Final</a>
                                                                </li>
                                                                <li>
                                                                    <a href="/GekeTCC/relatorio/ataDefesa">Ata de Defesas</a>
                                                                </li>
                                                                <li>
                                                                    <a href="#">Lista de Presença</a>
                                                                </li>
                                                            </ul>
                                                        </li> 

                                                    </ul>

                                                </div>

                                            </nav>  
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


                                </body>
                                </html>
