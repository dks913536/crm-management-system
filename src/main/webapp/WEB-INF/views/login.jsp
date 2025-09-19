<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>login</title>

        <!-- bootstrap 5 links starts-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- bootstrap 5 links ends-->

        <link rel="stylesheet" type="text/css" href="css/style.css" />

    </head>
    <body>
        <jsp:include page="header-crm.jsp" />
        
        <div class="container-fluid" >
            <div class="container" >
                <div class="row">
                    <div class="col-4"></div> 
                    
                    <div class="col-4 d-flex justify-content-center">
                        <div class="login_div_design bg-light">
                        	<c:if test="${not empty model_error}">
                        		<h4 style="color: red;">${model_error}</h4>
                        	</c:if>
                        	<br/>
                            <form action="loginForm" method="post">
                            	<h3>Login Here</h3><br/>
	                            <div class="mb-3">
	                                <label class="form-label">Enter Email</label>
	                                <input type="text" name="email1" class="form-control">
	                            </div>                        
	                            <div class="mb-3">
	                                <label class="form-label">Enter Password</label>
	                                <input type="password" name="pass1" class="form-control">
	                                <div class="form-text">We will not share your email id and password with anyone...</div>
	                            </div>
	                            <input type="submit" value="Login" class="btn btn-primary">
                            </form>
                        </div>
                    </div>  
                    
                    <div class="col-4"></div>  
                </div>
            </div>
        </div>        
    </body>
</html>






<!-- 

-expression tag
String login_error=(String) request.getAttribute("model_error");
-expression tag

if(login_error !=null)
{
	-expression tag
	<h4 style="color: red;"> ---expression tag  login_error %></h4>
	-expression tag
}
-->

