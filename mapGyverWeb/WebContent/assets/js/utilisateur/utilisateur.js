/**
 * Script utilisateur
 */
window.onload = initAll();

/*
 * Initialise les différentes functions
 */
function initAll() {
	afficherAgeUtilisateur();
	console.log("init");
}
 
/**
* Script d'affichage de l'age de l'utilisateur
*/
function afficherAgeUtilisateur() {
	
	var aujourdhui = new Date();
	
	// Récuperer la date retourné dans l'html (possibilité de faire mieux et d'intercepter avant!?)
	var htmlDateNaiss= document.getElementById("age");
	var dateNaiss;
	if(htmlDateNaiss.textContent) {
		dateNaiss= htmlDateNaiss.textContent;
	}
	//Convertir la date String en Date
	var anniv = new Date(dateNaiss);
	var age = aujourdhui.getFullYear() - anniv.getFullYear();
    var mois = aujourdhui.getMonth() - anniv.getMonth();
    // Controler le mois et les jours si ils sont null ou negatifs on aura une année de moins
    if (mois < 0 || (mois === 0 && aujourdhui.getDate() < anniv.getDate())) {
        age--;
    }
    // Controle supplementaire (incomplet)
     if(age > 0)	
    	 htmlDateNaiss.innerHTML= age + " ans";
     else if(age <= 0)
    	 htmlDateNaiss.innerHTML= "Tiens pas encore 1 an!!"
}

/**
* Script d'affichage du bouton de suppression d'un utilisateur
*/
function supCompte() {
      var confirmSupp = document.getElementById("confirmSupp");
      console.log("collapse");
      if (confirmSupp.style.display === "none") {
          confirmSupp.style.display = "block";
          confirmSupp.scrollIntoView();
      }
       else 
          confirmSupp.style.display = "none";
}