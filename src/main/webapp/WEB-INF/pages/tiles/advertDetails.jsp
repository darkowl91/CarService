<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="modal fade" id="modal-container-937715" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">
                               ${advtToView.id}
                            </h4>
                        </div>
                        <div class="modal-body">
                            <!--=============================================================================CAROUSEL-->
                            <div id="myCarousel" class="carousel slide">
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img src="../../resources/design/img/slide-01.jpg" alt="">
                                        <div class="container">
                                            <div class="carousel-caption">
                                                <h1>hjghj</h1>
                                                <p class="lead">ghjghj</p>
                                                <a class="btn btn-large btn-primary" href="/order">ghjghj</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img src="../../resources/design/img//slide-02.jpg" alt="">
                                        <div class="container">
                                            <div class="carousel-caption">
                                                <h1>ghjghjghjghj</h1>
                                                <p class="lead">ghjghjghj</p>
                                                <a class="btn btn-large btn-primary" href="/contacts">ghjghjghj</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item">
                                        <img src="../../resources/design/img/slide-03.jpg" alt="">
                                        <div class="container">
                                            <div class="carousel-caption">
                                                <h1>ghjghj</h1>
                                                <p class="lead">ghjghjghj</p>
                                                <a class="btn btn-large btn-primary" href="/careers">ghjghjghj</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
