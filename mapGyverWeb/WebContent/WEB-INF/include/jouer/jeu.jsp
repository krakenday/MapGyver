<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<h2 class="align-center">Creer votre jeu</h2>
	<s:form namespace="/mapgyver/uc6" action="jeucreatejeu" method="post" theme="simple"> 
	<div class="form-group row">
  <label for="example-text-input" class="col-2 col-form-label">Nom du jeu</label>
  <div class="col-2">
    <input class="form-control" type="text" value="" id="example-text-input">
  </div>
</div>
<div class="form-group row">
  <label for="example-date-input" class="col-2 col-form-label">Date fin inscription</label>
  <div class="col-2">
    <input class="form-control" type="date" value="2011-08-19" id="example-date-input">
  </div>
</div>
<div class="form-group row">
  <label for="example-date-input" class="col-2 col-form-label">Date Debut</label>
  <div class="col-2">
    <input class="form-control" type="date" value="2011-08-19" id="example-date-input">
  </div>
</div>
<div class="form-group row">
  <label for="example-date-input" class="col-2 col-form-label">Date Fin</label>
  <div class="col-2">
    <input class="form-control" type="date" value="2011-08-19" id="example-date-input">
  </div>
 </div>
 <div class="form-group row">
 <s:iterator value="photos">
 <s:property value="id"/></s:iterator>
 </div>
 <div class="align-center"> <s:submit cssClass="btn btn-dark btn-sm" value="Creer"></s:submit></div>
  </s:form>



      		
	
