<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String success = (String) request.getAttribute("success");
	String probleme = (String) request.getAttribute("probleme");
%>
<form method="get" name="formCRUD" id="formCRUD">
	<!-- Voyages -->
	<div class="row">
		<div class="col-lg-6">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-map-marker"></i> Carte
				</div>
				<div class="card-body">
					<div id="mapid"></div>
				</div>
			</div>
			<%if (success!=null) {%>
			<div class="alert alert-success" role="alert" id="success"><%=success%></div>
			<%}%>
			<%if (probleme!=null) {%>
			<div class="alert alert-danger" role="alert" id="probleme"><%=probleme%></div>
			<%}%>
		</div>
		<div class="col-lg-6">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-plane"></i> Informations du voyage
				</div>
				<div class="card-body">
					<jsp:include page="/WEB-INF/include/voyages/form.jsp" />
				</div>
			</div>
			<div class="mb-3 px-1 text-right">
				<button type="submit" class="btn btn-success" id="create"
					name="todo" value="create">Cr&eacute;er</button>
				<button type="submit" class="btn btn-warning" id="update"
					name="todo" value="update">Modifier</button>
				<button type="reset" class="btn btn-secondary ml-3" id="redo"
					name="redo">Reset</button>
			</div>
			<div class="card mb-3">
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
