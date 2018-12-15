<%@ page import="business.uc8Utilisateur.ListeDiffusion"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="card">
	<div class="card-header">
		<strong class="d-inline-block mb-0 text-primary">Mes Liste de diffusions</strong>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div class="alert alert-danger alert-dismissible fade show" role="alert" hidden="true">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<table class="table" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nom</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listeDiff">
						<tr>
							<td>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="id">
								</div>
							</td>
							<td><s:a><s:property value="nom"/></s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<div class="card-footer text-right">
		<button href="#ajouterListeModal" class="btn btn-light border" data-toggle="modal"><span class="glyphicon glyphicon-add"></span> Ajouter</button>
		<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok"></span> Modifier</button>
		<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Supprimer</button>
	</div>
</div>
<!-- Fenetre de formulaire de l'ajout d'une liste -->
<div id="ajouterListeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <s:form namespace="/mapgyver/utilisateur" method="post" id="addListe" action="doaddListe" theme="simple">
        <div class="modal-header">
          <h4 class="modal-title">Ajouter une liste</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <s:label>Nom</s:label>
            <s:textfield type="text" id="inputNomListeDiff" name="listeDiff.nom" cssClass="form-control" required="required"/>
          </div>            
        </div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
          <s:submit cssClass="btn btn-success" value="Enregistrer"/>
        </div>
      </s:form>
    </div>
  </div>
</div>