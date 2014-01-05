<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-lg-12">
        <h1>Blank Page
            <small>A Blank Slate</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${BreadCrumbs.link}"><i class="icon-dashboard"></i><spring:message key="${BreadCrumbs.value}"/>
            </a></li>
            <li class="active"><i class="icon-file-alt"></i> Blank Page</li>
        </ol>
    </div>
</div>
