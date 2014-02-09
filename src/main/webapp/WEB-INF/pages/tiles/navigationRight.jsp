<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar-offcanvas" id="sidebar" role="navigation">
    <ul class="nav nav-pills nav-stacked">
        <li id="adverts">
            <a href="<c:url value="/carService/adverts"/>" class="list-group-item"><i class="fa fa-angle-left ">
                Advertisements</i></a>
        </li>
        <li id="news">
            <a href="<c:url value="/carService/news"/>" class="list-group-item"><i class="fa fa-angle-left">
                News</i></a>
        </li>
        <sec:authorize access="isAuthenticated()">
        <li id="sale">
            <a href="<c:url value="/carService/sale"/>" class="list-group-item"><i class="fa fa-angle-left"> Car
                Sale</i></a>
        </li>
        </sec:authorize>
        <li id="searchAdvert">
            <a href="<c:url value="/carService/searchAdvert"/>" class="list-group-item"><i class="fa fa-angle-left">
                Search</i></a>
        </li>
        <sec:authorize access="isAnonymous()">
            <li id="register">
                <a href="<c:url value="/carService/register"/>" class="list-group-item"><i class="fa fa-angle-left">
                    Registration</i></a>
            </li>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <li id="profileSettings">
                <a href="<c:url value="/carService/profileSettings"/>" class="list-group-item"><i
                        class="fa fa-angle-left">
                    Profile settings</i></a>
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