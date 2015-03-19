<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover" id="dev-table">
    <thead>
        <tr>
            <th>Aluno</th>
            <th>Orientador</th>
            <th>Tema</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="matricula" items="${matriculas}">
            <tr>
                <td>${matricula.aluno.nome}</td>
                <td>${matricula.orientador.nome}</td>
                <td>${matricula.tema}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>