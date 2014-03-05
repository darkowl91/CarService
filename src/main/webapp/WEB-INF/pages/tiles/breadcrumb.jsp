<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-lg-12">
        <h1><spring:message code="label.auto.sale"/>
            <small><spring:message code="label.sale"/></small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${BreadCrumbs.link}"><i class="icon-dashboard"></i>
                <%--<spring:message code="${BreadCrumbs.value}"/>--%>
            </a></li>
            <li class="active"><i class="icon-file-alt"></i><spring:message code="label.auto.sale.page.name"/></li>
        </ol>
    </div>
</div>
