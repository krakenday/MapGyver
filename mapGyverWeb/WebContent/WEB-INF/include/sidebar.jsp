<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="<%=request.getContextPath()%>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>MapGyver</span>
          </a>
        </li>
        <jsp:include page="/WEB-INF/include/voyages/liens.jsp" />
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Autres pages</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/login.jsp">Login</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/register.jsp">Register</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/forgot-password.jsp">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/404.jsp">404 Page</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/blank.jsp">Blank Page</a>
            <div class="dropdown-divider"></div>
          </div>
        </li>
      </ul>
  