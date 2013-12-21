<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

    <div class="navbar-header">
        <a class="navbar-brand" href="index.html"><spring:message code="header.label.brand"/></a>
    </div>

    <ul class="nav navbar-nav navbar-right navbar-user">
        <li class="dropdown user-dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <i class="fa fa-user"></i>&nbsp;<spring:message code="header.label.signIn"/><b class="caret"></b></a>

            <ul class="dropdown-menu">
                <li><a href="#modal-container-937714" role="button" data-toggle="modal"><i class="fa fa-user"></i> <spring:message code="header.label.logIn"/></a></li>
                <li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>
                <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
            </ul>
        </li>
    </ul>
</nav>
