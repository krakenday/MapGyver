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
    <link href="<%= request.getContextPath() %>/assets/css/css.partager/albumPartageable.css" rel="stylesheet" />
    <link href="<%= request.getContextPath() %>/assets/css/css.partager/stylePartageable.css" rel="stylesheet" />

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
	<jsp:include page="../../WEB-INF/include/include.partager/menu.jsp"/>
	
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
	
        <img class="fondEcran" src="../../assets/img/fonEcranMap.jpg"/>
		<!-- contenu du panel central -->
        <div class="content">
			<h1 class="text-center">PARTAGEABLE</h1>
	    	<div class="container">
				<div class="row col-md-12">
	    			<div class="container-album">
	    				<!-- element partageable sélectionné -->
			          	<div class="card col-md-4">
			           		<img data-src="holder.js/100px280/thumb" alt="100%x280" style="height: 280px; width: 100%; display: block;" src="http://via.placeholder.com/356x280" data-holder-rendered="true">
			          		<hr>
			          		<div class="row">
								<div class="ui-field-contain">
									<label for="affichageNbLike">Like  15</label>
									<div data-role="controlgroup" id="btnGroupNbLike" data-type="horizontal">
										<a href="#" class="ui-btn ui-corner-all">J'AIME</a>
										<a href="#" class="ui-btn ui-corner-all">J'AIME PLUS</a>
									</div>
								</div>
							</div>
			          		<hr>
			          		<!-- collapse description & avis -->
							<div data-role="collapsible-set" id="collapsibleFormulaire" data-theme="a" data-content-theme="a" data-inset="false">
								<div data-role="collapsible" data-collapsed="false">
									<h4>Description</h4>
									<p>Collapsible content.</p>
								</div>
								<div data-role="collapsible">
									<h4>Avis</h4>
									<p>Collapsible content.</p>
								</div>
							</div>
							<!-- end collapse description & avis -->
			          		<hr>
			          	</div>
			          	<!-- end element partageable sélectionné -->
		          	
		        		<div class="col-md-2"></div>
		        		
		        		<!-- formulaire description -->
		        		<form action="">
							<div class="card col-md-4">
								<!-- groupe de partage -->
								<div class="card-header text-center">Groupe de partage</div>
								<fieldset data-role="controlgroup" data-iconpos="right" id="checkboxGroup">
									<input name="checkbox1" id="checkbox1" type="checkbox" hidden=""/>
									<label for="checkbox1">Public</label>
									<input name="checkbox2" id="checkbox2" type="checkbox" hidden=""/>
									<label for="checkbox2">Amis</label>
									<input name="checkbox3" id="checkbox3" type="checkbox" hidden=""/>
									<label for="checkbox3">Famille</label>
								</fieldset>
								<!-- end groupe de partage -->
								<hr>
								<!-- type description -->
								<div class="card-header text-center">Type de description</div>
								<div class="ui-field-contain">
									<select name="lblTypeDescription" id="lblTypeDescription" data-corners="false" data-iconpos="right">
										<option value="" selected="selected" disabled="disabled">Sélectionner un type de description</option>
										<option value="">Bon plan</option>
										<option value="">Arnaque</option>
										<option value="">Immanquable</option>
									</select>
								</div>
								<!-- end type description -->
								<hr>
								<!-- texte area description -->
								<div class="row">
									<div class="card-header text-center">Zone de texte</div>
									<div data-role="controlgroup" id="btnGroupTxtArea">
										<div class="zoneTxtArea">
											<textarea name="txtAreaDescription" id="txtAreaDescription" data-clear-btn="true" placeholder="Veuillez saisir votre texte" maxlength="300" cols="40" rows="8"></textarea>
										</div>
										<!-- end texte area description -->
										<hr>
										<!-- camera & album importé -->
										<div class="card-header text-center">Importer média</div>
										<div data-role="controlgroup" id="btnGroupForm" data-type="horizontal">
											<a href="#" id="btnCamera" class="ui-btn ui-corner-all ui-icon-video ui-btn-icon-bottom">Camera</a>
											<a href="#" id="btnAlbum"class="ui-btn ui-corner-all ui-icon-camera ui-btn-icon-bottom">Album</a>
											<a href="#" class="ui-btn ui-corner-all ui-icon-audio ui-btn-icon-bottom" disabled="disabled">Audio</a>
											<a href="#" class="ui-btn ui-corner-all ui-icon-location ui-btn-icon-bottom">Position</a>
										</div>
										<!-- end camera & album importé -->
										<hr>
										<!-- creation-Suppression-modification du formulaire -->
										<div class="radioButton">
											<fieldset data-role="controlgroup" id="radioButtonGroup" data-type="horizontal">
												<legend></legend>
												<input name="radio-choice-1" id="radio-choice-1a" data-mini="true" value="Creer" type="radio" hidden="" checked="checked"/>
												<label for="radio-choice-1a">Creer</label>
												<input name="radio-choice-1" id="radio-choice-1b" data-mini="true" value="Modifier" type="radio" hidden=""/>
												<label for="radio-choice-1b">Modifier</label>
												<input name="radio-choice-1" id="radio-choice-1c" data-mini="true" value="Supprimer" type="radio" hidden=""/>
												<label for="radio-choice-1c">Supprimer</label>
											</fieldset>
										</div>
										<!-- end creation-Suppression-modification du formulaire -->
										<hr>
										<!-- reset & submit du formulaire -->
										<div class="ui-input-btn ui-btn ui-icon-delete ui-btn-icon-left ui-btn-inline ui-corner-all">
											Reset
											<input data-enhanced="true" type="reset" value="Reset" id="btnReset2"/>
										</div>
										<div class="ui-input-btn ui-btn ui-icon-action ui-btn-icon-left ui-btn-inline ui-corner-all">
											Submit
											<input data-enhanced="true" type="submit" value="Submit" id="btnSubmit"/>
										</div>
										<!-- end reset & submit du formulaire -->
									</div>
								</div>
								
							</div>
						</form>
						<!-- end formulaire description -->
		        	</div> 
				</div>
        	</div>
        </div>
        <!-- end contenu du panel central -->
	    		
		<!-- footer -->
		<jsp:include page="../../WEB-INF/include/include.partager/footer.jsp" />
		<!-- end footer -->
		
	</div>
</body>
<!-- end contenu du site -->

    <!--   import script   -->
	<jsp:include page="/WEB-INF/include/include.partager/script.jsp" />
	<!--   end import script   -->

</html>
