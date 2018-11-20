<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<li class="nav-item dropdown">
  <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/mpg/voyages/" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <i class="fas fa-fw fa-plane"></i>
    <span>Voyages</span>
  </a>
  <div class="dropdown-menu" aria-labelledby="pagesDropdown">
  <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/voyages/">Mon Dashboard</a>
  <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/voyages/">Mon Voyage</a>
  </div>
</li>