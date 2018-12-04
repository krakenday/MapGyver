<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<%
	Voyage voyage = (Voyage) request.getAttribute("voyage");
	String success = (String) request.getAttribute("success");
	String probleme = (String) request.getAttribute("probleme");
	String action = "roadBook/add/";
	if (voyage!=null) action = "update/"+voyage.getId()+"/"	;
%>
<form method="get" name="formCRUD" id="formCRUD"  action="<%=request.getContextPath() %>/mapgyver/voyages/<%=action%>" class="needs-validation" novalidate>
	<!-- Voyages -->
	<div class="row">
		<div class="col-lg-6">
			<div class="card mb-3  shadow">
				<div class="card-header">
					<i class="fas fa-map-marker"></i> Carte
				</div>
				<div class="card-body">
					<div id="mapid"></div>
				</div>
			</div>
			<%if (success!=null) {%>
				<div class="alert alert-success shadow alert-dismissible fade show" role="alert" id="success"><%=success%>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    	<span aria-hidden="true">&times;</span>
				  	</button>
			  	</div>
			<%}%> 
			<%if (probleme!=null) {%>
				<div class="alert alert-danger  shadow alert-dismissible fade show" role="alert" id="probleme"><%=probleme%>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    	<span aria-hidden="true">&times;</span>
				  	</button>
			  	</div>
			<%}%>
			</div>
		<div class="col-lg-6">

					<jsp:include page="/WEB-INF/include/voyages/form.jsp" />

			<div class="card mb-3  shadow">
				<div class="card-header">
					<i class="fas fa-tachometer-alt"></i> Etapes du voyage
				</div>
				<div class="card-body">
					<jsp:include page="/WEB-INF/include/voyages/etapes.jsp" />
				</div>
			</div>

		</div>
	</div>
</form>
