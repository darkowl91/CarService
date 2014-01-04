<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">User profile settings</h3>
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

                <p>FirstName: ${user.firstName}</p>

                <p>LastName: ${user.lastName}</p>

                <p>Email: ${user.email}</p>

                <p>Registration date: ${user.registrationDate}</p>
            </div>
        </div>
        <br/>


        <form class="form-horizontal" role="form" method="post" action="<c:url value="/editProfile"/>">
            <div class="form-group">
                <label class="col-sm-2 control-label">Birthday: ${user.birthDay}</label>

                <div class="col-sm-10">
                    <input class="form-control small" type="date" name="birthday" value="${user.birthDay}">
                </div>
            </div>

            <label class="control-label">Phone: (+375) Belarus </label>
            <table class="table">
                <c:forEach var="i" begin="0" end="2">
                    <tr>
                        <td>
                            <label class="control-label">Operator:</label>
                        </td>
                        <td>
                            <select class="form-control" name="operator_${i}" id="operator">
                                <option></option>
                                <option value="(017)">Белтелеком</option>
                                <option value="(29)">Velcome</option>
                                <option value="(44)">MTC</option>
                                <option value="(25)">Life</option>
                            </select>
                        </td>
                        <td>
                            <label class="control-label">Number:</label>
                        </td>
                        <td>
                            <input class="form-control" type="tel" name="number_${i}">
                        </td>
                        <td>
                            <label class="control-label">Type:</label>
                        </td>
                        <td>
                            <select class="form-control" name="type_${i}">
                                <option></option>
                                <option value="home">Домашний</option>
                                <option value="work">Рабочий</option>
                                <option value="mobile">Мобильный</option>
                            </select>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button type="submit" class="btn btn-primary">Save</button>
            <button type="reset" class="btn">Clear</button>
        </form>
    </div>
</div>
