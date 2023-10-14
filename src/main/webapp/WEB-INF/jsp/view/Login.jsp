<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>registration form</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	
	
	<div class="container-sm w-25  mt-5">

		
			<f:form action="Authenticate" method="POST" modelAttribute="Loger">
				
				
				<div class="mb-3">
   					   <label>Login</label>
						<f:input path="Login" type="text" class="form-control"
							placeholder="Login" />
   				</div>
   				
  				<div class="mb-3">
   					   <label>Password</label>
						<f:input path="Password" type="text" class="form-control"
							placeholder="Password" />
   				</div>
   				<c:if test="${UniqueMsg!=null}">
							<div class="text-danger" role="alert">${UniqueMsg}</div>
				</c:if>	
   				
  				<button type="submit" class="btn btn-primary">Login</button>
			</f:form>
	
	
	</div>
	
</body>
</html>