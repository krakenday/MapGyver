<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="djallel*" content="">
	
    <title>MapGyver - Inscription</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/uc8Utilisateur/inscription.css">
	<script src="<%=request.getContextPath()%>/assets/jQuery/lib/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jQuery/dist/jquery.validate.js"></script>
	<jsp:include page="/WEB-INF/include/template.jsp" />

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header"></div>
        <div class="card-body text-center">
  <h4 class="display-3">Félicitations</h4>
            <p>Votre compte a été créé avec succes</p>
            <p>Pour profiter pleinement de notre application veuillez vous identifier</p>
            <s:a cssClass="btn-lg btn-primary" type="button" namespace="/mapgyver/uc1" action="afficheLogin" >CONNEXION</s:a>
        </div>
      </div>
    </div>
    

	<jsp:include page="/WEB-INF/include/scripts.jsp" />

  </body>

</html>
