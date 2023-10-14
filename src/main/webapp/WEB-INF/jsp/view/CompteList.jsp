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

<style>
h3 {
	margin-top: 20px;
}

#navbarNav div {
	height: 0;
}

#navbarNav form {
	margin: 0;
	padding: 0;
}

form {
	margin-bottom: 60px;
	margin-top: 10px;
	padding: 10px;
}
</style>

</head>
<body>
	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath}/showForm">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/showForm">Ajouter Utilisateur</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/comptes">Comptes</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/FormCompte">Creer Compte </a></li>
					<li class="nav-item"><a class="nav-link"
					    href="${pageContext.request.contextPath}/admin/comptes">Manager Comptes</a></li>


					<li class="nav-item"><form
							action="${pageContext.request.contextPath}/admin/serachUtilisateur"
							class="d-flex" method="POST">
							<input name="cin" class="form-control me-2" type="search"
								placeholder="National ID" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Search</button>
						</form>
				   </li>
				   
				   <li class="nav-item"><a class="nav-link"
					    href="${pageContext.request.contextPath}/Disconnect">Disconnect</a></li>
				</ul>
			</div>
		</nav>
			


		<div>
		   <h3>Comptes</h3>
		</div>
		
		<div>


		<c:if test="${compteModel.password !=null}">
			<div class="alert alert-success col-6">User created. The
				password generated is : ${compteModel.password}</div>
		</c:if>

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Login</th>
					<th scope="col">Role</th>
					<th scope="col">Last Name</th>
					<th scope="col">First Name</th>
					<th scope="col">Email</th>
					<th scope="col">Etat</th>
					<th scope="col">Modifier</th>

				</tr>
			</thead>
			<c:forEach items="${compteList}" var="a">
				<tr>
					<td><c:out value="${a.login}" /></td>
					<td><c:out value="${a.role.nomRole}" /></td>
					<td><c:out value="${a.proprietaire.nom}" /></td>
					<td><c:out value="${a.proprietaire.prenom}" /></td>
					<td><c:out value="${a.proprietaire.email}" /></td>
					<td>
						<c:if test="${a.enabled==true}">
							<ul><li>Active</li></ul>
				        </c:if>
				        <c:if test="${a.enabled==false}">
							<ul><li>Désactivé</li></ul>
				        </c:if>
					</td>
				    <td>
						<ul>
							<li><a href="${pageContext.request.contextPath}/admin/ModifierCompte/${a.idCompte}">Modifier Compte</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/desactive/${a.idCompte}">Désactiver le compte</a></li>
							<li><a href="${pageContext.request.contextPath}/admin/active/${a.idCompte}">Réactiver le compte</a></li>
						</ul>
					</td>	

				</tr>

			</c:forEach>

		</table>
	</div>
</div>