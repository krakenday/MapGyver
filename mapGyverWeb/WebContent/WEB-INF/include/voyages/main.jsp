<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="business.uc4Voyage.Voyage"%>
<s:form method="post" name="formCRUD" id="formCRUD"  action="afficheVoyage" theme="simple" class="needs-validation">
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
			<s:if test="success!=null">
				<div class="alert alert-success shadow alert-dismissible fade show" role="alert" id="success"><s:property value="success" />
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    	<span aria-hidden="true">&times;</span>
				  	</button>
			  	</div>
			  	</s:if>
			  	<s:if test="probleme!=null">
				<div class="alert alert-danger  shadow alert-dismissible fade show" role="alert" id="probleme"><s:property value="probleme" />
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    	<span aria-hidden="true">&times;</span>
				  	</button>
			  	</div>
			</s:if>
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
</s:form>
