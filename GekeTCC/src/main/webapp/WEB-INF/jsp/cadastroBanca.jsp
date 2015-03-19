<%-- 
    Document   : cadastroBanca
    Created on : 11/12/2014, 22:48:58
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html lang="pt">
    <html>
        <head>
            <script>
                function mostraProfessorInv() {
                    $('#membro').slideDown();
                }
            </script>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">

            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <meta name="description"
                  content="UNIPAMPA" />
            <meta name="author" content="" />

            <title> Cadastro de Banca | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                                <h2>Cadastro de Banca<br> </h2>

                                <br>    
                                <h5>Para realizar o cadastro da banca , define os termos da banca nos campos a seguir. </h5>

                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">

                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <form:form  modelAttribute="banca" action="/GekeTCC/banca/salvar" method="post">

                                                        <div class="form-group">

                                                            <label> Aluno </label><br> <input name="nomeAluno" type="text" id="nomeAluno" readonly="readonly" disabled>


                                                        </div>
                                                        <div class="form-group">
                                                            <label> Orientador</label> <br><input name="orientador" type="text" id="nomeOrientador" readonly="readonly" disabled>
                                                        </div>

                                                        <div class="form-group">
                                                            <label> Membro da Banca 1</label> <br><input name="membro1" type="text" id="membro1" placeholder="Membro Banca" required>
                                                        </div>

                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <label for="membrobanca1" class="control-label">Membro 1</label>
                                                            </div>

                                                            <div class="col-sm-1">
                                                                <form:input path="" type="text"
                                                                            class="form-control" id="membrobanca1"
                                                                            required="true" alt="Código Membro" readonly="true"/>
                                                            </div>
                                                            <div class="col-sm-1">
                                                                <button type="button" class="btn btn-primary" id='pesquisarMembros'>
                                                                    <i class=" fa fa-search"></i>
                                                                </button>
                                                            </div>

                                                            <br><br><br><br>

                                                            <div class="form-group">
                                                                <label> Membro da Banca 2</label> <br><input name="membro2" type="text" id="membro2" placeholder="Membro Banca" required>
                                                            </div>


                                                            <div class="form-group">
                                                                <div class="col-sm-12">
                                                                    <label for="membrobanca2" class="control-label">Membro 2</label>
                                                                </div>

                                                                <div class="col-sm-1">
                                                                    <form:input path="" type="text"
                                                                                class="form-control" id="membrobanca2"
                                                                                required="true" alt="Código Membro" readonly="true"/>
                                                                </div>
                                                                <div class="col-sm-1">
                                                                    <button type="button" class="btn btn-primary" id='pesquisarMembros'>
                                                                        <i class=" fa fa-search"></i>
                                                                    </button>
                                                                </div>



                                                                <div style="display: none" id="membro">Membro da Banca 3 : <input type="text" name="membro" id="membro" /></div>  


                                                                <br><br><br><br>

                                                                <button type="button" onclick="mostraProfessorInv()" name="btAddProfessor" id="btAddProfessor" >Adicionar</button><br></br>


                                                                <button class="btn btn-success" type="submit">Enviar</button>
                                                            </form:form>

                                                        </div>
                                                    </div>  

                                                    <form:form  modelAttribute="banca" action="/GekeTCC/banca/salvar" method="post">
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