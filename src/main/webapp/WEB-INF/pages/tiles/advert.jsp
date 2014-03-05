<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="advt" items="${PAGE.content}">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-calendar"></i><spring:message code="advt.header"/> ${advt.date}
            </h3>
        </div>
        <div class="panel-body">
            <div class="media">
                <a href="#" class="pull-left">
                    <img height="64px" width="64px" src="data:image/jpeg;base64,${advt.user.picture.imageAsString}"
                         class="media-object" alt=''/></a>

                <div class="media-body">
                    <address>
                        <h4 class="media-heading">
                            <spring:message code="advt.user.info"/>
                        </h4>
                        <strong> <i class="fa fa-user"></i> ${advt.user.firstName} ${advt.user.lastName}</strong>
                        <br/>
                        <i class="fa fa-phone"></i>
                        <abbr title="Phone"><spring:message code="advt.user.phones"/>:</abbr>
                        <c:forEach var="phone" items="${advt.user.phones}">
                            ${phone.operator} ${phone.phoneValue};
                        </c:forEach>
                    </address>
                        <%--CAR INFO--%>
                    <div class="media">
                        <a href="#" class="pull-left">
                            <c:forEach var="carPicture" items="${advt.car.pictures}" end="0">
                                <img height="64px" width="64px"
                                     src="data:image/jpeg;base64,${carPicture.imageAsString}"
                                     class="media-object" alt=''/>
                            </c:forEach>
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                    ${advt.car.model.brand.brandName} ${advt.car.model.modelName}
                                <script>
                                    var date = "${advt.car.produceYear}";
                                    var parts = date.split('-');
                                    document.write(parts[0]);
                                </script>
                                г.
                            </h4>
                            <i class="fa fa-comment"></i>
                            <spring:message code="advt.note"/>:
                                ${advt.note}
                            <br/>
                            <i class="fa fa-dollar"></i>
                            <spring:message code="advt.price"/>:
                                ${advt.car.price}
                        </div>
                    </div>
                </div>
            </div>
            <a class="btn btn-primary btn-xs pull-right" href="#modal-container-${advt.id}" data-toggle="modal"><spring:message code="advt.learn.more"/></a>
        </div>
    </div>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="modal fade" id="modal-container-${advt.id}" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">
                                    <spring:message code="advt.header"/> ${advt.date}
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div id="myCarousel-${advt.id}" class="carousel slide">

                                    <div class="carousel-inner">
                                        <c:forEach var="carPicture" items="${advt.car.pictures}" end="0">
                                            <div class="item active">
                                                <img src="data:image/jpeg;base64,${carPicture.imageAsString}" alt=''>
                                            </div>
                                        </c:forEach>
                                        <c:forEach var="carPicture" items="${advt.car.pictures}" begin="1">
                                            <div class="item">
                                                <img src="data:image/jpeg;base64,${carPicture.imageAsString}" alt=''>
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
                                            <script>
                                                var date = "${advt.car.produceYear}";
                                                var parts = date.split('-');
                                                document.write(parts[0]);
                                            </script>
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
                                        <spring:message code="label.AdditionalInfo"/>
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
<div class="text-center">
    <ul class="pagination">
        <li class="disabled"><a href="">«</a></li>
        <c:forEach var="i" begin="1" end="${PAGE.totalPages}">
            <li id="page_${i}"><a href="/carService/adverts/page?pageNumber=${i}">${i}</a></li>
        </c:forEach>
        <li class="disabled"><a  href="">»</a></li>
    </ul>
</div>
<script>
    $(document).ready(function () {
        var element = document.getElementById('page_${PAGE.pageNumber}');
        $(element).addClass("active");
    });
</script>
