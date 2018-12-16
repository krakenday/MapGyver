<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Jouer">
<meta name="author" content="AlexB">


<title>MapGyver - Jouer</title>

<jsp:include page="/WEB-INF/include/template.jsp" />
<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/jouer/jouer.css"> 


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
					<a href="<%=request.getContextPath()%>">MapGyver</a></li>
					<li class="breadcrumb-item active">Jouer</li>
				</ol>
				<div class="table-responsive">
  <table class="table">
    <thead>
      <tr>
        <th scope="col"></th>
        <td class="text-center">liste des Jeux</td>
       <td></td>
      </tr>
    </thead>
    <tbody>
       <s:iterator value="jeux" status="jeuxStatus">
       <s:url  namespace="/mapgyver/uc6" action="jouer"  var="urlAffJouer">
		     						<s:param name="jeu"><s:property/></s:param>
		     						</s:url>
      <tr>
        <th scope="row"><s:property value="%{#jeuxStatus.count}"/></th>
        <td class="text-center"><s:property value="nom"/></td>
        <td class="text-right"><s:form namespace="/mapgyver/uc6" action="jouer" method="post" theme="simple">
        	<s:hidden name="jeu" value="<s:property/>" />
        	<s:submit cssClass="btn btn-dark btn-sm" value="jouer"></s:submit></s:form></td>
        <td class="text-right"><a href="${urlAffJouer}" class="btn btn-dark btn-sm">Jouer</a></td>
      </tr>
      </s:iterator>
    </tbody>
  </table>
</div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->

			<jsp:include page="/WEB-INF/include/footer.jsp" />
		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<jsp:include page="/WEB-INF/include/logout.jsp" />

	<jsp:include page="/WEB-INF/include/scripts.jsp" />

	<!-- scripts for this page-->
	<script src="<%=request.getContextPath()%>/assets/js/jouer/jouergallery.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
</body>

</html>