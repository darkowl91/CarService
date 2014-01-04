<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-truck">&nbsp;New car sale </i></h3>

    </div>
    <div class="panel-body">

        <form id="firstStep" class="form-horizontal" method="post" action="<c:url value="/next"/>">
            <table class="table">
                <tr>
                    <td>
                        Car mark:
                    </td>
                    <td>
                        <select name="yearpicker" class="form-control">
                            <option>1</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        Car model:
                    </td>
                    <td>
                        <select name="yearpicker" class="form-control">
                            <option>1</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>
                        Car body:
                    </td>
                    <td>
                        <select name="yearpicker" class="form-control">
                            <option>1</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Trasmossion:
                    </td>
                    <td>
                        <select name="yearpicker" class="form-control">
                            <option>1</option>
                        </select>
                    </td>
                </tr>


            </table>
            <div class="pull-right">
                <ul class="pager">
                    <li><a href="#" onclick="document.getElementById('firstStep').submit();">Next&nbsp;<i
                            class="fa fa-arrow-circle-right"></i></a></li>
                    <%--<li><a href="#">Next</a></li>--%>
                </ul>
            </div>
        </form>
    </div>
</div>