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

    	<title>MAPGYVER ECF N-TIERS ---> UC3_Partager</title>
		
		<!-- Bootstrap core CSS     -->
    	<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/css.partager/partager.css"> 
    	
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
		            	<a href="#">Bibliotheque</a>
		            </li>
		            <li class="breadcrumb-item active">Accueil</li>
		        </ol>

          <!-- contenu du panel central -->
	        <div class="content">
	        	<h1 class="text-center">ALBUM PHOTO</h1>
	        	<div class="album text-muted">
			    	<div class="container">
			
			        <div class="row">
			          <div class="card">
			           <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			           <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			          <div class="card">
			            <img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
			          </div>
			        </div>

		    	</div>
		    </div>
        </div>
        <!-- end contenu du panel central -->
			

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
		<jsp:include page="/WEB-INF/include/footer.jsp" />

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    	<jsp:include page="/WEB-INF/include/logout.jsp" />
        
	<jsp:include page="/WEB-INF/include/scripts.jsp" />

    <!-- Demo scripts for this page-->
    <script src="<%=request.getContextPath()%>/js/demo/datatables-demo.js"></script>
    <script src="<%=request.getContextPath()%>/js/demo/chart-area-demo.js"></script>

  </body>

</html>
