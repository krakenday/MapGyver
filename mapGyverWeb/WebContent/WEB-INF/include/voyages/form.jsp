<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<div class="card mb-3  shadow">
	<div class="card-header">
		<i class="fas fa-plane"></i> Informations du voyage
	</div>
	<div class="card-body">

		<div class="text-right">
			<div class="form-group row">
				<label for="titre" class="col-sm-2 col-form-label">Titre</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="inputNomVoyage" required="required"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="depart" class="col-sm-2 col-form-label">Départ le</label>
				<div class="col-sm-4">
					<s:textfield type="date" class="form-control" name="inputDateDebut"/>
				</div>
				<label for="quantite" class="col-sm-4 col-form-label">Nombre
					de voyageurs</label>
				<div class="col-sm-2">
					<s:textfield type="number" class="form-control"  name="inputNbParticipant" min="0"/>
				</div>
			</div>
		</div>

	</div>
</div>
<s:hidden  name="id" value="%{id}"/>
<div class="container text-right">
<div class="row mb-3 px-1 text-right">
<s:if test="!isreadonly">
	<s:if test="voyage==null">
		<s:url namespace="/mapgyver/voyages" action="docreateVoyage" 		var="creaVoy" />
		<s:submit class="btn btn-success" value="Créer" formaction="${creaVoy}" />
	</s:if>
	<s:else>
		<s:url namespace="/mapgyver/voyages" action="doupdateVoyage" 		var="updateVoy" />
		<s:submit class="btn btn-success" value="Modifier" formaction="${updateVoy}" />
	</s:else>
</s:if>
	<button type="reset" class="btn btn-secondary ml-3" id="redo"
		name="redo">Reset</button>
		<s:a class="btn btn-dark ml-3" namespace="/mapgyver/voyages" action="doreadRoadBook" >Voir mon RoadBook</s:a>
</div>
</div>