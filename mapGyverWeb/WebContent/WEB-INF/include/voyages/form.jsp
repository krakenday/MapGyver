<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<form method="get" name="formCRUD" id="formCRUD">
	<div class="mb-3 px-3 text-center">
		<div class="container col-md-6 offset-md-3 text-left">
		  <div class="form-group row">
		    <label for="ObjetTitre" class="col-sm-2 col-form-label">Titre</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="titre" name="titre" placeholder="titre">
		    </div>
		  </div>		
		  <div class="form-group row">
		    <label for="ObjetDesc" class="col-sm-2 col-form-label">Description</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" id="desc" name="desc" rows="5" placeholder="Description succinte du document"></textarea>
		    </div>
		  </div>		
		  <div class="form-group row">
		    <label for="ObjetQuantite" class="col-sm-2 col-form-label">quantite</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="ObjetQuantite" name="quantite" placeholder="nombre d'exemplaire">
		    </div>
		  </div>		
		</div>
	</div>
	<div class="mb-3 px-3 text-center">
		<button type="submit" class="btn btn-success" id="create" name="todo"
			value="create">Cr&eacute;er</button>
		<button type="submit" class="btn btn-primary" id="update" name="todo"
			value="update">Modifier</button>
		<button type="submit" class="btn btn-warning" id="delete" name="todo"
			value="delete">Supprimer</button>
		<button type="submit" class="btn btn-danger" id="deleteAll"
			name="todo" value="deleteAll">Supprimer tout</button>
		<button type="reset" class="btn btn-secondary ml-5" id="redo" name="redo">Reset</button>
	</div>
</form>
