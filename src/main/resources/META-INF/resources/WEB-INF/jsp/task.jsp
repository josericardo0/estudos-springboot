<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Pagina de inserir tarefa</title>
</head>
<body>
    <div class="container">
        <h1>Adicione os detalhes das tarefas</h1>
        <form:form method="post" modelAttribute="task">
            Descricao: <form:input type="text" path="descricao" required="required"/>
            <form:errors path="descricao" cssClass="text-warning"/>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="feito"/>
            <input type="submit" class="btn btn-success" value="Submit"/>
        </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
