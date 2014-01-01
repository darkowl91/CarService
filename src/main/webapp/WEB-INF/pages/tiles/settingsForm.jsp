<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row clearfix">

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">${user.username}: Profile settings</h3>
        </div>
        <div class="panel-body">

            <div class="col-md-6 column">
                <form name="registration-form" method="post" action="<c:url value="/editProfile"/>">
                    <div class="field-box">
                        <label>Birthday:</label>
                        <input class="form-control" type="date" name="birthday" required="">
                    </div>
                    <br/>

                    <div class="field-box ">
                        <label>Phone: (+375) Беларусь</label>

                        <div class="field-box well">
                            <label>Operator:</label>
                            <select class="form-control" name="operator" required="">
                                <option></option>
                                <option value="(017)">Белтелеком</option>
                                <option value="(29)">Velcome</option>
                                <option value="(44)">MTC</option>
                                <option value="(25)">Life</option>
                            </select>

                            <label>Number:</label>
                            <input id="phone" type="tel" name="number" class="form-control" required="">

                            <label>Type:</label>
                            <select class="form-control" name="operator" required="">
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
    </div>
</div>
