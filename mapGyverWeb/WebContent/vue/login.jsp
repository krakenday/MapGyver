<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Page login sur MapGyver">
	<meta name="author" content="CDI17288">
	<title>MapGyver - Login</title>
	<jsp:include page="/WEB-INF/include/template.jsp" />
</head>

<body class="bg-dark">

	<div class="container">
		<h1 class="display-3 text-center" style="color: white;">Welcome on the best travel webApp</h1>
		<div class="text-center">
			<img src="<s:url value="/assets/img/mapgyver.png"/>" width="50%" height="50%">
		</div>
		<div class="card card-login mx-auto mt-5">
			<jsp:useBean id="msg" scope="request" class="java.lang.String" />
			<div class="card-header">Connexion <%=msg%></div>
			<div class="card-body">
				<s:form namespace="/mapgyver/uc1" action="dologin" method="post" theme="simple">
					<div class="form-group">
					<div class="form-label-group">
						<s:textfield type="email" id="inputEmail" name="inputEmail"									 
									 cssClass="form-control" 
								     required="required" autofocus="autofocus" />
						<s:label for="inputEmail">Adresse email</s:label>
					</div>
					</div>
					<div class="form-group">
					<div class="form-label-group">
						<s:textfield type="password" id="inputPassword" name="inputPassword"									 
									 cssClass="form-control" required="required" />
						<s:label for="inputPassword">Mot de passe</s:label>
					</div>
					</div>
					<div class="form-group">
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
								Mémoriser mon mot de passe - ToDo :) 
						</label>
					</div>
					</div>
					<s:submit cssClass="btn btn-primary btn-block" value="Login"/>
				</s:form>
							
				<div class="text-center">
				    <s:a class="d-block small mt-3" namespace="/mapgyver/uc8" action="register">Créer un utilisateur</s:a>
					<s:a class="d-block small" namespace="/mapgyver/uc1" action="doforgot">Mot de passe oublié?</s:a>
					<!-- 
					<a class="d-block small" href="<%=request.getContextPath() %>/vue/forgot-password.jsp">
						Mot de passe oublié?</a>
					 -->
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript-->
	<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script src="<%=request.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>
