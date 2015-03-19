<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover" id="dev-table">
    <thead>
        <tr>
            <th>Código</th>
            <th>Nome do Orientador</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="orientador" items="${orientadores}">
            <tr>
                <td>${orientador.codigo}</td>
                <td>${orientador.nome}</td>
                <td>${orientador.email}</td>
                <td class="td-actions"><a
                        href='javascript:selecionarOrientador("${orientador.codigo}","${orientador.nome}")'
                        class="btn btn-small btn-primary"> <i
                            class="fa fa-check"></i>
                    </a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>