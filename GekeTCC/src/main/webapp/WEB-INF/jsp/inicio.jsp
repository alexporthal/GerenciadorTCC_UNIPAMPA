<%-- 
    Document   : inicio
    Created on : 06/12/2014, 16:20:17
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

            <title>Login Acesso ao Sistema | GekeTCC: Gerenciador de Trabalhos de Conclusão</title>

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
        </body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top navbar-inverse" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation </span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/GekeTCC/">GekeTCC </a> 
                </div>
                <div style="color: black;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> 
                    <label style="color: #ffffff; font-size: 20px">Gerenciador de Trabalhos de Conclusão de Curso</label>

                </div>

            </nav>
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Seja bem vindo ao "GekeTCC":<br> </h2>

                            <br>    
                            <h5>Para realizar o login no sistema, insira seus dados nos campos abaixo correspondentes. </h5>

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
                                                <form:form  action="/GekeTCC/login/efetuaLogin" method="post">

                                                    <div class="form-group">
                                                        <label> Usuário </label><br> <input name="login" type="text" id="nomeUser" placeholder="Digite Usuário" required>

                                                    </div>
                                                    <div class="form-group">
                                                        <label> Senha</label> <br><input name="senha" type="password" id="passwordUser" placeholder="Digite sua Senha" required>
                                                    </div>
                                                    <button class="btn btn-success" type="submit">Entrar</button>
                                                </form:form>

                                            </div>
                                        </div>   
                                        </html>
