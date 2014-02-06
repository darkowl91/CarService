<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row clearfix">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-search"></i>Search</h3>
        </div>
        <div class="panel-body">
            <form name="registration-form" method="post" class="form-inline" action="searchAdvt">
                <%--BRAND--%>
                <div class="field-box">
                    <label>Car brand:</label>
                    <select id="brand" name="brand" class="form-control" onchange="doAjax();">
                        <option></option>
                        <c:forEach var="carBrand" items="${brands}">
                            <option value="${carBrand.id}">${carBrand.brandName}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--MODEL--%>
                <div class="field-box">
                    <label>Car model:</label>
                    <select id="model" name="model" class="form-control">
                        <option></option>
                        <c:forEach var="model" items="${advt.car.model.brand.models}">
                            <option value="${model.id}">${model.modelName}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--PRODUCE YEAR--%>
                <div class="field-box">
                    <label>Produce year:</label>
                    <select name="year" id="yearpicker" class="form-control">
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
                    <label>Body Type:</label>
                    <select id="body" name="body" class="form-control">
                        <option></option>
                        <c:forEach var="body" items="${bodyTypes}">
                            <option value="${body.id}">${body.typeName}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--TRANSMISSION--%>
                <div class="field-box">
                    <label>Transmission:</label>
                    <select id="transmission" name="transmission" class="form-control">
                        <option></option>
                        <c:forEach var="transmission" items="${transmissions}">
                            <option value="${transmission}">${transmission.value}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--PRICE--%>
                <div class="field-box">

                    <label>Price:</label>
                    <table>
                        <tr>
                            <td>
                                <label for="priceFrom">From:</label>
                            </td>
                            <td>
                                <select name="prise_From" id="priceFrom" class="form-control input-sm">
                                    <script>
                                        for (var i = 501; i < 55001; i+=1000) {
                                            document.write('<option value="' + i + '">' + i + '</option>');
                                        }
                                    </script>
                                </select>
                            </td>

                            <td colspan="50">
                                <label for="priceTo">To:</label>
                            </td>
                            <td>
                                <select name="price_To" id="priceTo" class="form-control input-sm">
                                    <script>
                                        for (var i = 501; i < 55001; i+=1000) {
                                            document.write('<option value="' + i + '">' + i + '</option>');
                                        }
                                    </script>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>

                <br/>
                <button type="submit" class="btn btn-primary">Search</button>
                <button type="reset" class="btn btn-default">Clear</button>
            </form>
        </div>
    </div>
</div>

<script>
    function doAjax() {
        var text = $("#brand").find("option:selected").val();
        $.ajax({
            type: 'POST',
            url: "/carService/sale/ajax?brandId=" + text,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (data) {
                $('#model').empty();
                for (var i = 0; i < data.length; i++) {
                    $('#model').append('<option value="' + data[i].id + '">' + data[i].modelName + '</option>');
                }
            },
            error: function (data, status, er) {
                $('#model').empty();
                //debug
                //alert("error: " + data + " status: " + status + " er:" + er);
            }
        });
    }
</script>
