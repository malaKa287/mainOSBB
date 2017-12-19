<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/"><i class="fa fa-circle"></i>SBB</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <sec:authorize access="isAnonymous()">
                    <li class="active"><a href="/login"> Увійти </a></li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('USER','ADMIN')">
                    <li class="active"><a href="/logout"> Вийти </a></li>
                </sec:authorize>

                <sec:authorize access="hasAnyRole('USER')">
                    <li><a href="/cabinet"><i class="fa fa-envelope-o" aria-hidden="true">Кабінет</i></a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</div>
