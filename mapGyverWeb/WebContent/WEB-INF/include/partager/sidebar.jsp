<!-- header -->
<div class="sidebar" data-color="purple" data-image="<%=request.getContextPath()%>/assets/img/sidebar-2.jpg">

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
               <a href="<%= request.getContextPath() %>/vue/vue.partager/dashboard.jsp"><i class="pe-7s-graph"></i><p>MENU</p></a>
        	</li>
		</ul>
   	</div>
</div>

<div class="main-panel">
    <nav class="navbar navbar-default navbar-fixed">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">HOME</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li>
                       <a href="">
                            <i class="fa fa-search"></i>
				<p class="hidden-lg hidden-md">Search</p>
                        </a>
                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                       <a href="">Mon compte</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- header -->