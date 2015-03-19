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

        <title>Matrículas | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
            <c:import url="estrutura/menu.jsp"></c:import>   
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Matrículas</h2>   
                            <h5>Selecione o tipo de matrículas que deseja visualizar.</h5>
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
                                            <ul class="nav nav-tabs" id="tabMatriculas">
                                                <li class="active"><a href="#" data-toggle="tab" id="tab_pendentes">Pendente</a>
                                                </li>
                                                <li><a href="#" data-toggle="tab" id="tab_aceitas">Aceita</a>
                                                </li>
                                                <li><a href="#"  data-toggle="tab" id="tab_rejeitadas">Rejeitada</a>
                                                </li>
                                                <li><a href="#" data-toggle="tab" id="tab_aprovadas">Aprovada</a>
                                                </li>
                                                <li><a href="#" data-toggle="tab" id="tab_reprovadas">Reprovada</a>
                                                </li>
                                            </ul>

                                            <div class="tab-content">                                                
                                                <div id="dados_matriculas"></div>                                                 
                                            </div>
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

        <script type="text/javascript">
            $('#tab_pendentes').click(function () {
                $('#dados_matriculas').html("");
                $.ajax({
                    url: "<c:url value="/matricula/pesquisarMatriculasPendentes" />",
                    dataType: "html",
                    type: "GET",
                    success: function (data) {
                        $('#dados_matriculas').html(data);
                    }
                });
            });
        </script>

        <script type="text/javascript">
            $('#tab_aceitas').click(function () {
                $('#dados_matriculas').html("");
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

        <script type="text/javascript">
            $('#tab_rejeitadas').click(function () {
                $('#dados_matriculas').html("");
                $.ajax({
                    url: "<c:url value="/matricula/pesquisarMatriculasRejeitadas" />",
                    dataType: "html",
                    type: "GET",
                    success: function (data) {
                        $('#dados_matriculas').html(data);
                    }
                });
            });
        </script>

        <script type="text/javascript">
            $('#tab_aprovadas').click(function () {
                $('#dados_matriculas').html("");
                $.ajax({
                    url: "<c:url value="/matricula/pesquisarMatriculasAprovadas" />",
                    dataType: "html",
                    type: "GET",
                    success: function (data) {
                        $('#dados_matriculas').html(data);
                    }
                });
            });
        </script>

        <script type="text/javascript">
            $('#tab_reprovadas').click(function () {
                $('#dados_matriculas').html("");
                $.ajax({
                    url: "<c:url value="/matricula/pesquisarMatriculasReprovadas" />",
                    dataType: "html",
                    type: "GET",
                    success: function (data) {
                        $('#dados_matriculas').html(data);
                    }
                });
            });
        </script>

        <script>
            function aceitarMatricula(idMatricula) {
                $('#dados_matriculas').html("");
                $.get("<c:url value="/matricula/aceitarPreMatricula/" />" + idMatricula, function (data) {
                    $('#dados_matriculas').html(data);
                });
            }
        </script>
        <script>
            function rejeitarMatricula(idMatricula) {
                $('#dados_matriculas').html("");
                $.get("<c:url value="/matricula/rejeitarPreMatricula/" />" + idMatricula, function (data) {
                    $('#dados_matriculas').html(data);
                });
            }
        </script>
    </body>
</html>