<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="<%=request.getContextPath()%>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>MapGyver</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/mpg/voyages/">
            <i class="fas fa-fw fa-table"></i>
            <span>voyages</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/mpg/souvenirs/"><!-- envoyer vers mon controleur souvenir -->
            <i class="fas fa-fw fa-table"></i>
            <span>souvenirs</span></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Autres pages</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">Login Screens:</h6>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/login.jsp">Login</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/register.jsp">Register</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/forgot-password.jsp">Forgot Password</a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/404.jsp">404 Page</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mpg/blank.jsp">Blank Page</a>
            <div class="dropdown-divider"></div>
          </div>
        </li>
      </ul>
  