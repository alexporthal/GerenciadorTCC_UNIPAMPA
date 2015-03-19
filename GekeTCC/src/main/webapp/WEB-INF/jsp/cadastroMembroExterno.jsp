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

        <title>Cadastro Membro Externo | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">GekeTCC</a> 
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> <a href="#" class="btn btn-success square-btn-adjust">Login</a> </div>
            </nav>   
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Cadastro de Membro Externo</h2>   
                            <h5>Você foi convidado para ser membro de uma banca de TCC. </h5>
                            <h6>Porem não está cadastrado no sistema. Por favor, preencha o formulário para confirmar presença e poder ter um usuário para acompanhamento da avaliação de TCC.</h6>
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
                                            <form:form modelAttribute="membroExterno" action="/GekeTCC/membroExterno/salvar" method="post">
                                                <div class="form-group">
                                                    <form:label path="codigo">Código</form:label>
                                                    <form:input path="codigo" class="form-control" readonly="true"/>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="nome">Nome</form:label>
                                                    <form:input path="nome" type="text" class="form-control" required="true"/>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="instituicao">Instituição</form:label>
                                                    <form:input path="instituicao" type="text" class="form-control" required="true"/>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="email">E-mail</form:label>
                                                    <form:input path="email" id="email" type="email" class="form-control"  readonly="true"/>
                                                </div> 
                                                <div class="form-group">
                                                    <form:label path="usuario.login">Login</form:label>
                                                    <form:input path="usuario.login" id="login" type="text" class="form-control" readonly="true"/>
                                                </div>
                                                <div class="form-group">
                                                    <form:label path="usuario.senha">Senha</form:label>
                                                    <form:input path="usuario.senha" type="password" class="form-control" required = "true"/>
                                                </div> 
                                                <button class="btn btn-success" type="submit">Enviar</button>
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