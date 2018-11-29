<!-- header & menu-->
<div class="sidebar" data-color="purple" data-image="../../assets/img/sidebar-2.jpg">

    <!-- 
    	 Choix 1: permet de changer la couleur de la sidebar en utilisant: data-color="blue | azure | green | orange | red | purple".
		 Choix 2: permet de changer l'image dans le data-image.
    -->

   	<div class="sidebar-wrapper">
           <div class="logo">
               <a href="<%=request.getContextPath()%>/vue/index.jsp" class="simple-text">MAPGYVER</a>
           </div>

           <ul class="nav">
               <li class="active">
                   <a class="btnMenu" href="dashboard.jsp">
                    <i class="pe-7s-graph"></i>
                    <p>MENU</p>
                   </a>
               </li>
               <li>
                   <a class="btnVoyage" href="voyage.jsp">
                       <i class="pe-7s-plane"></i>
                       <p>Voyage</p>
                   </a>
               </li>
               <li>
                   <a class="btnPhoto" href="<%= request.getContextPath() %>/vue/vue.partager/photo.jsp">
                       <i class="pe-7s-photo"></i>
                       <p>Photo</p>
                   </a>
               </li>
               <li>
                   <a class="btnPointInteret" href="pointInteret.jsp">
                       <i class="pe-7s-culture"></i>
                       <p>Point d'intérêt</p>
                   </a>
               </li>
               <li>
                   <a class="btnMail" href="#">
                       <i class="pe-7s-mail"></i>
                       <p>Mail</p>
                   </a>
               </li>
               <li>
                   <a href="#">
                       <i class="pe-7s-map-marker"></i>
                       <p>A DEFINIR</p>
                   </a>
               </li>
           </ul>
    </div>
</div>
<!-- header & menu-->
        