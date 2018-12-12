<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="<%=request.getContextPath()%>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>MapGyver</span>
          </a>
        </li>
        <jsp:include page="/WEB-INF/include/voyages/liens.jsp" />
  <!--        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
            <span>Mes infos</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
            <h6 class="dropdown-header">*** Ajout:</h6>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/login.jsp">Info utilisateur</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/login.jsp">Mes groupes</a>
            <a class="dropdown-item" href="<%=request.getContextPath()%>/mapgyver/register.jsp">Mes listes de diff</a>
            <div class="dropdown-divider"></div>
          </div>
        </li>
  -->
  		<li class="nav-item">
          <s:a class="nav-link" namespace="/mapgyver/utilisateur" action="gererUtilisateur">
            <i class="fas fa-user-circle fa-fw"></i>
            <span>Mes infos</span>
          </s:a>
        </li>
        
        <!-- link UC3 Partager -->
        <li class="nav-item">
          <s:a class="nav-link" namespace="/mapgyver/uc3" action="afficheDashboard">
            <i class="fas fa-fw fa-table"></i>
            <span>Partager</span></s:a>
        </li>
        <!-- end link UC3 Partager -->
        
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath()%>/mapgyver/souvenirs/"><!-- envoyer vers mon controleur souvenir -->
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
            <s:a class="dropdown-item" namespace="/mapgyver/uc1" action="afficheLogin">Login</s:a>
            <s:a class="dropdown-item" namespace="/mapgyver/utilisateur" action="register">Register</s:a>
            <s:a class="dropdown-item" namespace="/mapgyver/uc1" action="doforgot">Forgot Password</s:a>
            <div class="dropdown-divider"></div>
            <h6 class="dropdown-header">Other Pages:</h6>
            <s:a class="dropdown-item" namespace="/mapgyver" action="page404">404 Page</s:a>
            <s:a class="dropdown-item" namespace="/mapgyver" action="blank">Blank Page</s:a>
            <div class="dropdown-divider"></div>
          </div>
        </li>
      </ul>
  