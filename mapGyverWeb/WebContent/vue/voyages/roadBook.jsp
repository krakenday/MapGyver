<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Organisation de voyages">
<meta name="author" content="Idriss">


<title>MapGyver - Dashboard</title>

<jsp:include page="/WEB-INF/include/template.jsp" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/voyages/voyages.css"> 
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/voyages/dashboard.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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
					<li class="breadcrumb-item"><a
						href="<%=request.getContextPath()%>">MapGyver</a></li>
					<li class="breadcrumb-item active">RoadBook</li>
				</ol>
				<jsp:include page="/WEB-INF/include/voyages/roadBook/main.jsp" />

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->

			<jsp:include page="/WEB-INF/include/footer.jsp" />
		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- Delete Modal HTML -->
	<jsp:include page="/WEB-INF/include/voyages/roadBook/deletemodal.jsp" />
	
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include page="/WEB-INF/include/logout.jsp" />

	<jsp:include page="/WEB-INF/include/scripts.jsp" />

	<!-- scripts for this page-->
	<script
		src="<%=request.getContextPath()%>/assets/js/voyages/dashboard.js"></script>
</body>

</html>