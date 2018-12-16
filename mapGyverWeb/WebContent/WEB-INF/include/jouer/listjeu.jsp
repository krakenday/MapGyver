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
      <tr>
        <th scope="row"><s:property value="%{#jeuxStatus.count}"/></th>
        <td class="text-center"><s:property value="nom"/></td>
        <td class="text-right"><s:form namespace="/mapgyver/uc6" action="jouer" method="post" theme="simple">
        	  <td class="text-center">
        	  <s:hidden name="idJeu" value="%{id}"/>
        	  <s:submit cssClass="btn btn-dark btn-sm" value="jouer"></s:submit>
        	</s:form></td>
      </tr>
      </s:iterator>
    </tbody>
  </table>
</div>
