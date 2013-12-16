<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
    <div class="col-lg-12">
        <h1>Motors
            <small>Dashboard</small>
        </h1>
        <ol class="breadcrumb">
            <c:forEach var="bc" items="${breadcrumb.breadCrumbs}" varStatus="status">
                <c:choose>
                    <c:when test="${status.index==0}">
                        <li><a id="first" href="\">Dashboard</a></li>
                    </c:when>
                    <c:when test="${status.index == fn:length(breadcrumb.breadCrumbs)-1 && status.index!=0}">
                        <li id="active">${bc.name}</li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${bc.value}">${bc.name}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ol>
    </div>
</div>
