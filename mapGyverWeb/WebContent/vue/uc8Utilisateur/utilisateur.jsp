<!-- Ce fichier contient du code jsp pour r�cup�rer des donn�es sans passer par Struts afin de permettre � la formatrice d'evaluer le module pr�c�dent jsp servlet-->

<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="modal-body">
  <h1 class="display-4">G&eacute;rer mon compte</h1>
  <div class="row">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Mes infos</strong>
        </div>
        <div class="card-body">
        
        <!-- par ici le code jsp -->
        
          <jsp:useBean id="utilisateur" scope="session" class="business.uc8Utilisateur.Utilisateur" />
          <div class="offset-1">
            <div class="row">
              <div class="col-md-4">
                <h5>Nom:</h5>
              </div>
              <div class="col-md-7">
                <p><%=utilisateur.getPrenom() %> <%=utilisateur.getNom() %></p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h5>Age:</h5>
              </div>
              <div class="col-md-7">
                <p id="age"><%=utilisateur.getDateNaiss() %> </p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h5>Email:</h5>
              </div>
              <div class="col-md-7">
                <p><%=utilisateur.getEmail()%></p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h5>T�l�phone:</h5>
              </div>
              <div class="col-md-7">
                <p><%=utilisateur.getTelephone() %></p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h5>Adresse:</h5>
              </div>
              <div class="col-md-7">
                <p><%=utilisateur.getAdresse() %></p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-4">
                <h5>Date inscription:</h5>
              </div>
              <div class="col-md-7">
                <p><%=utilisateur.getDateInscrip() %></p>
              </div>
            </div>
          </div>
        </div>
        <div class="card-footer text-right">
          <button onclick="supCompte()" class="btn btn-danger"><i class="material-icons">&#xE147;</i> <span>Supprimer mon compte</span></button>
          <a href="#modifierUtilisateurModal" class="btn btn-primary" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Modifier</span></a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <jsp:include page= "/vue/uc8Utilisateur/groupe.jsp" />
      <jsp:include page= "/vue/uc8Utilisateur/listeDiff.jsp" />
    </div>
  </div>
  <jsp:include page= "/vue/uc8Utilisateur/listeUtilisateurs.jsp" />
  <div id="confirmSupp" class="col-md-10 mt-4 offset-1" style="display: none">
    <div class="card">
      <div class="card-header">
        <strong class="d-inline-block mb-0 text-primary">Suppression du compte</strong>
      </div>
      <div class="card-body text-center">
        <p>La suppression de votre compte entrainera la perte de donn�es</p>
        <a href="#supprimerUtilisateurModal" class="btn btn-danger col-md-4" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Supprimer mon compte</span></a>
      </div>
      <div class="card-footer text-right">
        <button type="submit" class="btn btn-default" onclick="!supCompte()"> Annuler</button>
      </div>
    </div>
  </div> 
  
  <!-- Fenetre de formulaire de modification de l'utilisateur � finaliser-->
  
  <div id="modifierUtilisateurModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form name="modifierUtilisateur" method="post" id="modifierUtilisateur" action="<%=request.getContextPath() %>/utilisateur/modifierUtilisateur">
          <div class="modal-header">
            <h4 class="modal-title">Modifier mes informations</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Nom</label>
              <input type="text" id="inputNom" name="inputNom" class="form-control" value="<%=utilisateur.getNom() %>" required autofocus="autofocus">
            </div>
            <div class="form-group">
              <label>Pr�nom</label>
              <input type="text" id="inputPrenom" name="inputPrenom" class="form-control" value="<%=utilisateur.getPrenom() %>" required>
            </div>
            <div class="form-group">
              <label>T�l�phone</label>
              <input type="text" id="inputTelephone" name="inputTelephone" class="form-control" value="<%=utilisateur.getTelephone() %>" required>
            </div>
            <div class="form-group">
              <label>Adresse</label>
              <input type="text" id="inputAdresse" name="inputAdresse" class="form-control" value="<%=utilisateur.getAdresse() %>" required>
            </div>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
            <input type="submit" class="btn btn-success" value="Enregistrer">
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Delete Modal HTML -->
  <div id="supprimerUtilisateurModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
      
      <!-- Formulaire en Struts -->
      
        <s:form namespace="/mapgyver/utilisateur" method="post" action="ifdelete" theme="simple">
        <div class="modal-header">
          <h4 class="modal-title">Supprimer mon compte</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <p>Etes vous s�re de vouloir effacer d�finitivement votre compte?</p>
          <p class="text-warning"><small>Cette action est irr�versible </small></p>
        </div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
          <s:submit cssClass="btn btn-danger" value="Supprimer"/>
        </div>
      </s:form>
    </div>
  </div>
</div>
</div>