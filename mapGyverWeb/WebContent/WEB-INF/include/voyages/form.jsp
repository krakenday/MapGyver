<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<form method="get" name="formCRUD" id="formCRUD">
	<div class="mb-2 px-3 text-left">
		<div class="container">
		  <div class="form-group row">
		    <label for="ObjetTitre" class="col-sm-3 col-form-label">Titre</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="titre" name="titre" placeholder="titre">
		    </div>
		  </div>				
		  <div class="form-group row">
		    <label for="ObjetQuantite" class="col-sm-3 col-form-label">Nombre de participants</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="quantite" name="quantite" placeholder="nombre de participants">
		    </div>
		  </div>		
		  <div class="form-group row">
		    <label for="ObjetQuantite" class="col-sm-3 col-form-label">Départ prévu le : </label>
		    <div class="col-sm-9">
		      <input type=date step=7 min=2014-09-08>
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
