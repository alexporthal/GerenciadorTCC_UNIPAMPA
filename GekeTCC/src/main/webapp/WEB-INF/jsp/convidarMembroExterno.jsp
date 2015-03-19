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

        <title>Convidar Membro Externo | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                            <h2>Convidar Membro Externo</h2>   
                            <h5>Preencha os campos abaixo para convidar um membro externo a participar da banca. </h5>
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Form Elements -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Convidar Membro Externo
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <form:form modelAttribute="membroExterno" action="/GekeTCC/membroExterno/enviarConvite" method="post">
                                                <div class="form-group">
                                                    <form:label path="nome">Nome</form:label>
                                                    <form:input path="nome" type="text" class="form-control" required="true" autofocus="true"/>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="email">E-mail</form:label>
                                                    <form:input path="email" id="email" type="email" required="true" class="form-control"/>
                                                </div> 
                                                <button class="btn btn-success" type="submit">Convidar</button>
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