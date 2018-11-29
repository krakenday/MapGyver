/**
 * Script Javascript de la page partageable
 */
window.onload = initAll;

/*
 * Initialise les différentes function
 */
function initAll() {
	console.log("begin");
	initForm();
}

function initForm() {
	document.getElementById("btnSubmit").addEventListener('click', envoiFormulaire);
}


/*
 * Check du formulaire
 */
function envoiFormulaire() {
	console.log("CHECK DU FORMULAIRE");								//TODO: Supprimer ligne
//	allCheck();														//TODO: Enlever les commentaires pour rendre actif
	
	if (allCheck()) {
        console.log("ENVOIE DU FORMULAIRE OK");						//TODO: Supprimer ligne
        document.getElementById("message").innerText = "Envoi du formulaire possible";
    }else{
        document.getElementById("message").innerText = "Le formulaire n'est pas complet";
    }
}

/*
 * Regroupe toutes les méthode de check du formulaire
 */
function allCheck() {
	var check = false;
	if (checkBoxButton() & checkRadioButton() & checkTypeDescription()){
		checkBoxButton();
		checkTypeDescription();
		checkDescription();
		checkRadioButton();
		check = true;
	}
	return check;
}

/*
 * Check du checkBox sélectionné
 */
function checkBoxButton() {
	var testCheckBox 	= false;
	var whichCheckBox 	= document.getElementsByName("group1");
	var length 			= whichCheckBox.length;
	
	for (i = 0; i < length; i++) {
		if (whichCheckBox[i].checked) {
			testCheckBox = true;
			console.log("You have checked the " + whichCheckBox[i].value + " checkBox buttons.");	//TODO: Supprimer ligne
		}
	}
	console.log("GROUPE : " + testCheckBox);														//TODO: Supprimer ligne
	return testCheckBox;
}


/*
 * Check du radio button sélectionné
 */
function checkRadioButton() {
	var testCheckRadio 		= false;
	var whichRadioButton 	= document.getElementsByName("group2");
	var length 				= whichRadioButton.length;
	
	for (i = 0; i < length; i++) {
		if (whichRadioButton[i].checked) {  
			testCheckRadio = true;
			console.log("You have checked the " + whichRadioButton[i].value + " radio buttons.");//TODO: Supprimer ligne
		}
	}
	console.log("CRUD : " + testCheckRadio);													 //TODO: Supprimer ligne
	return testCheckRadio;
}


/*
 * Check du libelle du type de description
 */
function checkTypeDescription() {
	var testTypeDescription 	= false; 												
	var whichTypeDescription 	= document.getElementById("lblTypeDescription").value;
	
	if (whichTypeDescription > 0) {
		testTypeDescription = true;
	}
    console.log(document.getElementById("lblTypeDescription").value);					//TODO: Supprimer ligne
    console.log("Type description : " + testTypeDescription);							//TODO: Supprimer ligne
    return testTypeDescription;
}


/*
 * Check du libelle du text area de description
 */
function checkDescription() { 															//TODO: Boolean non fonctionnel
	var testCheckTxtArea 	= false;														//TODO:Remettre false
    var commentaire 		= document.getElementById("txtAreaDescription").value;	//TODO: Supprimer ligne
    console.log(commentaire);															//TODO: Supprimer ligne
    
    if (commentaire.length >= 2 && commentaire.length < 300 ) {
    	testCheckTxtArea = true;
	}
    console.log("Description : "+testCheckTxtArea);										//TODO: Supprimer ligne
    return testCheckTxtArea;
}
