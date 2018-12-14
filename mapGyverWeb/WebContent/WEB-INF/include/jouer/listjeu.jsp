<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>



<div class="table-responsive">
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
       <s:url  namespace="/mapgyver/uc6" action="joueraffJeu"  var="urlAffJouer">
		     						<s:param name="jeu"><s:property/></s:param>
		     						</s:url>
      <tr>
        <th scope="row"><s:property value="%{#jeuxStatus.count}"/></th>
        <td class="text-center"><s:property value="nom"/></td>
        <td class="text-right"><s:form namespace="/mapgyver/uc6" action="jouer" method="post" theme="simple">
        	<s:hidden name="jeu" value="<s:property/>" />
        	<s:submit cssClass="btn btn-dark btn-sm" value="jouer"></s:submit></s:form></td>
        <td class="text-right"><a href="${urlAffJouer}" class="btn btn-dark btn-sm">Jouer</a></td>
      </tr>
      </s:iterator>
    </tbody>
  </table>
</div>