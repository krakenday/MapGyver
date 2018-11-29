<div class="modal-body">
  <h1 class="display-4">G&eacute;rer mon compte</h1>
  <div class="row">
    <div class="col-md-8">
      <div class="card">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Mes infos</strong>
        </div>
        <div class="card-body">
          <div class="offset-1">
            <div class="row">
              <div class="col-md-3">
                <h5>Nom:</h5>
              </div>
              <div class="col-md-3">
                <p>Pierre Marc</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Age:</h5>
              </div>
              <div class="col-md-3">
                <p>33 ans</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Email:</h5>
              </div>
              <div class="col-md-3">
                <p>rex@gmail.com</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Telephone:</h5>
              </div>
              <div class="col-md-3">
                <p>0651703755</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Adresse:</h5>
              </div>
              <div class="col-md-3">
                <p>120, rue de la paix</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Ville:</h5>
              </div>
              <div class="col-md-3">
                <p>Marseille</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Pays:</h5>
              </div>
              <div class="col-md-3">
                <p>France</p>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3">
                <h5>Date inscription:</h5>
              </div>
              <div class="col-md-3">
                <p>11/11/2018</p>
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
      <div class="card mb-4">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Mes Groupes</strong>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Nom</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="premierGroupe">
                    </div>
                  </td>
                  <td>System Architect</td>
                </tr>
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="premierGroupe">
                    </div>
                  </td>
                  <td>Accountant</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer text-right">
          <button href="#modifierGroupeModal" class="btn btn-light border" data-toggle="modal"><span class="glyphicon glyphicon-add"></span> Ajouter</button>
          <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span> Modifier</button>
          <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Supprimer</button>
        </div>
      </div>
      <div class="card">
        <div class="card-header">
          <strong class="d-inline-block mb-0 text-primary">Mes Liste de diffusions</strong>
        </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Nom</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="premierGroupe">
                    </div>
                  </td>
                  <td>System Architect</td>
                </tr>
                <tr>
                  <td>
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="premierGroupe">
                    </div>
                  </td>
                  <td>Accountant</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="card-footer text-right">
          <button href="#modifierListeModal" class="btn btn-light border" data-toggle="modal"><span class="glyphicon glyphicon-add"></span> Ajouter</button>
          <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-ok"></span> Modifier</button>
          <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Supprimer</button>
        </div>
      </div>
    </div>
  </div>
  <div id="confirmSupp" class="col-md-10 mt-4 offset-1" style="display: none">
    <div class="card">
      <div class="card-header">
        <strong class="d-inline-block mb-0 text-primary">Suppression du compte</strong>
      </div>
      <div class="card-body text-center">
        <p>La suppression de votre compte entrainera la perte de données</p>
        <a href="#supprimerUtilisateurModal" class="btn btn-danger col-md-4" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Supprimer mon compte</span></a>
      </div>
      <div class="card-footer text-right">
        <button type="submit" class="btn btn-default" onclick="!supCompte()"> Annuler</button>
      </div>
    </div>
  </div> 
  <!-- Fenetre de formulaire de modification de l'utilisateur -->
  <div id="modifierUtilisateurModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Modifier mes informations</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Email</label>
              <input type="email" id="inputEmail" name="inputEmail" class="form-control" required>
            </div> 
            <div class="form-group">
              <label>Téléphone</label>
              <input type="text" id="inputTelephone" name="nbrExemplaire" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Adresse</label>
              <input type="text" id="inputAdresse" name="inputAdresse" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Ville</label>
              <input type="text" id="inputVille" name="inputVille" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Pays</label>
              <input type="text" id="inputPays" name="inputPays" class="form-control" required>
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
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Supprimer Document</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <p>Etes vous sûre de vouloir effacer définitivement votre compte?</p>
            <p class="text-warning"><small>Cette action est irréversible </small></p>
          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
            <input type="submit" class="btn btn-danger" value="Supprimer">
          </div>
        </form>
      </div>
    </div>
  </div>
    <!-- Fenetre de formulaire de l'ajout d'un groupe -->
  <div id="modifierGroupeModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Ajouter un groupe</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Nom</label>
              <input type="text" id="inputNomGroupe" name="inputNomGroupe" class="form-control" required>
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
   <!-- Fenetre de formulaire de l'ajout d'une liste -->
  <div id="modifierListeModal" class="modal fade">
    <div class="modal-dialog">
      <div class="modal-content">
        <form>
          <div class="modal-header">
            <h4 class="modal-title">Ajouter une liste</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Nom</label>
              <input type="text" id="inputNomListe" name="inputNomListe" class="form-control" required>
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
</div>