<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="business.uc4Voyage.RoadBook"%>
<div id="deleteModalRoadBook" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<s:form id="roadBook"  method="post" action="dodeleteRoadBook" theme="simple" > 
				<div class="modal-header">
					<h4 class="modal-title">Supprimer RoadBook</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Etes vous sure d'effectuer cette operation?</p>
					<p class="text-warning">
						<small>Cette action est irreversible </small>
					</p>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler">
					<input type="submit" class="btn btn-danger" value="Supprimer">
				</div>
			</s:form>
		</div>
	</div>
</div>