<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-truck">&nbsp;<spring:message code="label.new.car.sale"/></i></h3>

    </div>
    <div class="panel-body">

        <form id="firstStep" class="form-horizontal" method="post" action="<c:url value="/next"/>">
            <table class="table">
                <tr>
                    <td>
                        <spring:message code="label.Mark"/>:
                    </td>
                    <td>
                        <select id="brand" name="brand"  required class="form-control" onchange="doAjax();">
                            <option></option>
                            <c:forEach var="carBrand" items="${brands}">
                                <option value="${carBrand.id}">${carBrand.brandName}</option>
                            </c:forEach>
                        </select>
                        <script>
                            $('#brand').val("${advt.car.model.brand.id}");
                        </script>
                    </td>
                </tr>


                <tr>
                    <td>
                        <spring:message code="label.Model"/>:
                    </td>
                    <td>
                        <select id="model" name="model" required class="form-control">
                            <c:forEach var="model" items="${advt.car.model.brand.models}">
                                <option value="${model.id}">${model.modelName}</option>
                            </c:forEach>
                        </select>
                        <script>
                            $('#model').val("${advt.car.model.id}");
                        </script>
                    </td>
                </tr>

                <tr>
                    <td>
                        <spring:message code="label.BodyType"/>:
                    </td>
                    <td>
                        <select id="body" name="body" required class="form-control">
                            <option></option>
                            <c:forEach var="body" items="${bodyTypes}">
                                <option value="${body.id}">${body.typeName}</option>
                            </c:forEach>
                        </select>
                        <script>
                            $('#body').val("${advt.car.body.id}");
                        </script>
                    </td>
                </tr>
                <tr>
                    <td>
                        <spring:message code="label.Transmission"/>:
                    </td>
                    <td>
                        <select id="transmission" required name="transmission" class="form-control">
                            <c:forEach var="transmission" items="${transmissions}">
                                <option value="${transmission}">${transmission.value}</option>
                            </c:forEach>
                        </select>
                        <script>
                            $('#transmission').val("${advt.car.transmission}");
                        </script>
                    </td>
                </tr>
            </table>
            <div class="pull-right">
                <ul class="pager">
                    <li><a href="#" onclick="$('#firstStep').submit(); ">Next&nbsp;<i class="fa fa-arrow-circle-right"></i></a></li>
                </ul>
            </div>
        </form>
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