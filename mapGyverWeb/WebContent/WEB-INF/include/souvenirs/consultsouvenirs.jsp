<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
    
<div class="row">	 
	 <div class="col-8">
		 <div class="album py-5 bg-light">
	        <div class="container">
	          <div class="row">
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
	                <img class="card-img-top" src="<%=request.getContextPath()%>/imagessouvenirs/perou.jpg" alt="Card image cap">
	                <div class="card-body">										
	                  <p class="card-text">cas 1 = photo + commentaire = 1 souvenir (il s agit forcement du commentaire de la photo)  .</p>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Supr</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
	                <div class="card-body">										
	                  <p class="card-text">Cas2: uniquement 1 commentaire: 1 commentaire = 1Souvenir  .</p>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Supr</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	            <div class="col-md-4">
	              <div class="card mb-4 box-shadow">
	                <img class="card-img-top" src="<%=request.getContextPath()%>/imagessouvenirs/manhatan.jpg" alt="Card image cap">
	                <div class="card-body">										
	                  <p class="card-text">cas3= pas de com. UnPhoto = 1souvenir.</p>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Supr</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
      </div> 
	</div>
	
	<div class="col-4 form-group">
		<s:form  namespace="/mapgyver/uc2" action="doCreate" theme="simple"
				 method="POST" enctype="multipart/form-data">
			 <p>
			  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
			    Ajouter un souvenir
			  </button>
			</p>
			<div class="collapse" id="collapseExample">
			  <div class="card card-body">
			    <div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
				  </div>
				    <div class="custom-file">
					    <s:file class="custom-file-input" name="file" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01"/>
					    <label class="custom-file-label" for="inputGroupFile01">Choisir image a ajouter</label>
				  	</div>
				</div>
				<%--  <div>
					<s:select label="Choisissez un point d interet" 
						headerKey="0" headerValue="Select point of interest"
						list="id" 
						name="nom" />
				</div>--%>
				<div>
					<s:hidden name="idVoyage" value="747"/>
				</div>
				<div>
				  <s:label for="comment">Commentaire:</s:label>
				  <s:textarea class="form-control" rows="5" id="comm" name="comm"></s:textarea>
				  <button type="submit" class="btn btn-dark mt-2 ">Enregistrer</button>
				</div>
			  </div>
			</div>
		</s:form>
	</div>
</div>