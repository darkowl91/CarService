<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="modal fade" id="modal-container-937714" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                                <spring:message code="login.form.label.formName"/>
                            </h4>
                        </div>
                        <div class="modal-body">

                            <form method="post" action="<c:url value="/j_spring_security_check"/>" class="form-signin"
                                  role="form">
                                <h2 class="form-signin-heading">Please sign in</h2>

                                <input type="text" class="form-control" placeholder="Username" name="j_username"
                                       required="" autofocus="">

                                <input type="password" class="form-control" placeholder="Password" name="j_password"
                                       required="">

                                <label class="checkbox">
                                    <input type="checkbox" name="_spring_security_remember_me"/>Remember me
                                </label>
                                <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit"
                                        value="confirm">Sign in
                                </button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>