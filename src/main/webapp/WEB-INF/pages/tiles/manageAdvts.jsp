<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-clock-o"></i><spring:message code="label.recent.activity"/></h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover table-striped tablesorter">
            <thead>
            <tr>
                <th class="header"></th>
                <th class="header"><spring:message code="label.date.added"/><i class="fa fa-sort"></i></th>
                <th class="header"><spring:message code="label.user"/><i class="fa fa-sort"></i></th>
                <th class="header"><spring:message code="label.auto"/><i class="fa fa-sort"></i></th>
                <th class="header"></th>
            </tr>
            </thead>
            <tbody>
            <%--<form method="post" action="<c:out value="/advtDelete"/>" role="form">--%>
            <c:forEach var="advt" items="${advtToDelete}">
                <tr>
                    <td>
                        <a href="/advtDelete?advtId=${advt.id}"><i class="fa fa-ban"></i></a>
                        <%--<input name="deleteAdvt_${advt.id}"  type="checkbox" value="${advt.id}" class="btn btn-danger">--%>
                    </td>
                        <td>${advt.date}</td>
                    <td>${advt.user.firstName} ${advt.user.lastName}</td>
                    <td>${advt.car.model.brand.brandName} ${advt.car.model.modelName}</td>
                    <td>
                        <a href="#modal-container-delete${advt.id}" data-toggle="modal">
                            <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            <%--</form>--%>
            </tbody>
        </table>

        <c:forEach var="advt" items="${advtToDelete}">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="modal fade" id="modal-container-delete${advt.id}" role="dialog"
                             aria-labelledby="myModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">
                                            <spring:message code="advt.header"/> ${advt.date}
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        <div id="myCarousel-${advt.id}" class="carousel slide">

                                            <div class="carousel-inner">
                                                <c:forEach var="carPicture" items="${advt.car.pictures}" end="0">
                                                    <div class="item active">
                                                        <img src="data:image/jpeg;base64,${carPicture.imageAsString}"
                                                             alt=''>
                                                    </div>
                                                </c:forEach>
                                                <c:forEach var="carPicture" items="${advt.car.pictures}" begin="1">
                                                    <div class="item">
                                                        <img src="data:image/jpeg;base64,${carPicture.imageAsString}"
                                                             alt=''>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <a class="left carousel-control" href="#myCarousel-${advt.id}"
                                               data-slide="prev">‹</a>
                                            <a class="right carousel-control" href="#myCarousel-${advt.id}"
                                               data-slide="next">›</a>
                                        </div>
                                        <table class="table">
                                            <tr>
                                                <td>
                                                    <spring:message code="label.Mark"/>
                                                </td>
                                                <td>
                                                        ${advt.car.model.brand.brandName}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <spring:message code="label.Model"/>
                                                </td>
                                                <td>
                                                        ${advt.car.model.modelName}
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <spring:message code="label.ProduceYear"/>
                                                </td>
                                                <td>
                                                    ${advt.car.produceYear}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <spring:message code="label.BodyType"/>
                                                </td>
                                                <td>
                                                        ${advt.car.body.typeName}
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <spring:message code="label.Transmission"/>
                                                </td>
                                                <td>
                                                        ${advt.car.transmission.value}
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <spring:message code="label.Price"/>
                                                </td>
                                                <td>
                                                        ${advt.car.price}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <spring:message code="AdditionalInfo"/>
                                                </td>
                                                <td>
                                                        ${advt.note}
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
