<%-- 
    Document   : agendaBanca
    Created on : 20/12/2014 02:28:58
    Author     : Douglas Giordano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-12">
    <form:form  modelAttribute="banca" id="form">
        <div class="form-group">
            <form:label path="codigo"> Código </form:label><br> 
            <form:input path="codigo" class="form-control" type="text" readonly="true"/>
        </div>
        <div class="form-group">
            <form:label path="matricula.codigo"> Matrícula </form:label><br> 
            <form:input path="matricula.codigo" class="form-control" type="text" readonly="true"/>
        </div>
        <div class="form-group">
            <form:label path="matricula.tema"> Tema </form:label><br> 
            <form:input path="matricula.tema" class="form-control" type="text" readonly="true"/>
        </div>
        <div class="form-group">
            <form:label path="hora"> Horário </form:label><br> 
            <form:input path="hora" class="form-control" name="hora" type="time" id="hora" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="data" > Data</form:label> <br>
            <form:input path="data" class="form-control" name="data" type="date" required="true"/>
        </div>
        <div class="form-group">
            <form:label path="local" > Local</form:label>
            <form:input  path="local"  class="form-control"  name="local" type="text" id="local" placeholder="Local" required="true"/>
        </div>                                                                                                                                                 
        <button class="btn btn-success" type="button" id="salvar">Salvar</button>
    </form:form>
</div>
<script type="text/javascript">
    $("#salvar").click(function () {
        $('#carregando').css({display:"block"});
        $('#tituloDados').html("Mensagem");
        $.ajax({
            type: "POST",
            data: $("#form").serialize(),
            url: "/GekeTCC/agendaBanca/salvar",
            success: function (result) {
                $('#dados').html(result);
            },
            beforeSend: function () {
            },
            complete: function (msg) {
                $('#carregando').css({display:"none"});
            }
        });

    });
</script>


