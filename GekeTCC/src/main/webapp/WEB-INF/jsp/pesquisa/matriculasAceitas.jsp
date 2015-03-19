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
                        href='javascript:abrirDefesa("${matricula.codigo}")'
                        class="btn btn-small btn-info"> <i
                            class="fa fa-list-alt"></i>
                    </a></td>
                <td class="td-actions"><a
                        href='javascript:abrirBanca("${matricula.codigo}")'
                        class="btn btn-small btn-info"> <i
                            class="fa fa-list"></i>
                    </a></td>
                <td class="td-actions"><a title="Agenda Banca" alt="Agenda Banca"
                                          href='#' onclick="abrirAgendaBanca('${matricula.codigo}')"
                                          class="btn btn-small btn-info"   data-toggle="modal" data-target="#modalDados"> <i
                            class="fa fa-calendar"></i>
                    </a></td>
                <td class="td-actions"><a title="Vizualização TCC" alt="Visualizar arquivo TCC"
                                          href='#' onclick="abrirVisualizacaoArquivos('${matricula.codigo}')"
                                          class="btn btn-small btn-info"  data-toggle="modal" data-target="#modalDados"> <i
                            class="fa fa-file-text-o"></i>
                    </a></td>

            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="modalDados" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title"><div id="tituloDados"></div></h4>
            </div>
            <div class="modal-body">
                <div class="progress progress-striped active" id="carregando">
                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                        <span class="sr-only">Carregando</span>
                    </div>
                </div>
                <div id="dados"></div>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function abrirVisualizacaoArquivos(idMatricula) {
        $('#dados').html("");
        $('#carregando').css({display:"block"});
        $('#tituloDados').html("Trabalho de Conclusão do Curso");
        $.get("<c:url value="/matriculaArquivo/visualizarArquivo?matricula=" />" + idMatricula, function (data) {
            $('#dados').html(data);
            $('#carregando').css({display:"none"});
        });
    }
</script>
<script type="text/javascript">
    function abrirAgendaBanca(idMatricula) {
        $('#dados').html("");
        $('#carregando').css({display:"block"});
        $('#tituloDados').html("Agenda Banca");
        $.get("<c:url value="/agendaBanca/agendar?matricula=" />" + idMatricula, function (data) {
            $('#dados').html(data);
            $('#carregando').css({display:"none"});
        });
    }
</script>