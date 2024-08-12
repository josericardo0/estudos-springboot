<%@ include file="common/navigation.jspf" %>
<%@ include file="common/header.jspf" %>

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
    <%@ include file="common/footer.jspf" %>
    <script type="text/javascript">
    $('#dataAlvo').datepicker({
    format: 'yyyy-mm-dd'
    });
    </script>
</body>
</html>
