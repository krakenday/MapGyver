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

    <title>MapGyver - Blank Page</title>

<jsp:include page="/WEB-INF/include/template.jsp" />

  </head>

  <body id="page-top">

           <nav class="navbar navbar-expand navbar-dark bg-primary static-top">
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
            <li class="breadcrumb-item active">Blank Page</li>
          </ol>

          <!-- Page Content -->
          <h1>Blank Page</h1>
          <hr>
          <p>This is a great starting point for new custom pages.</p>

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

  </body>

</html>
