<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach var="i" begin="1" end="100">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-dollar "></i> Panel primary</h3>
        </div>
        <div class="panel-body">
            <div class="media">
                <a href="#" class="pull-left">
                    <img src="http://lorempixel.com/64/64/" class="media-object" alt=''/></a>

                <div class="media-body">
                    <h4 class="media-heading">
                        Nested media heading
                    </h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                    sollicitudin
                    commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                    <div class="media">
                        <a href="#" class="pull-left">
                            <img src="http://lorempixel.com/64/64/" class="media-object" alt=''/></a>

                        <div class="media-body">
                            <h4 class="media-heading">
                                Nested media heading
                            </h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                            sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra
                            turpis.
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</c:forEach>
