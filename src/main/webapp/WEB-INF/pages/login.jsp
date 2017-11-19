<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="tmp/header.jsp"%>

login
<br>

<c:url value="/login" var="var"/>
<form action="${var}" method="post">
    
    <c:if test="${param.error!=null}">
        <p>error!!!</p>
    </c:if>
    <c:if test="${param.logout!=null}">
        <p>logout succes</p>
    </c:if>

    <input type="text" name="username" placeholder="username">
    <input type="text" name="password" placeholder="password">
    <input type="submit" value="login">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
</form>

<%@include file="tmp/footer.jsp"%>

