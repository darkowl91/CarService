<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="advt" items="${PAGE.content}">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-dollar "></i> <spring:message code="advt.header"/> ${advt.date}</h3>
        </div>
        <div class="panel-body">
            <div class="media">
                <a href="#" class="pull-left">
                    <img height="64px" width="64px" src="data:image/jpeg;base64,${advt.user.picture.imageAsString}" class="media-object"
                         alt=''/></a>

                <div class="media-body">
                    <h4 class="media-heading">
                        ${advt.user.username}
                    </h4>
                        ${advt.user.email}
                    <div class="media">
                        <a href="#" class="pull-left">
                         <c:forEach var="carPicture" items="${advt.car.pictures}">
                            <img height="64px" width="64px" src="data:image/jpeg;base64,${carPicture.imageAsString}" class="media-object" alt=''/>
                        </c:forEach>
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                    ${advt.car.model.brand.brandName} ${advt.car.model.modelName} ${advt.car.produceYear}
                            </h4>
                                ${advt.note}
                            <p>${advt.car.price}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


<%--PAGES--%>
<div class="text-center">
    <ul class="pagination">
        <li class="disabled"><a href="#">«</a></li>
        <c:forEach var="i" begin="1" end="${PAGE.totalPages}">
            <%--<li class="active"><a href="#">1</a></li>--%>
            <li><a href="#">${i}</a></li>
        </c:forEach>
        <li><a href="#">»</a></li>
    </ul>
</div>