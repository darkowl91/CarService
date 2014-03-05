<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar-offcanvas" id="sidebar" role="navigation">
    <ul class="nav nav-pills nav-stacked">
        <li id="adverts">
            <a href="<c:url value="/carService/adverts"/>" class="list-group-item"><i class="fa fa-angle-left ">
               <spring:message code="label.advertisements"/></i></a>
        </li>

        <%--<li id="news">--%>
            <%--<a href="<c:url value="/carService/news"/>" class="list-group-item"><i class="fa fa-angle-left">--%>
                <%--News</i></a>--%>
        <%--</li>--%>

        <sec:authorize access="hasRole('ROLE_USER')">
        <li id="sale">
            <a href="<c:url value="/carService/sale"/>" class="list-group-item"><i class="fa fa-angle-left">
                <spring:message code="label.advertisements"/></i></a>
        </li>
        </sec:authorize>

        <li id="searchAdvert">
            <a href="<c:url value="/carService/searchAdvert"/>" class="list-group-item"><i class="fa fa-angle-left">
                <spring:message code="label.search"/></i></a>
        </li>

        <sec:authorize access="isAnonymous()">
            <li id="register">
                <a href="<c:url value="/carService/register"/>" class="list-group-item"><i class="fa fa-angle-left">
                    <spring:message code="label.registration"/></i></a>
            </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_USER')">
            <li id="profileSettings">
                <a href="<c:url value="/carService/profileSettings"/>" class="list-group-item"><i
                        class="fa fa-angle-left">
                    <spring:message code="label.profile.settings"/></i></a>
            </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li id="manageAdvts">
                <a href="<c:url value="/carService/manageAdvts"/>" class="list-group-item"><i class="fa fa-angle-left">
                    <spring:message code="label.manage.advts"/></i></a>
            </li>
        </sec:authorize>
    </ul>
</div>

<script>
    $(document).ready(function () {
        var element = document.getElementById('${BreadCrumbs.id}');
        $(element).addClass("active");
    });
</script>