<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>products-list</title>

        <!-- bootstrap 5 links starts-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <!-- bootstrap 5 links ends-->

        <link rel="stylesheet" type="text/css" href="css/style.css" />
        
        <!-- JavaScript -->
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
        
        <script>
        	function courseDetails(courseName)
        	{
        		window.location.href="/courseDetails?courseName="+encodeURIComponent(courseName);
        	}
        </script>

    </head>
    <body>
    
    	<jsp:include page="header-admin.jsp" />
    	
    	<c:if test="${not empty model_success}">
         	<div class="row">
         		<div class="alert alert-success alert-dismissible fade show" role="alert">
         			${model_success}
			  	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
          	</div>
        </c:if>
            	
        <c:if test="${not empty model_error}">
         	<div class="row">
         		<div class="alert alert-danger alert-dismissible fade show" role="alert">
         			${model_error}
			  		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
         	</div>
        </c:if>

        <div class="container mt-3"> 
            <h2>Product's List</h2>
            <p>Below table displays only 5 employees list :</p>            
            <table class="table table-light table-bordered table-striped">
                <thead>
                    <tr>
                    	<th>Course Image</th>
                        <th>Course Name</th>
                        <th>Course Validity</th>
                        <th>Course Price</th>
                        <th>Trainer Name</th>
                        <th style="text-align: center;">Full Details</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="product" items="${model_products_list}">
        		    <tr>
        		    	<td> <img src="${product.getCourseimage()}" alt="" height="100"/></td>
                        <td>${product.getCoursename()}</td>
                        <td>${product.getCoursevalidity()}</td>
                        <td><del style="color:red">Rs. ${product.getOriginalprice()}</del><b>&nbsp;&nbsp;Rs. ${product.getDiscountedprice()}</b></td>
                        <td>${product.getTrainersname()}</td>
                        <td style="text-align: center;"> 
                        	<button class="btn btn-secondary" onclick="courseDetails('${product.getCoursename()}')"><i class="bi bi-arrow-right-square-fill"></i></button>
                        </td>
                    </tr>	
                	</c:forEach>
                </tbody>
            </table>
            <!--  
            <ul class="pagination">
            	<c:choose>
	         		<c:when test="${model_current_page > 1}">
		            	<li class="page-item">
		            		<a class="page-link" href="/emplist?page=${model_current_page - 1}">Previous</a>
		            	</li>
		            </c:when>
	         		<c:when test="${model_current_page == 1}">
		            	<li class="page-item disabled">
		            		<a class="page-link" href="/emplist?page=${model_current_page - 1}">Previous</a>
		            	</li>
		            </c:when>
            	</c:choose>
	            
	            <c:forEach begin="1" end="${model_total_pages}" var="pageNumber">
	            	<c:choose>
	            		<c:when test="${model_current_page == pageNumber}">
			            	<li class="page-item active">
			            		<a class="page-link" href="/emplist?page=${pageNumber}">${pageNumber}</a>
			            	</li>
		            	</c:when>
	            		<c:when test="${model_current_page != pageNumber}">
			            	<li class="page-item">
			            		<a class="page-link" href="/emplist?page=${pageNumber}">${pageNumber}</a>
			            	</li>
		            	</c:when>
		            </c:choose>
	            </c:forEach>
	            
			  	<c:choose>
		            <c:when test="${model_current_page < model_total_pages}">
		            	<li class="page-item">
		            		<a class="page-link" href="/emplist?page=${model_current_page + 1}">Next</a>
		            	</li>
		            </c:when>
		            <c:when test="${model_current_page == model_total_pages}">
		            	<li class="page-item disabled">
		            		<a class="page-link" href="/emplist?page=${model_current_page + 1}">Next</a>
		            	</li>
		            </c:when>
	            </c:choose>
		    </ul>
		    -->
        </div>
    </body>
</html>
