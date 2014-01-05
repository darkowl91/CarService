<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

    <div class="navbar-header">
        <a class="navbar-brand" href="index.html"><spring:message code="header.label.brand"/></a>
    </div>

    <ul class="nav navbar-nav navbar-right navbar-user">
        <li class="dropdown user-dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                &nbsp;
                <i class="fa fa-user"></i>
                <sec:authorize access="isAnonymous()">
                    <spring:message code="header.label.signIn"/>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    ${user.username}
                </sec:authorize>
                <b class="caret"></b></a>

            <ul class="dropdown-menu">

                <sec:authorize access="isAnonymous()">
                    <li><a href="#modal-container-937714" role="button" data-toggle="modal"><i class="fa fa-user"></i>
                        <spring:message code="header.label.logIn"/></a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li><a href="#"><i class="fa fa-envelope"></i><spring:message code="header.label.Inbox"/>
                            <%--TODO: Add message option--%>
                        <span class="badge">7</span></a></li>
                    <li><a id="settings" href="<c:url value="/carService/profileSettings"/>"><i
                            class="fa fa-gear"></i><spring:message code="header.label.Settings"/></a></li>
                    <li class="divider"></li>

                    <li><a href="<c:url value="/j_spring_security_logout"/>"><i class="fa fa-power-off"></i>Log Out</a>
                    </li>
                </sec:authorize>
            </ul>
        </li>
    </ul>

</nav>
