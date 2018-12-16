<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MapGyver - Login</title>

<jsp:include page="/WEB-INF/include/template.jsp" />

  </head>

  <body class="bg-dark">

    <div class="container">
    <h1 class="display-3 text-center" style="color: white;">Welcome on the best travel webApp</h1>
    <div class="text-center">
    	<img src="../assets/img/mapgyver.png" width="50%" height="50%">
    </div>
      <div class="card card-login mx-auto mt-5">
        <jsp:useBean id="msg" scope="request" class="java.lang.String" />
        <div class="card-header">Connexion <%=msg%></div>
        <div class="card-body">
          <form action="<%=request.getContextPath() %>/admin/login" method="post">
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
                <label for="inputEmail">Adresse email</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required="required">
                <label for="inputPassword">Mot de passe</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" value="remember-me">
                  Mémoriser mon mot de passe
                </label>
              </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Login" />
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" 	href="<%=request.getContextPath() %>/vue/register.jsp">Créer un utilisateur</a>
            <a class="d-block small" 		href="<%=request.getContextPath() %>/vue/forgot-password.jsp">Mot de passe oublié?</a>
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