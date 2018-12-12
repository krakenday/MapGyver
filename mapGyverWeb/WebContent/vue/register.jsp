<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <%@ page import="business.uc8Utilisateur.Utilisateur"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Page d'inscription">
    <meta name="author" content="djallel">
	
    <title>MapGyver - Inscription</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/uc8Utilisateur/inscription.css">
	<script src="<%=request.getContextPath()%>/assets/jQuery/lib/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/assets/jQuery/dist/jquery.validate.js"></script>
	<jsp:include page="/WEB-INF/include/template.jsp" />

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">Cr&eacute;er un utilisateur</div>
        <div class="card-body">
        <jsp:useBean id="msg" scope="request" class="java.lang.String" />
          <%-- <s:if test="%{error!= null}"> --%>
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
  			 <s:property value="msg"/>
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		  <span aria-hidden="true">&times;</span>
  			</button>
		  </div><%-- récuperer les groupes de l'utilisateur   --%>
		<%--  </s:if> --%>
          <s:form id="inscription" namespace="/mapgyver/utilisateur" method="post" action="forminscription" theme="simple">
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<s:label for="inputNom">Nom</s:label>
                    <s:textfield type="text" id="inputNom" name="utilisateur.nom" class="form-control" placeholder="Nom" required="required" autofocus="autofocus"/>            
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                 	 <s:label for="inputPrenom">Pr&eacute;nom</s:label>
                    <s:textfield type="text" id="inputPrenom" name="utilisateur.prenom" class="form-control" placeholder="Prenom" required="required"/>                  
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
              	<s:label for="inputEmail">Email</s:label>
                <s:textfield type="email" id="inputEmail" name="utilisateur.email" class="form-control" placeholder="Email" required="required"/>            
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<s:label for="inputPassword">Mot de passe</s:label>
                    <s:textfield type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Mot de passe" required="required"/>                    
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<label for="inputConfirmPassword">Confirmer Mot de passe</label>
                    <input type="password" id="inputConfirmPassword" name="inputConfirmPassword" class="form-control" placeholder="Confirmer Mot de passe" required="required"/>                   
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<s:label for="inputTelephone">T&eacute;l&eacute;phone</s:label>
                    <s:textfield type="text" id="inputTelephone" name="utilisateur.telephone" class="form-control" placeholder="T&eacute;l&eacute;phone" required="required"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                  <s:label for="inputDateNaiss">Date de Naissance</s:label>
          			<s:textfield type="date" class="form-control" id="inputDateNaiss" name="inputDateNaiss" placeholder="Date de Naissance" required="required"/>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
              	<s:label for="inputAdresse">Adresse</s:label>
                <s:textfield type="text" id="inputAdresse" name="utilisateur.adresse" class="form-control" placeholder="Adresse" required="required"/>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<s:label for="inputVille">Ville</s:label>
                    <s:textfield type="text" id="inputVille" name="inputVille" class="form-control" placeholder="Ville" required="required"/>                    
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                  	<s:label for="inputPays">Pays</s:label>
          			<select id="inputPays" class="form-control" name="inputPays" data-placeholder="Choisir Pays" required="required">
          				<option value="">Choisir Pays</option>
						<option value="Australie">Australie </option>
						<option value="Autriche">Autriche </option>
						<option value="Belgique">Belgique </option>
						<option value="Boznie_Herzegovine">Boznie_Herzegovine </option>
						<option value="Bresil">Bresil </option>
						<option value="Bulgarie">Bulgarie </option>
						<option value="Burkina_Faso">Burkina_Faso </option>
						<option value="Cameroun">Cameroun </option>
						<option value="Canada">Canada </option>
						<option value="Chili">Chili </option>
						<option value="Chine">Chine </option> 
						<option value="Colombie">Colombie </option>
						<option value="Comores">Colombie </option>
						<option value="France">France </option>		
						<option value="Grece">Grece </option>
						<option value="Madagascar">Madagascar </option>
						<option value="Mali">Mali </option>
						<option value="Malte">Malte </option>
						<option value="Maroc">Maroc </option>
						<option value="Nigeria">Nigeria </option>
						<option value="Norvege">Norvege </option>
						<option value="Nouvelle_Zelande">Nouvelle_Zelande </option>							
						<option value="Pakistan">Pakistan </option>
						<option value="Palestine">Palestine </option>
						<option value="Paraguay">Paraguay </option>
						<option value="Pays_Bas">Pays_Bas </option>
						<option value="Perou">Perou </option>
						<option value="Philippines">Philippines </option> 
						<option value="Pologne">Pologne </option>
						<option value="Portugal">Portugal </option>					
						<option value="Republique_Tcheque">Republique_Tcheque </option>
						<option value="Roumanie">Roumanie </option>
						<option value="Royaume_Uni">Royaume_Uni </option>
					</select>
                  </div>
                </div>
              </div>
            </div>
            <s:submit cssClass="btn btn-primary btn-block" value="Créer utilisateur"/>
            <s:reset cssClass="btn btn-danger btn-block" value="Reset"/>
          </s:form>
          <div class="text-center">
            <s:a cssClass="d-block small mt-3" namespace="/mapgyver/uc1" action="afficheLogin">Page d'identification</s:a>
          </div>
        </div>
      </div>
    </div>
    <!-- Validator JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/validator/inscription.js"></script>

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
