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
                <td class="td-actions"><a
                        href='javascript:aceitarMatricula("${matricula.codigo}")'
                        class="btn btn-small btn-primary"> <i
                            class="fa fa-check"></i>
                    </a></td>
                <td class="td-actions"><a
                        href='javascript:rejeitarMatricula("${matricula.codigo}")'
                        class="btn btn-small btn-danger"> <i
                            class="fa fa-ban"></i>
                    </a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>