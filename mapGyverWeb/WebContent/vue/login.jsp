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
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Connexion</div>
        <div class="card-body">
          <form>
            <div class="form-group">
              <div class="form-label-group">
              <label for="inputEmail">Adresse email</label>
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
              	<label for="inputPassword">Mot de passe</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
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
            <a class="btn btn-primary btn-block" href="index.jsp">Connexion</a>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="register.jsp">Créer un utilisateur</a>
            <a class="d-block small" href="forgot-password.jsp">Mot de passe oublié?</a>
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
