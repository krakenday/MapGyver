<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
	
		<h2 class="align-center">Voter pour votre photographie favorite</h2>
		<div class="row">
      		
      		<s:iterator value="jeu.photos" status="photosStatus">
	   		<div class="col-lg-3 col-md-4 col-xs-6 thumb">
	        	<a class="thumbnail" href=<s:property value="url"/>>
	            	<img class="img-thumbnail"
	                	src=<s:property value="url"/>
	                    alt="Another alt text">
	            </a>
	          <s:form namespace="/mapgyver/uc6" action="jouerrepondreElire" method="post" theme="simple"> 
        	  <td class="text-center">
        	   <s:hidden name="idJeu" value="%{jeu.id}"/>
        	  <s:hidden name="idPhoto" value="%{id}"/>
        	  <s:submit cssClass="btn btn-dark btn-sm" value="Voter"></s:submit>
        	</s:form>
	    	</div>
	    	</s:iterator>
	    
		</div>
		<div><div><s:submit cssClass="btn btn-secondary btn-lg float-right" value="voter"></s:submit></div></div>
	
</div>