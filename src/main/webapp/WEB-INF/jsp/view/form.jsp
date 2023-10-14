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
			<h3>Registration Form</h3>
		</div>
		<div>
			<c:if test="${infoMsg!=null}">
				<div class="alert alert-success" role="alert">${infoMsg}</div>
			</c:if>
			<c:if test="${errorMsg!=null}">
				<div class="alert alert-danger" role="alert">${errorMsg}</div>
			</c:if>


			<f:form action="addUtilisateur" method="POST" modelAttribute="UtilisateurModel">

				<div class="row">
					<div class="col">
						<label>National Identity Number</label>
						<f:input path="cin" type="text" class="form-control"
							placeholder="National Identity Number" />
						<f:errors path="cin" class="text-danger" />
						
						<c:if test="${UniqueMsg!=null}">
							<div class="text-danger" role="alert">${UniqueMsg}</div>
						</c:if>	
					</div>
					<div class="col">
						<label>Photo</label>
						<f:input path="photo" type="text" class="form-control"
							placeholder="Photo" />
						<f:errors path="photo" class="text-danger" />
					</div>
				</div>
				
				<div class="row">
					<div class="col">
						<label>Prenom</label>
						<f:input path="prenom" type="text" class="form-control"
							placeholder="Last Name" />
						<f:errors path="prenom" class="text-danger" />
					</div>

					<div class="col">
						<label>Nom</label>
						<f:input path="nom" type="text" class="form-control"
							placeholder="First Name" />
						<f:errors path="nom" class="text-danger" />
					</div>
				</div>


				<div class="row">
					<div class="col">
						<label>Email</label>
						<f:input path="email" class="form-control" placeholder="Email" />
						<f:errors path="email" class="text-danger" />
					</div>

					<div class="col">
						<label>Telephone</label>
						<f:input path="telephone" type="telephone" class="form-control"
							placeholder="Telephone" />
						<f:errors path="telephone" class="text-danger" />
					</div>
				</div>

				<div class="row">
					<div class="col">
						<label>Nom en Arabe</label>
						<f:input path="nomArabe" type="text" class="form-control"
							placeholder="النسب" />
						<f:errors path="nomArabe" class="text-danger" />
					</div>

					<div class="col">
						<label>Prenom en Arabe</label>
						<f:input path="prenomArabe" type="text" class="form-control"
							placeholder="الاسم" />
						<f:errors path="prenomArabe" class="text-danger" />
					</div>
				</div>
	
				<div style="text-align: right ;margin-top:10px">
					<button type="submit" class="btn btn-primary">Register</button>
					<button type="reset" class="btn btn-secondary">Rest</button>
				</div>

			</f:form>
		</div>

		<div>
		
		<table class="table">
				<thead>
					<tr>
						<th scope="col">National Id Number</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Telephone</th>
						<th scope="col">Nom en Arabe</th>
						<th scope="col">Prenom en Arabe</th>
					</tr>
				</thead>
				<c:forEach items="${UtilisateurList}" var="p">
					<tr>
						<td><c:out value="${p.cin}" /></td>
						<td><c:out value="${p.prenom}" /></td>
						<td><c:out value="${p.nom}" /></td>
						<td><c:out value="${p.email}" /></td>
						<td><c:out value="${p.telephone}" /></td>
						<td><c:out value="${p.nomArabe}" /></td>
						<td><c:out value="${p.prenomArabe}" /></td>
					</tr>

				</c:forEach>

			</table>

		
		</div>
	</div>
</body>
</html>