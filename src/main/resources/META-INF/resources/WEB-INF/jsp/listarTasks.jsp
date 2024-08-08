<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<title>Lista de tarefas</title>
</head>
<body>
    <div class="container">
    <h1>Suas tarefas</h1>
    <table class="table">
    <thead>
        <tr>
        <th>id</th>
        <th>Descricao</th>
        <th>Data Alvo</th>
        <th>Feito?</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items = "${tasks}" var="task">
            <tr>
            <td>${task.id}</td>
            <td>${task.descricao}</td>
            <td>${task.dataAlvo}</td>
            <td>${task.feito}</td>
            <td> <a href="deletar-task?id=${task.id}" class="btn btn-warning">Deletar</a></td>
            <td> <a href="atualizar-task?id=${task.id}" class="btn btn-success">Atualizar</a></td>

            </tr>
    </c:forEach>
    </tbody>
    </table>
    <a href="add-tarefa" class="btn btn-success">Adicionar tarefa</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
