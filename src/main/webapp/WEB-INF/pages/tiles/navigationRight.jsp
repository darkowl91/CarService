<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar-offcanvas" id="sidebar" role="navigation">
    <div class="list-group">
        <a id="adverts" href="<c:url value="/carService/adverts"/>" class="list-group-item">Advertisements</a>
        <a id="news" href="<c:url value="/carService/news"/>" class="list-group-item">News</a>
        <a id="sale" href="<c:url value="/carService/sale"/>" class="list-group-item">Car Sale</a>
        <a id="searchAdvert" href="<c:url value="/carService/searchAdvert"/>" class="list-group-item">Search</a>
        <sec:authorize access="isAnonymous()">
            <a id="register" href="<c:url value="/carService/register"/>" class="list-group-item">Registration</a>
        </sec:authorize>
    </div>
</div>

<script>
    $(document).ready(function () {
        var element = document.getElementById('${BreadCrumbs.id}');
        $(element).addClass("active");
    });
</script>