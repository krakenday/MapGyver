<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
         <!-- Voyages -->
          <div class="row">
            <div class="col-lg-6">
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-map-marker"></i>
                  Carte</div>
                <div class="card-body">
                  <div id="mapid"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-plane"></i>
                  Mes voyages</div>
                <div class="card-body">
					<jsp:include page="/WEB-INF/include/voyages/form.jsp" />
                </div>	
              </div>
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-tachometer-alt"></i>
                  Etapes</div>
                <div class="card-body">
                 <jsp:include page="/WEB-INF/include/voyages/etapes.jsp" />
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-header">
                  <i class="fas fa-book"></i>
                  Informations</div>
                <div class="card-body">
                 <jsp:include page="/WEB-INF/include/voyages/informations.jsp" />
                </div>
              </div>
            </div>
          </div>