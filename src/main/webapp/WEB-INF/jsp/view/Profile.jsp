<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>
<body>
	
	
	<div class="container-sm w-25  mt-5">
			
			<div class="card mb-3" style="max-width: 700px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="" class="img-fluid rounded-start" alt="">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">Profiel</h5>
        <p class="card-text">Nom : ${user.nom}</p>
        <p class="card-text">Prenom : ${user.prenom}</p>
        <p class="card-text">National ID : ${user.cin}</p>
        <p class="card-text">Email : ${user.email}</p>
        <p class="card-text">teephone : ${user.telephone}</p>
        
        <a class="nav-link"
					    href="${pageContext.request.contextPath}/Disconnect">Disconnect</a>
        <c:if test="${Role == 3}">
    		<a class="nav-link"
					    href="${pageContext.request.contextPath}/showForm">Admin</a>
		</c:if>
     
        
      		</div>
    		</div>
  			</div>
		</div>
	
	</div>
	
</body>
</html>