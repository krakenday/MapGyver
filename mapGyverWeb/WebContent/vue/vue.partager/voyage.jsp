<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="fr">
<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<meta charset="UTF-8" />
	<link rel="icon" type="image/png" href="<%= request.getContextPath() %>/assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>MAPGYVER ECF N-TIERS ---> UC3_Partager</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%= request.getContextPath() %>/assets/css/albumPartageable.css" rel="stylesheet" />

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
	<jsp:include page="/WEB-INF/include/partager/menu.jsp"/>
	
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
        <!-- header menu  & sidebar -->
	
		<!-- contenu du panel central -->
        <div class="content">
			<h1 class="text-center">ALBUM VOYAGE</h1>
        	<div class="album text-muted">
		    	<div class="container">
					<div class="row">
			          	<div class="card">
			           		<img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
							<a href="partageable.jsp" id="btnPartager" data-rel="external" class="ui-btn ui-corner-all ui-btn-b">Partager</a>
			          	</div>
			          	<div class="card">
			            	<img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			          		<a href="partageable.jsp" id="btnPartager" data-rel="external" class="ui-btn ui-corner-all ui-btn-b">Partager</a>
			          	</div>
			          	<div class="card">
			           		<img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			          		<a href="partageable.jsp" id="btnPartager" data-rel="external" class="ui-btn ui-corner-all ui-btn-b">Partager</a>
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
