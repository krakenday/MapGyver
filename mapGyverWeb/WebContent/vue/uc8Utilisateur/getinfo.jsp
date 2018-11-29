<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Djallel">
	<jsp:include page="/WEB-INF/include/template.jsp" />
    <title>MapGyver - Gerer utilisateur</title>
  </head>
  <body id="page-top">
    <nav class="navbar navbar-expand navbar-dark bg-secondary static-top">
		<jsp:include page="/WEB-INF/include/start.jsp" />
        <!-- Navbar Search -->
		<jsp:include page="/WEB-INF/include/search.jsp" />
      	<!-- Navbar -->
      	<jsp:include page="/WEB-INF/include/navbar.jsp" />
    </nav>
    <div id="wrapper">
		<!-- Sidebar -->
      	<jsp:include page="/WEB-INF/include/sidebar.jsp" />
      	<div id="content-wrapper">
        	<div class="container-fluid">
				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
				  <li class="breadcrumb-item">
				    <a href="<%=request.getContextPath()%>">MapGyver</a>
				  </li>
				  <li class="breadcrumb-item active">Gerer utilisateur</li>
				</ol>
          	<!-- les infos de mon utlisateurs -->
			<jsp:include page="/vue/uc8Utilisateur/utilisateur.jsp" />
        </div>
        <jsp:include page="/WEB-INF/include/footer.jsp" />
      </div>
    </div>
    <jsp:include page="/WEB-INF/include/logout.jsp" /> 
	<jsp:include page="/WEB-INF/include/scripts.jsp" />
	<script src="<%=request.getContextPath()%>/assets/js/utilisateur/utilisateur.js"></script>
  </body>
</html>
