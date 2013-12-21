<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <tiles:insertAttribute name="css_resources"/>

    <title><tiles:insertAttribute name="title"/></title>

</head>
<body>
<tiles:insertAttribute name="header"/>

<%--MODAL --%>
<tiles:insertAttribute name="header_login_modal"/>
<%--MODAL END--%>

<div id="page-wrapper">
    <tiles:insertAttribute name="breadcrumb"/>
    <div class="clearfix">

        <div class="col-md-3 column">
            <tiles:insertAttribute name="navRight"/>
        </div>

        <div class="col-md-6 column">
            <tiles:insertAttribute name="advert"/>
        </div>

        <div class="col-md-3 column">
            <tiles:insertAttribute name="navLeft"/>
        </div>

    </div>
</div>
<tiles:insertAttribute name="footer"/>
<tiles:insertAttribute name="js_resources"/>
</body>
</html>