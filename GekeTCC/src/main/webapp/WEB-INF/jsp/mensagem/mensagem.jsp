<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="pt">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description"
              content="UNIPAMPA" />
        <meta name="author" content="" />

        <title>Status Processo | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
            <c:import url="../estrutura/menu.jsp"></c:import>
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-12">
                                <h2>Status do Processo</h2>   
                                <h3><c:out value="${param.mensagem}"></c:out></h3>
                                </div>                     
                            </div>
                            <hr />
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