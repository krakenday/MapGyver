/**
* Script d'affichage du bouton de suppression d'un utlisateur
*/
function supCompte() {
      var confirmSupp = document.getElementById("confirmSupp");

      if (confirmSupp.style.display === "none") {
          confirmSupp.style.display = "block";
          confirmSupp.scrollIntoView();
      }
       else 
          confirmSupp.style.display = "none";
}
    