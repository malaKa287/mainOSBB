<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="commentBlock">
    <c:forEach items="${News.newsComment}" var="Comment">
        <p1>${Comment.userName}  ${Comment.time}</p1>
        <br>
        ${Comment.commentValue}
        <br>
    </c:forEach>

    <sec:authorize access="hasAnyRole('USER')">
    <form action="/addComment" method="post">
        <input type="hidden" name="id" value="${News.id}">
        <input type="text" name="commentValue">
        <input type="submit" value="addComment">
    </form>
    </sec:authorize>
</div>