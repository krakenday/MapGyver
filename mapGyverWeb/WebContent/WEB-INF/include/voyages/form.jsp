<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%	Voyage voyage = (Voyage) request.getAttribute("voyage");
String id ="";
String titre="";
String nbParts ="";
String date="";
if (voyage!=null){
	id 		= Integer.toString(voyage.getId());
	titre 	= voyage.getNom();
	date 	= "";
	if(voyage.getDateDebut()!=null){
		date = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(voyage.getDateDebut());
	}
	nbParts 	= voyage.getNbParticipant()==null? " " : Integer.toString(voyage.getNbParticipant());
}
%>

<div class="card mb-3  shadow">
	<div class="card-header">
		<i class="fas fa-plane"></i> Informations du voyage
	</div>
	<div class="card-body">

		<div class="text-right">
			<div class="form-group row">
				<label for="titre" class="col-sm-2 col-form-label">Titre</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="titre" name="titre"
						placeholder="titre" value="<%=titre %>" required >
				</div>
			</div>
			<div class="form-group row">
				<label for="depart" class="col-sm-2 col-form-label">Départ
					le</label>
				<div class="col-sm-4">
					<input type=date class="form-control" id="depart" name="depart" value="<%=date %>">
				</div>
				<label for="quantite" class="col-sm-4 col-form-label">Nombre
					de voyageurs</label>
				<div class="col-sm-2">
					<input type="number" class="form-control" id="quantite"
						name="quantite" min="0" value="<%=nbParts %>">
				</div>
			</div>
		</div>

	</div>
</div>
<div class="mb-3 px-1 text-right">
<%if (voyage == null) {%>
	<button type="submit" class="btn btn-success" id="create" >Cr&eacute;er</button>
				<%} else {%>
	<button type="submit" class="btn btn-success" id="update" >Modifier</button>
				<%}%>
	<button type="reset" class="btn btn-secondary ml-3" id="redo"
		name="redo">Reset</button>
</div>