<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<!-- Roadbook -->
<div class="row ">
	<div class="col-lg-12">
		<div class="card mb-3 shadow">
			<div class="card-header">
				<i class="fas fa-reorder"></i> Liste des voyages
			</div>
			<div class="card-body">

				<div id="liste">
					<div class="table-wrapper">
						<div class="table-title">
							<div class="row">
								<div class="col-sm-6">
									<h2>
										Gerer mes <b>Voyages</b>
									</h2>
								</div>
								<div class="col-sm-6">
									<s:a namespace="/mapgyver/voyages" action="doreadVoyage"
										class="btn btn-success">
										<i class="material-icons">&#xE147;</i>
										<span>Ajouter nouveau voyage</span></s:a> <a
										href="#deleteModalVoyages" class="btn btn-danger"
										data-toggle="modal"><i class="material-icons">&#xE15C;</i>
										<span>Supprimer</span></a>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th><span class="custom-checkbox"> <input
											type="checkbox" id="selectAll"> <label
											for="selectAll"></label>
									</span></th>
									<th>Titre</th>
									<th>Date de départ</th>
									<th>Nbr Participants</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="roadBook.voyages">
									<tr>
										<td>
											<span class="custom-checkbox"> <input
													type="checkbox" id="checkbox<s:property 	value="id"/>" name="options[]"
													value="<s:property 	value="id"/>"> <label for="checkbox<s:property 	value="id"/>"></label>
											</span>
										</td>
										<td><s:property 	value="nom"/></td>
										<td><s:property 	value="DateDebutToString"/></td>
										<td><s:property 	value="nbParticipant"/></td>
										<td>
											<s:url  namespace="/mapgyver/uc2" action="doconsultSouvenirs"  var="viewSouv">
				     							<s:param name="id"><s:property value="id" /></s:param>
				     						</s:url>
											<a href="${viewSouv}" class="edit" data-toggle="tooltip" title="Souvenirs">
											<i class="material-icons">&#xe8f4;</i></a>
											<s:url  namespace="/mapgyver/voyages" action="doreadVoyage"  var="readVoy">
				     							<s:param name="id"><s:property value="id" /></s:param>
				     						</s:url>
											<a href="${readVoy}" class="edit" data-toggle="tooltip" title="Modifier">
											<i class="material-icons">&#xE254;</i></a>
											<a	href="deleteModalVoyages" data-id="<s:property 	value="id"/>" class="delete" data-toggle="modal"><i
												class="material-icons" data-toggle="tooltip"
												title="Supprimer">&#xE872;</i></a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
