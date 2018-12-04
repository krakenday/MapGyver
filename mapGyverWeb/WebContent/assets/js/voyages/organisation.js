/**
 * Script Javascript de voyages/voyages.jsp
 */

/*
 * fonction de control du formulaire **********************************************************
 * 
 */
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();




//
window.onload = initAll;
//
////Decalaration des variables globales pour pouvoir les utiliser tout au long du script
////devouverte de JQuery
var formCRUD 	= $("#formCRUD")[0];
//var titre		= $("#titre")[0];
//var depart		= $("#depart")[0];
//var nbParts 	= $("#quantite")[0];
//
////declaration des constantes 
//
//var okColor 	= 'white'; // couleur des messages d'erreur
//var ErrColor 	= 'red'; // couleur des messages d'erreur
/*
 * fonction initAll **********************************************************
 * initialise le formulaire
 * attribut les fonctions aux boutons
 * 
 */
function initAll() {
	//document.getElementById("create").addEventListener('click', function() 	{doCreate("./create");});
	formCRUD.onreset 	= initForm;
}

/*
 * initialisation du formulaire **********************************************
 * init message erreur
 */
function initForm() {
	formCRUD.reset();
/*Fermer les fenetres alerte de success et probleme*/
	$(".alert").alert('close');
}
//
///*
// * fonction pour creer un voyage***********************************************
// * 
// */
//function doCreate(url) {
//	if (checkCreate()){
////		doforward(url);
//	} else {
//		doErreurCreate();
//		event.preventDefault();
//	}
//}
//
///*
// * fonction de control des inputs pour creer un voyage*************************
// * 
// */
//function checkCreate() {
//	var check = false;
//	//alert("titre " + checkTitre() + " date  :" + checkDate() +" nb part : "+ checkNbParts());
//	if (checkTitre() & checkDate() & checkNbParts()){
//		check = true;
//	}
//	return check;
//}
//
///*
// * fonction en cas d'erreur ********************************************
// * 
// */
//function doErreurCreate() {
////	alert("error");
//}
//
///*
// * fonction de controle du titre ********************************************
// * false si titre null ou longueur non comprise entre 2 et 50 caracteres
// */
//function checkTitre() {
//	var check = true;
//	var vTitre = titre.value;
//	if (vTitre =='' || vTitre.length >= 50 || vTitre.length <= 2) {
//		check = false;
//		titre.style.backgroundColor = ErrColor;
//	}
//	return check;
//}
//
///*
// * fonction de controle de la date *******************************************
// * false si date non null et inexistante
// */
//function checkDate() {
//	var check = true;
//	var vDepart = depart.value;
//	if (vDepart != '' && !moment(vDepart).isValid()) {
//		check = false;
//		depart.style.backgroundColor = ErrColor;
//	}
//	return check;
//}
//
///*
// * fonction de controle du nb de participants *****************************
//  * false si nbparticipants non null et <0
// */
//function checkNbParts() {
//	var check = true;
//	var vNbParts = nbParts.value;
//	if (vNbParts != '' && vNbParts < 0) {
//		check =  false;
//		nbParts.style.backgroundColor = ErrColor;
//	}
//	return check;
//}
//
//
////function doforward(url) {
////	formCRUD.action = url;
////	formCRUD.submit();
////}
