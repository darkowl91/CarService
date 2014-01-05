<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Advertisement Form</h3>
    </div>
    <div class="panel-body">
        <div class="col-md-6 column ">
            <form name="registration-form" method="post" action="advert">
                <%--BRAND--%>
                <div class="field-box">
                    <label>Car brand:</label>
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--BRAND--%>
                <div class="field-box">
                    <label>Car model:</label>
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--PRODUCE YEAR--%>
                <div class="field-box">
                    <label>Produce year:</label>
                    <select name="yearpicker" id="yearpicker" class="form-control">
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
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--TRANSMISSION--%>
                <div class="field-box">
                    <label>Transmission:</label>
                    <select class="form-control">
                        <option>1</option>
                    </select>
                </div>
                <%--PRICE--%>
                <div class="field-box">
                    <label>Price:</label>
                    <input class="form-control" type="text">
                </div>
                <%--NOTE --%>
                <div class="field-box">
                    <label>Note:</label>
                    <textarea class="form-control" rows="3"></textarea>
                </div>

                <br/>
                <button type="submit" class="btn btn-primary">Add</button>
                <button type="reset" class="btn btn-default">Clear</button>
        </div>
        <div class="col-md-6 column">
            <%--PHOTO--%>
            <div class="field-box">
                <label>Car Photo:</label>
                <input type="file" class="btn btn-link">
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