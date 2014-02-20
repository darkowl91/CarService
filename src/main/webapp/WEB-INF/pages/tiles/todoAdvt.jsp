<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="panel panel-warning">
    <div class="panel-heading">
        <div class="row">
            <div class="col-xs-6">
                <i class="fa fa-check fa-5x"></i>
            </div>
            <div class="col-xs-6 text-right">
                <p class="announcement-heading">${advtToVerifyCount}</p>

                <p class="announcement-text">To-Do Items</p>
            </div>
        </div>
    </div>
    <a href="<c:url value="/carService/manageAdvts/verify"/>">
        <div class="panel-footer announcement-bottom">
            <div class="row">
                <div class="col-xs-6">
                    Complete Tasks
                </div>
                <div class="col-xs-6 text-right">
                    <i class="fa fa-arrow-circle-right"></i>
                </div>
            </div>
        </div>
    </a>
</div>

