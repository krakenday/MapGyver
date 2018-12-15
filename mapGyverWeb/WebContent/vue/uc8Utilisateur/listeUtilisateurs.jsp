<%@ taglib uri="/struts-tags" prefix="s"%>
      <div class="card" style="margin-top: 10px;">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Liste des utilisateurs de l'application</strong>
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
              <%-- récuperer les utilisateurs de mon application   --%>
              <s:iterator value="utilisateurs">
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="id" id="">
                    </div>
                  </td>
                  <td><s:property value="prenom"/>- <s:property value="nom"/></td>
                </tr>
                </s:iterator>
                 <%-- fin de l'iteration Struts   --%>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer text-right">
        </div>
      </div>