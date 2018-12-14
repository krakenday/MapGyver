<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
	<s:form namespace="/mapgyver/uc6" action="jouerrepondreElire" method="post" theme="simple"> 
		<%= request.getContextPath() %>/mapgyver/jouer
		<div class="row">
      		<s:iterator value="jeu.photos" status="jeuStatus">
	   		<div class="col-lg-3 col-md-4 col-xs-6 thumb">
	        	<a class="thumbnail" href=<s:property value="url"/>>
	            	<img class="img-thumbnail"
	                	src=<s:property value="url"/>
	                    alt="Another alt text">
	            </a>
	            	<input type="radio" name="radioId" value=10 checked>
	    	</div>
	    	</s:iterator>
	    	
	    	
	    	<div class="col-lg-3 col-md-4 col-xs-6 thumb">
	        	<a class="thumbnail" href="http://localhost:8080/mapGyverWeb/assets/img/jouer1.jpg">
	            	<img class="img-thumbnail"
	                	src="http://localhost:8080/mapGyverWeb/assets/img/jouer1.jpg"
	                    alt="Another alt text">
	            </a>
	            	<input type="radio" name="radioId" value=11>
	    	</div>
		</div>
		<div><div><s:submit cssClass="btn btn-secondary btn-lg float-right" value="voter"></s:submit></div></div>
	</s:form>  
</div>