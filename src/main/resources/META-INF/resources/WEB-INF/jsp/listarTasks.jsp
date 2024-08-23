<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>

<div class="container">
    <h1>Suas tarefas</h1>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Descricao</th>
                <th>Data Alvo</th>
                <th>Feito?</th>
                <th>Acoes</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.descricao}</td>
                    <td>${task.dataAlvo}</td>
                    <td>${task.feito}</td>
                    <td>
                        <a href="deletar-task?id=${task.id}" class="btn btn-warning">Deletar</a>
                        <a href="atualizar-task?id=${task.id}" class="btn btn-success">Atualizar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-tarefa" class="btn btn-success">Adicionar tarefa</a>
</div>

<%@ include file="common/footer.jspf" %>
</body>
</html>
