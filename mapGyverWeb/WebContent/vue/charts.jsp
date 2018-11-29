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

    <title>MapGyver - Charts</title>

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
              <a href="#">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">MapGyver</li>
          </ol>

          <!-- Area Chart Example-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-chart-area"></i>
              Area Chart Example</div>
            <div class="card-body">
              <canvas id="myAreaChart" width="100%" height="30"></canvas>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>

          <div class="row">
            <div class="col-lg-8">
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-chart-bar"></i>
                  Bar Chart Example</div>
                <div class="card-body">
                  <canvas id="myBarChart" width="100%" height="50"></canvas>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
              </div>
            </div>
            <div class="col-lg-4">
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-chart-pie"></i>
                  Pie Chart Example</div>
                <div class="card-body">
                  <canvas id="myPieChart" width="100%" height="100"></canvas>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
              </div>
            </div>
          </div>

          <p class="small text-center text-muted my-5">
            <em>More chart examples coming soon...</em>
          </p>

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
    <script src="<%=request.getContextPath()%>/assets/js/demo/chart-area-demo.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/demo/chart-bar-demo.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/demo/chart-pie-demo.js"></script>

  </body>

</html>
