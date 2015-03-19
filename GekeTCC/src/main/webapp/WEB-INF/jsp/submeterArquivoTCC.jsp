<%-- 
    Document   : submeterArquivoTCC.jsp
    Created on : 07/12/2014, 03:29:43
    Author     : Douglas Giordano
--%>
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

        <title>Submissão Arquivo de TCC | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                                <h2>Submissão do TCC</h2>   
                                <h5>Selecione o arquivo do TCC e clique em submeter.</h5>
                                <h6>Caso o botão de submeter esteja desativado, você possui algum arquivo com status pendente(aguardando aprovação do orientador)</h6>
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Cadastro
                                    </div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <form method="POST" enctype="multipart/form-data"
                                                      action="upload">
                                                    <div class="form-group">
                                                        <label for="exampleInputFile">Trabalho de Conclusão do Curso</label>
                                                        <input type="file" name="file" >
                                                    </div>
                                                    <input  class="btn btn-success" type="submit" value="Submeter">

                                                </form>

                                            </div>
                                            <div class="col-sm-6">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        Arquivo Anteriores
                                                    </div>
                                                    <div class="panel-body">

                                                        <div class="panel-footer">
                                                            Clique no botão para efetuar o download de cada arquivo.
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <!-- /. PAGE INNER  -->
                                        </div>
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
    </body>
</html>