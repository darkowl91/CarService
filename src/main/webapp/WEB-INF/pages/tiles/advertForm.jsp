<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Advertisement Form</h3>
    </div>
    <div class="panel-body">
        <div class="col-md-6 column ">
            <form name="registration-form" method="post" action="advert">
                <%--BRAND--%>
                <div class="field-box">
                    <label><spring:message code="label.Mark"/>:</label>
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--BRAND--%>
                <div class="field-box">
                    <label><spring:message code="label.Model"/>:</label>
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--PRODUCE YEAR--%>
                <div class="field-box">
                    <label><spring:message code="label.ProduceYear"/>:</label>
                    <select name="yearpicker" id="yearpicker" required class="form-control">
                        <script>
                            var myDate = new Date();
                            var year = myDate.getFullYear();
                            for (var i = 1900; i < year + 1; i++) {
                                document.write('<option value="' + i + '">' + i + '</option>');
                            }
                        </script>
                    </select>
                </div>
                <%--BODY TYPE--%>
                <div class="field-box">
                    <label><spring:message code="label.BodyType"/>:</label>
                    <select class="form-control required" required>
                        <option>1</option>
                    </select>
                </div>
                <%--TRANSMISSION--%>
                <div class="field-box">
                    <label><spring:message code="label.Transmission"/>:</label>
                    <select class="form-control" required>
                        <option>1</option>
                    </select>
                </div>
                <%--PRICE--%>
                <div class="field-box">
                    <label><spring:message code="label.Price"/>:</label>
                    <input class="form-control" type="text" required>
                </div>
                <%--NOTE --%>
                <div class="field-box">
                    <label> <spring:message code="label.AdditionalInfo"/>:</label>
                    <textarea class="form-control" rows="3" required></textarea>
                </div>

                <br/>
                <button type="submit" class="btn btn-primary"><spring:message code="btn.add"/></button>
                <button type="reset" class="btn btn-default"><spring:message code="btn.clear"/></button>
        </div>
        <div class="col-md-6 column">
            <%--PHOTO--%>
            <div class="field-box">
                <label><spring:message code="label.photo"/>:</label>
                <input type="file" class="btn btn-link" required>
            </div>

            <div class="row clearfix bottom well">
                <div class="col-md-4 column">
                    <a href="#">
                        <img src="http://lorempixel.com/64/64/" class="media-object" alt=''/></a>
                </div>
                <div class="col-md-4 column">
                    <a href="#">
                        <img src="http://lorempixel.com/64/64/" class="media-object" alt=''/></a>
                </div>
                <div class="col-md-4 column">
                    <a href="#">
                        <img src="http://lorempixel.com/64/64/" class="media-object" alt=''/></a>
                </div>
            </div>
        </div>
        </form>
    </div>
</div>