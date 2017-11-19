<%@include file="tmp/header.jsp"%>

index page
<br>

<form action="/save" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <%--<input type="text" name="passwordConfrim" placeholder="passwordConfrim">--%>
    <input type="email" name="email" placeholder="email">
    <input type="submit" value="save">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<%@include file="tmp/footer.jsp"%>
