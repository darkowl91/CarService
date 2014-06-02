<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-truck">&nbsp; <spring:message code="label.new.car.sale"/></i></h3>
    </div>

    <div class="panel-body">

        <form id="firstStep" role="form" class="form-horizontal" method="post" enctype="multipart/form-data" action="<c:url value="/next/next"/>">
            <table class="table">
                <tr>
                    <td>
                        <spring:message code="label.ProduceYear"/>:
                    </td>

                    <td>
                        <select name="year" class="form-control" required>
                            <script>
                                var myDate = new Date();
                                var year = myDate.getFullYear();
                                for (var i = 1900; i < year + 1; i++) {
                                    document.write('<option value="' + i + '">' + i + '</option>');
                                }
                            </script>
                        </select>
                    </td>

                </tr>

                <tr>
                    <td>
                        <spring:message code="label.Price"/>:
                    </td>
                    <td>
                        <input type="text" name="price" class="form-control" required="">
                    </td>
                </tr>

                <tr>
                    <td>
                        <spring:message code="label.photos"/>:
                    </td>
                    <td>
                        <input type="file" name="photo" class="form-control" multiple required="">
                    </td>
                </tr>

                <tr>
                    <td>
                        <spring:message code="AdditionalInfo"/>
                    </td>
                    <td>
                        <textarea class="form-control" name="note" rows="3" required></textarea>
                    </td>
                </tr>
            </table>

            <div class="pull-left">
                <ul class="pager">
                    <li><a href="/carService/sale">Back&nbsp;<i
                            class="fa fa-arrow-circle-left"></i></a></li>
                    <%--<li><a href="#">Next</a></li>--%>
                </ul>
            </div>
            <div class="pull-right">
                <ul class="pager">
                    <li><a href="#" onclick="$('#firstStep').submit();">Done&nbsp;<i
                            class="fa fa-adjust"></i></a></li>
                    <%--<li><a href="#">Next</a></li>--%>
                </ul>
            </div>
        </form>
    </div>
</div>
