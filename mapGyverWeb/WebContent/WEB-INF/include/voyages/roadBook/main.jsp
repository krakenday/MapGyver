<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<%@ page import="java.util.Iterator"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<jsp:useBean id="roadBook" scope="request" class="business.uc4Voyage.RoadBook" />
<%
	String success = (String) request.getAttribute("success");
	String probleme = (String) request.getAttribute("probleme");
%>

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
									<a href="<%=request.getContextPath()%>/mapgyver/voyages"
										class="btn btn-success"><i class="material-icons">&#xE147;</i>
										<span>Ajouter nouveau voyage</span></a> <a
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
								<%	Iterator<Voyage> iterVoyage = roadBook.getVoyages().iterator();
										while (iterVoyage.hasNext()) {
											Voyage voyage = iterVoyage.next();
											String id 		= Integer.toString(voyage.getId());
											String titre 	= voyage.getNom();
											String date 	= "";
											if(voyage.getDateDebut()!=null){
												date = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(voyage.getDateDebut());
											}
											String nbParts 	= voyage.getNbParticipant()==null? " " : Integer.toString(voyage.getNbParticipant());
								%>
								<tr>
									<td><span class="custom-checkbox"> <input
											type="checkbox" id="checkbox<%=id%>" name="options[]"
											value="<%=id%>"> <label for="checkbox<%=id%>"></label>
									</span></td>
									<td><%=titre%></td>
									<td><%=date%></td>
									<td><%=nbParts%></td>
									<td><a
										href="<%=request.getContextPath()%>/mapgyver/voyages/<%=id%>"
										class="edit"><i class="material-icons"
											data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
										href="" data-id="<%=id%>" class="delete" data-toggle="modal"><i
											class="material-icons" data-toggle="tooltip"
											title="Supprimer">&#xE872;</i></a></td>
								</tr>
									<%}%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
