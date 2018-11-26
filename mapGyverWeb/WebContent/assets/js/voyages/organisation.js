/**
 * Script Javascript de voyages/voyages.jsp
 */

window.onload = initAll;

//Decalaration des variables globales pour pouvoir les utiliser tout au long du script
//devouverte de JQuery
var formCRUD 	= $("#formCRUD")[0];
var titre		= $("#titre")[0];
var depart		= $("#depart")[0];
var nbParts 	= $("#quantite")[0];

//declaration des constantes 

var okColor 	= 'black'; // couleur des messages d'erreur
var ErrColor 	= 'red'; // couleur des messages d'erreur
/*
 * fonction initAll **********************************************************
 * initialise le formulaire
 * attribut les fonctions aux boutons
 * 
 */
function initAll() {
	initForm();
	document.getElementById("create").addEventListener('click', function() 	{doCreate("./create");});
	formCRUD.onreset 	= initForm;
}

/*
 * initialisation du formulaire **********************************************
 * init message erreur
 */
function initForm() {
	titre.style.color 	= okColor; 
	depart.style.color 	= okColor; 
	nbParts.style.color = okColor; 
	formCRUD.reset();
}

/*
 * fonction pour creer un voyage***********************************************
 * 
 */
function doCreate(url) {
	if (checkCreate()){
//		doforward(url);
	} else {
		doErreurCreate();
		event.preventDefault();
	}
}

/*
 * fonction de control des inputs pour creer un voyage*************************
 * 
 */
function checkCreate() {
	var check = false;
	//alert("titre " + checkTitre() + " date  :" + checkDate() +" nb part : "+ checkNbParts());
	if (checkTitre() & checkDate() & checkNbParts()){
		check = true;
	}
	return check;
}

/*
 * fonction en cas d'erreur ********************************************
 * 
 */
function doErreurCreate() {
//	alert("error");
}

/*
 * fonction de controle du titre ********************************************
 * false si titre null ou longueur non comprise entre 2 et 50 caracteres
 */
function checkTitre() {
	var check = true;
	var vTitre = titre.value;
	if (vTitre =='' || vTitre.length >= 50 || vTitre.length <= 2) {
		check = false;
		titre.style.color = ErrColor;
	}
	return check;
}

/*
 * fonction de controle de la date *******************************************
 * false si date non null et inexistante
 */
function checkDate() {
	var check = true;
	var vDepart = depart.value;
	if (vDepart != '' && !moment(vDepart).isValid()) {
		check = false;
		depart.style.color = ErrColor;
	}
	return check;
}

/*
 * fonction de controle du nb de participants *****************************
  * false si nbparticipants non null et <0
 */
function checkNbParts() {
	var check = true;
	var vNbParts = nbParts.value;
	if (vNbParts != '' && vNbParts < 0) {
		check =  false;
		nbParts.style.color = ErrColor;
	}
	return check;
}


//function doforward(url) {
//	formCRUD.action = url;
//	formCRUD.submit();
//}
