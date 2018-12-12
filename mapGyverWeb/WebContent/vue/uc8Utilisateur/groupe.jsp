<%@ taglib uri="/struts-tags" prefix="s"%>
      <div class="card mb-4">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Mes Groupes</strong>
        </div>
        <div class="card-body">
          <div class="table-responsive">
           <div class="alert alert-danger alert-dismissible fade show" role="alert" hidden="true" >
  			 
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
              <%-- récuperer les groupes de l'utilisateur   --%>
              <s:iterator value="groupes">
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="groupe">
                    </div>
                  </td>
                  <td><s:a><s:property value="nom"/></s:a></td>
                </tr>
                </s:iterator>
                 <%-- fin de l'iteration Struts   --%>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer text-right">
          <button href="#ajouterGroupeModal" class="btn btn-light border" data-toggle="modal"><span class="glyphicon glyphicon-add"></span> Ajouter</button>
          <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span> Modifier</button>
          <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Supprimer</button>
        </div>
      </div>