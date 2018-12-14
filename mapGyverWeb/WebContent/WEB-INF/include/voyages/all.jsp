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
										Liste des <b>Voyages</b> de tous les utilisateurs
									</h2>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th> </th>
									<th>Titre</th>
									<th>Date de départ</th>
									<th>Nbr Participants</th>
								</tr>
							</thead>
							<tbody>
							<s:iterator value="voyages">
								<tr>
									<td> </td>
									<td><s:property 	value="nom"/></td>
									<td><s:property 	value="DateDebutToString"/></td>
									<td><s:property 	value="nbParticipant"/></td>
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
