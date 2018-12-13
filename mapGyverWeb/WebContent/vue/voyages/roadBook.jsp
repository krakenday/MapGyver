<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="business.uc4Voyage.RoadBook"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Organisation de voyages">
<meta name="author" content="Idriss">
<title>MapGyver - RoadBook</title>
<jsp:include page="/WEB-INF/include/template.jsp" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/voyages/voyages.css"> 
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/voyages/roadBook.css">
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
				<s:if test="roadBook==null">
					<s:a class="btn btn-success mb-3" namespace="/mapgyver/voyages" action="docreateRoadBook" role="button">Cr&eacute;er mon roadBook</s:a>
				</s:if>
				<s:else>
						<jsp:include page="/WEB-INF/include/voyages/roadBook/main.jsp" />
						<button type="button" class="btn btn-danger mb-3" data-toggle="modal"
						data-target="#deleteModalRoadBook">Supprimer mon roadBook</button>
				</s:else>
				<s:if test="success!=null">
					<div class="alert alert-success shadow alert-dismissible fade show" role="alert" id="success"><s:property value="success" />
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  	</button>
				  	</div>
			  	</s:if>
			  	<s:if test="probleme!=null">
				<div class="alert alert-danger  shadow alert-dismissible fade show" role="alert" id="probleme"><s:property value="probleme" />
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
			  		</button>
			  	</div>
			  	</s:if>
			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->

			<jsp:include page="/WEB-INF/include/footer.jsp" />
		</div>
		<!-- /.content-wrapper -->

	</div>
	<s:if test="roadBook!=null">
	<!-- Delete Voyages Modal HTML -->
	<jsp:include page="/WEB-INF/include/voyages/roadBook/deleteModalVoyages.jsp" />
	<!-- Delete RoadBook Modal HTML -->
	<jsp:include page="/WEB-INF/include/voyages/roadBook/deleteModalRoadBook.jsp" />
	</s:if>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include page="/WEB-INF/include/logout.jsp" />

	<jsp:include page="/WEB-INF/include/scripts.jsp" />

	<!-- scripts for this page-->
	<script	src="<%=request.getContextPath()%>/assets/js/voyages/roadBook.js"></script>
</body>

</html>
