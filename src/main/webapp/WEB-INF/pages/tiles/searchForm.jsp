<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row clearfix">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><i class="fa fa-search"></i>Search</h3>
        </div>
        <div class="panel-body">
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

                <br/>
                <button type="submit" class="btn btn-primary">Search</button>
                <button type="reset" class="btn btn-default">Clear</button>
            </form>
        </div>
    </div>
</div>
