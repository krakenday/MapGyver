<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="business.uc4Voyage.RoadBook"%>
<%
	RoadBook roadBook = (RoadBook) request.getAttribute("roadBook");
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
										<a href="<%=request.getContextPath()%>/mapgyver/voyages" class="btn btn-success"
											><i class="material-icons">&#xE147;</i>
											<span>Ajouter nouveau voyage</span></a> <a
											href="#supprimerDocumentModal" class="btn btn-danger"
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
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox1" name="options[]" value="1">
												<label for="checkbox1"></label>
										</span></td>
										<td>Voyage au centre de la terre</td>
										<td>22/12/2018</td>
										<td>12</td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=1" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox2" name="options[]" value="1">
												<label for="checkbox2"></label>
										</span></td>
										<td>Bayonne ou Guantanamo</td>
										<td>29/12/2018</td>
										<td>5</td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=2" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox3" name="options[]" value="1">
												<label for="checkbox3"></label>
										</span></td>
										<td>Casa del Papel</td>
										<td>25/12/2018</td>
										<td></td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=3" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox4" name="options[]" value="1">
												<label for="checkbox4"></label>
										</span></td>
										<td>Guingamp</td>
										<td>02/01/2019</td>
										<td>3</td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=4" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox5" name="options[]" value="1">
												<label for="checkbox5"></label>
										</span></td>
										<td>Beverly hills</td>
										<td></td>
										<td>50</td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=5" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
									<tr>
										<td><span class="custom-checkbox"> <input
												type="checkbox" id="checkbox6" name="options[]" value="1">
												<label for="checkbox6"></label>
										</span></td>
										<td>Silicon Valley</td>
										<td>01/04/2019</td>
										<td></td>
										<td><a href="<%=request.getContextPath()%>/mapgyver/voyages?id=6" class="edit"><i class="material-icons"
												data-toggle="tooltip" title="Modifier">&#xE254;</i></a> <a
											href="#supprimerDocumentModal" class="delete"
											data-toggle="modal"><i class="material-icons"
												data-toggle="tooltip" title="Supprimer">&#xE872;</i></a></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
