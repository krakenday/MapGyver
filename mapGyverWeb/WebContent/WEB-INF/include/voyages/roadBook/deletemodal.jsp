<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="supprimerDocumentModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form  method="get" action="<%=request.getContextPath()%>/mapgyver/voyages/roadBook">
				<div class="modal-header">
					<h4 class="modal-title">Supprimer Voyage</h4>
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
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Annuler"> <input type="submit"
						class="btn btn-danger" value="Supprimer">
				</div>
			</form>
		</div>
	</div>
</div>