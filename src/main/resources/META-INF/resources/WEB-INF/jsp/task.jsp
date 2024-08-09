<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">

    <title>Pagina de inserir tarefa</title>
</head>
<body>
    <div class="container">
        <h1>Adicione os detalhes das tarefas</h1>
        <form:form method="post" modelAttribute="task">

        <fieldset class="mb-3">
            <form:label path="descricao">Descricao</form:label>
            <form:input type="text" path="descricao" required="required"/>
            <form:errors path="descricao" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="dataAlvo">Data Alvo</form:label>
            <form:input type="text" path="dataAlvo" required="required"/>
            <form:errors path="dataAlvo" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="feito"/>
        <input type="submit" class="btn btn-success" value="Submit"/>
        </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

    <script type="text/javascript">
    $('#dataAlvo').datepicker({
    format: 'yyyy-mm-dd'
    });
    </script>

</body>
</html>
