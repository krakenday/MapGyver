<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<li class="nav-item dropdown">
  <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/mapgyver/voyages/" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <i class="fas fa-fw fa-plane"></i>
    <span>Voyages</span>
  </a>
  <div class="dropdown-menu" aria-labelledby="pagesDropdown">
  <s:a class="dropdown-item" namespace="/mapgyver/voyages" action="doreadRoadBook">Mon RoadBook</s:a>
  <s:a class="dropdown-item" namespace="/mapgyver/voyages" action="doreadVoyage">Mon Voyage</s:a>
  </div>
</li>