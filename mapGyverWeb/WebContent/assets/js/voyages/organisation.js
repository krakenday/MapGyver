

/**
 * Script Javascript de la frmBonbon.jsp
 */

window.onload = initAll;

function initAll() {
	console.log("begin");
	initForm();
}
function initForm() {	
//	document.getElementById("create").addEventListener('click', function() 	{forward("./create");});
//	document.getElementById("read").addEventListener('click',	function() 	{forward("./read");});
//	document.getElementById("update").addEventListener('click',	function() 	{forward("./update");});
//	document.getElementById("delete").addEventListener('click',	function() 	{forward("./delete");});
//	
//	document.getElementById("readByName").addEventListener('click',	function() 	{forward("./readByName");});
//	document.getElementById("deleteAll").addEventListener('click', function() 	{forward("./deleteAll");});
	formCRUD.onreset 	= initForm;
}

/*
 * initialisation du formulaire **********************************************
 * init message erreur
 */
function initForm() {
	formCRUD.reset();
//	document.getElementById('success').hidden = true;
//	document.getElementById('probleme').hidden = true;
}
function forward(url) {
//	alert(url);
	formCRUD.action = url;
	formCRUD.submit();
}
