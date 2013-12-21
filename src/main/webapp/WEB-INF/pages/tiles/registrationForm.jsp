<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row clearfix">

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Registration Form</h3>
        </div>
        <div class="panel-body">

            <div class="col-md-6 column">
                <form name="registration-form" method="post" action="register">
                    <div class="field-box">
                        <label>Name:</label>
                        <input class="form-control" type="text">
                    </div>

                    <div class="field-box">
                        <label>Surname:</label>
                        <input class="form-control" type="text">
                    </div>

                    <div class="field-box">
                        <label>Email:</label>
                        <input class="form-control" type="text">
                    </div>

                    <div class="field-box">
                        <label>Password:</label>
                        <input type="password" class="form-control">

                    </div>

                    <div class="field-box">
                        <label>Password confirm:</label>
                        <input type="password" class="form-control">
                    </div>

                    <div class="field-box">
                        <label>Photo:</label>
                        <input type="file" class="btn btn-link">
                    </div>

                    <br/>

                    <button type="submit" class="btn btn-primary">Register</button>
                    <button type="reset" class="btn">Clear</button>

                </form>
            </div>

            <div class="col-md-6 column">
                <br/>
                <a href="#" class="pull-left ">
                    <img src="http://lorempixel.com/128/128/" class="media-object" alt=''/></a>
            </div>

        </div>
    </div>
</div>