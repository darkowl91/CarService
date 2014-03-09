<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"><spring:message code="label.user.profile.setttings"/></h3>
    </div>
    <div class="panel-body">

        <div class="media">
            <a href="#" class="pull-left">
                <c:if test="${not empty user.picture.imageAsString}">
                <img width="150px" height="150px" src="data:image/jpeg;base64,${user.picture.imageAsString}"
                     class="media-object" alt=''/></a>
            </c:if>

            <c:if test="${empty user.picture.imageAsString}">
                <img width="150px" height="150px" src="<c:url value="/resources/design/img/no_user1.png"/>"
                     class="media-object" alt=''/></a>
            </c:if>

            <div class="media-body">
                <h4 class="media-heading">${user.username}</h4>

                <p><spring:message code="label.user.name"/>: ${user.firstName}</p>

                <p><spring:message code="label.user.surname"/>: ${user.lastName}</p>

                <p><spring:message code="label.user.email"/>: ${user.email}</p>

                <p><spring:message code="label.user.registration.date"/>:
                    <script>
                        var date = new Date(${user.registrationDate.getTimeInMillis()});
                        var theyear = date.getFullYear()
                        var themonth = date.getMonth() + 1
                        var thetoday = date.getDate()
                        document.write(theyear + "-" + themonth + "-" + thetoday);
                    </script>
                 </p>
            </div>
        </div>
        <br/>


        <form class="form-horizontal" role="form" method="post" action="<c:url value="/editProfile"/>">
            <div class="form-group">
                <label class="col-sm-2 control-label"><spring:message code="label.user.birthday"/>: </label>

                <div class="col-sm-10">
                    <input class="form-control small" type="date" name="birthday" value="${user.birthDay}">
                </div>
            </div>

            <label class="control-label"><spring:message code="label.phone"/>: <spring:message code="label.user.country"/> </label>
            <table class="table">
                <c:forEach var="i" begin="0" end="2">
                    <tr>
                        <td>
                            <label class="control-label">Operator:</label>
                        </td>
                        <td>
                            <select class="form-control" name="operator_${i}" id="operator_${i}">
                                <option></option>
                                <option value="(017)">Белтелеком</option>
                                <option value="(29)">Velcome</option>
                                <option value="(44)">MTC</option>
                                <option value="(25)">Life</option>
                            </select>
                            <script>
                                $("#operator_${i}").val("${user.phones[i].operator}");
                            </script>
                        </td>
                        <td>
                            <label class="control-label"><spring:message code="label.user.phone.number"/>:</label>
                        </td>
                        <td>
                            <input class="form-control" type="tel" name="number_${i}" value="${user.phones[i].phoneValue}">
                        </td>
                        <td>
                            <label class="control-label"><spring:message code="label.user.phone.type"/>:</label>
                        </td>
                        <td>
                            <select class="form-control" id="type_${i}" name="type_${i}">
                                <option></option>
                                <option value="home">Домашний</option>
                                <option value="work">Рабочий</option>
                                <option value="mobile">Мобильный</option>
                            </select>
                            <script>
                                $("#type_${i}").val("${user.phones[i].type}");
                            </script>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit" class="btn btn-primary"><spring:message code="btn.save"/></button>
            <button type="reset" class="btn"><spring:message code="btn.clear"/></button>
        </form>
    </div>
</div>
