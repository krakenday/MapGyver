<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="fr">
<head>
	<meta charset="UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MAPGYVER ECF N-TIERS ---> UC3_Partager</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Table core CSS    -->
    <link href="<%= request.getContextPath() %>/assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="<%= request.getContextPath() %>/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>

<!-- contenu du site -->
<body>
	<!-- header menu  & sidebar -->
	<jsp:include page="/WEB-INF/include/partager/menu.jsp" />
	
    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">HOME</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                           <a href="">
                                <i class="fa fa-search"></i>
								<p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">Mon compte</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- header menu & sidebar -->
	
		<!-- contenu du panel central -->
        <div class="content">
            <div class="container-fluid card">
            	<ol class="breadcrumb">
		            <li class="breadcrumb-item card-header">
		            	<a href="#">Acceuil</a>
		            </li>
		            <li class="breadcrumb-item active">Partager</li>
          		</ol>
                
                <div class="row">
                
                	<div class="col-md-1"></div>
                
                	<div class="col-md-4">
                        <div class="card">
							<div class="card-header">
                                <h4 class="title">Pays visités Statistiques</h4>
                            </div>
                            <div class="content">
                                <div id="chartPreferences" class="ct-chart ct-perfect-fourth"></div>

                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Non visité
                                        <i class="fa fa-circle text-warning"></i> Visité
                                        <i class="fa fa-circle text-danger"></i> Je ne veux pas visiter
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-2"></div>
                    
                    <div class="col-md-4">
                        <div class="card">
							<div class="header">
                                <h4 class="title">Points d'intérêts visités</h4>
                            </div>
                            <div class="content">
                                <div id="chartPreferences2" class="ct-chart ct-perfect-fourth"></div>

                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Culturel
                                        <i class="fa fa-circle text-danger"></i> Restauration
                                        <i class="fa fa-circle text-warning"></i>Sportif
                                        <i class="fa fa-circle text-purple"></i> Logement
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-1"></div>
                </div>
				
				<div class="row">
                	<div class="col-md-1"></div>
                
                    <div class="col-md-10">
                        <div class="card ">
                            <div class="header">
                                <h4 class="title">Elements partagés en 2018</h4>
                            </div>
                            <div class="content">
                                <div id="chartActivity" class="ct-chart"></div>

                                <div class="footer">
                                    <div class="legend">
                                        <i class="fa fa-circle text-info"></i> Vous
                                        <i class="fa fa-circle text-danger"></i> Moyenne des utilisateurs
                                    </div>
                                    <hr>
                                </div>
                            </div>
                        </div>
                    </div>
				</div>
            </div>
        </div>
        <!-- end contenu du panel central -->
	    		
		<!-- footer -->
		<jsp:include page="/WEB-INF/include/partager/footer.jsp" />
		<!-- end footer -->
		
	</div>
</body>
<!-- end contenu du site -->
	
	<!--   import script   -->
	<jsp:include page="/WEB-INF/include/partager/script.jsp" />
	<!--   end import script   -->

</html>
