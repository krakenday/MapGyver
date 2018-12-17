<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="table-responsive">
  
   <div class="align-center">
      <s:actionmessage cssClass="bg-success align-center"/>
   </div>
    <div class="align-center">
      <s:actionerror cssClass="bg-danger"/>
   </div>
   
   <s:if test="msg!=null">
   	<div><s:property value="msg"/></div>
   </s:if>
  	
  <table class="table">
    <thead>
      <tr>
        <th scope="col"></th>
        <td class="text-center">liste des Jeux</td>
       <td></td>
      </tr>
    </thead>
    <tbody>
       <s:iterator value="jeux" status="jeuxStatus">
      <tr>
        <th scope="row"><s:property value="%{#jeuxStatus.count}"/></th>
        <td class="text-center"><s:property value="nom"/></td>
        <td class="text-center">
        	<s:form namespace="/mapgyver/uc6" action="jouer" method="post" theme="simple">
        	  <s:hidden name="idJeu" value="%{id}"/>
        	  <s:submit cssClass="btn btn-dark btn-sm" value="Participer"></s:submit>
        	  </s:form>
        	  <s:form namespace="/mapgyver/uc6" action="listjeudeletJeu" method="post" theme="simple">
        	   <s:hidden name="idJeu" value="%{id}"/>
        	  <s:submit cssClass="btn btn-danger btn-sm" value="Supprimer"></s:submit>
        	</s:form>
       </td>
      </tr>
      </s:iterator>
    </tbody>
  </table>

</div>
