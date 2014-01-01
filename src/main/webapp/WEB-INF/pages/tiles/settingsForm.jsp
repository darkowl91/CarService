<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">User profile settings</h3>
    </div>
    <div class="panel-body">

        <div class="media">
            <a href="#" class="pull-left">
                <img width="150px" height="150px" src="data:image/jpeg;base64,${user.picture.imageAsString}"
                     class="media-object" alt=''/></a>

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
                <label class="col-sm-2 control-label">Birthday:</label>

                <div class="col-sm-10">
                    <input class="form-control small" type="date" name="birthday"
                           value="${user.birthDay}"
                           required="">
                </div>
            </div>

            <div class="form-group ">


                <label class="col-sm-2 control-label">Operator:</label>

                <div class="col-sm-10">
                    <select class="form-control small" name="operator" id="operator" required="">
                        <option></option>
                        <option value="(017)">Белтелеком</option>
                        <option value="(29)">Velcome</option>
                        <option value="(44)">MTC</option>
                        <option value="(25)">Life</option>
                    </select>
                </div>
                <label class="col-sm-2 control-label">Number:</label>

                <div class="col-sm-10">
                    <input class="form-control small" type="tel"  name="number" required="">
                </div>
                <label class="col-sm-2 control-label">Type:</label>

                <div class="col-sm-10">
                    <select class="form-control small" name="type" required="">
                        <option></option>
                        <option value="home">Домашний</option>
                        <option value="work">Рабочий</option>
                        <option value="mobile">Мобильный</option>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <button type="reset" class="btn">Clear</button>
        </form>
    </div>
</div>
