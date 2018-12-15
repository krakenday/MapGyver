<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Page d'informations utilisateur">
    <meta name="author" content="djallel">
    <title>MapGyver - Gérer utilisateur</title>
   	<script src="<%=request.getContextPath()%>/assets/jQuery/lib/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jQuery/dist/jquery.validate.js"></script>
	<jsp:include page="/WEB-INF/include/template.jsp" />

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
				  <li class="breadcrumb-item active">Gestion utilisateur</li>
				</ol>
				
          	<!-- les infos de mon utlisateurs, dans la jsp utilisateur je recupérer l'utilisateur authentifié et j'affiche ses infos en jsp -->
          	
			<jsp:include page="/vue/uc8Utilisateur/utilisateur.jsp" />
        </div>
        <jsp:include page="/WEB-INF/include/footer.jsp" />
      </div>
    </div>
    <jsp:include page="/WEB-INF/include/logout.jsp" /> 
	<script src="<%=request.getContextPath()%>/assets/js/validator/inscription.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/utilisateur/utilisateur.js"></script>
	<!-- Bootstrap core JavaScript-->
	<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="<%=request.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="<%=request.getContextPath()%>/vendor/chart.js/Chart.min.js"></script>
	<script src="<%=request.getContextPath()%>/vendor/datatables/jquery.dataTables.js"></script>
	<script src="<%=request.getContextPath()%>/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="<%=request.getContextPath()%>/assets/js/sb-admin.min.js"></script>
	<!--  JS pour gestion des dates -->
	<script src="<%= request.getContextPath() %>/assets/js/moment-with-locales.js"></script>	
  </body>
</html>
