<%-- 
    Document   : matriculaArquivoAceitaRejeita
    Created on : 12/12/2014, 03:20:21
    Author     : Douglas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-lg-12">
    <form:form modelAttribute="matriculaArquivo">
        <div class="form-group">
            <form:label path="matricula.aluno.nome">Nome</form:label>
            <form:input path="matricula.aluno.nome" class="form-control" readonly="true"/>
        </div>
        <div class="form-group">
            <form:label path="matricula.tema">Tema</form:label>
            <form:input path="matricula.tema" type="text" class="form-control" readonly="true"/>
        </div>
        <div class="form-group">
            <a class="btn btn-default" type="button" href="/GekeTCC/matriculaArquivo/mostrarArquivo/<c:out value="${matriculaArquivo.codigo}"></c:out>">Visualizar PDF</a>
            </div>
            <div class="form-group">
                <a class="btn btn-success col-lg-6" type="button" href="/GekeTCC/matriculaArquivo/aceitar/<c:out value="${matriculaArquivo.codigo}"></c:out>">Aceitar</a>
            <a class="btn btn-danger col-lg-6" type="button" href="/GekeTCC/matriculaArquivo/rejeitar/<c:out value="${matriculaArquivo.codigo}"></c:out>">Rejeitar</a>
            </div>
    </form:form>
</div>