<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-truck">&nbsp;New car sale </i></h3>

    </div>
    <div class="panel-body">

        <form id="firstStep" class="form-horizontal" method="post" action="<c:url value="/next"/>">
            <table class="table">
                <tr>
                    <td>
                        Car brand:
                    </td>
                    <td>
                        <select name="brand" class="form-control">
                            <option></option>
                            <c:forEach var="carBrand" items="${brands}">
                                <option>${carBrand.brandName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        Car model:
                    </td>
                    <td>
                        <select name="model" class="form-control">
                            <option></option>
                            <c:forEach var="carModel" items="${models}">
                                <option>${carModel.modelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        Car body:
                    </td>
                    <td>
                        <select name="body" class="form-control">
                            <option></option>
                            <c:forEach var="body" items="${bodyTypes}">
                                <option>${body.typeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Transmission:
                    </td>
                    <td>
                        <select name="transmission" class="form-control">
                            <option></option>
                            <c:forEach var="transmission" items="${transmissions}">
                                <option>${transmission.value}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>


            </table>
            <div class="pull-right">
                <ul class="pager">
                    <li><a href="#" onclick="document.getElementById('firstStep').submit();">Next&nbsp;<i
                            class="fa fa-arrow-circle-right"></i></a></li>
                    <%--<li><a href="#">Next</a></li>--%>
                </ul>
            </div>
        </form>
    </div>
</div>