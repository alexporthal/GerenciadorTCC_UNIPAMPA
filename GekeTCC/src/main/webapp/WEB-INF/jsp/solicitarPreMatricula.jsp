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

        <title>Solicitar Pré-Matrícula | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                                <h2>Solicitar Pré-Matrícula</h2>   
                                <h5>Preencha os campos abaixo para solicitar a pré-matrícula. </h5>
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Solicitar Pré-Matrícula
                                    </div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                            <c:if test="${matriculado == false}">	
                                                <form:form modelAttribute="matricula" action="/GekeTCC/matricula/solicitarPreMatricula" method="post">
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <form:label path="tema">Tema</form:label>
                                                            </div>

                                                            <div class="col-sm-12">
                                                            <form:input path="tema" type="text" class="form-control" required="true" autofocus="true"/>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <form:label path="descricao">Descrição</form:label>
                                                            </div>

                                                            <div class="col-sm-12">
                                                            <form:textarea path="descricao" type="text" required="true" class="form-control"/>
                                                        </div>
                                                    </div> 

                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label for="orientador" class="control-label">Orientador</label>
                                                        </div>

                                                        <div class="col-sm-1">
                                                            <form:input path="orientador.codigo" type="text"
                                                                        class="form-control" id="codigoOrientador"
                                                                        required="true" alt="Código Orientador" readonly="true"/>
                                                        </div>

                                                        <div class="col-sm-8">
                                                            <form:input path="orientador.nome" type="text"
                                                                        class="form-control" id="nomeOrientador" readonly="true"/>
                                                        </div>

                                                        <div class="col-sm-1">
                                                            <button type="button" class="btn btn-primary" id='pesquisarOrientadores'>
                                                                <i class=" fa fa-search"></i>
                                                            </button>
                                                        </div>
                                                    </div>

                                                    <div>
                                                        <div class="col-sm-12">
                                                            <br />
                                                        </div>
                                                        <div class="col-sm-12">
                                                            <button class="btn btn-success" type="submit">Solicitar</button>
                                                        </div>
                                                    </div>

                                                </form:form>
                                            </c:if>

                                            <c:if test="${matriculado == true}">
                                                <h5>Você não pode solicitar pré-matrícula nesse momento.</h5>
                                            </c:if>
                                        </div>

                                        <!-- /. ROW  -->
                                    </div>
                                    <!-- /. PAGE INNER  -->
                                </div>
                                <!-- /. PAGE WRAPPER  -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- modal pesquisa orientadores -->
            <div class="modal fade" id="consultaOrientadores" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h3 id="consultaOrientadoresLabel">Selecionar Orientador</h3>
                        </div>
                        <div class="modal-body">
                            <div id="dados_orientadores"></div>

                        </div>
                        <div class="modal-footer">
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Fechar</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- End Modals-->
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
            $('#pesquisarOrientadores').click(function () {
                $.ajax({
                    url: "<c:url value="/pessoa/pesquisarOrientadores" />",
                    dataType: "html",
                    type: "GET",
                    success: function (data) {
                        $('#dados_orientadores').html(data);
                        $('#consultaOrientadores').modal('show');
                    }
                });
            });
        </script>

        <script>
            function selecionarOrientador(id, nome) {
                document.getElementById('codigoOrientador').value = id;
                document.getElementById('nomeOrientador').value = nome;
                $('#consultaOrientadores').modal('hide');
            }
        </script>
    </body>
</html>