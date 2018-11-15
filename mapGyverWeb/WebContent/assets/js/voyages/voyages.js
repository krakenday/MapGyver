

/**
 * Script Javascript de la frmBonbon.jsp
 */

window.onload = initAll;

function initAll() {
	console.log("begin");
	initForm();
}
function initForm() {	
	document.getElementById("create").addEventListener('click', function() 	{forward("./create");});
	document.getElementById("read").addEventListener('click',	function() 	{forward("./read");});
	document.getElementById("update").addEventListener('click',	function() 	{forward("./update");});
	document.getElementById("delete").addEventListener('click',	function() 	{forward("./delete");});
	
	document.getElementById("readByName").addEventListener('click',	function() 	{forward("./readByName");});
	document.getElementById("deleteAll").addEventListener('click', function() 	{forward("./deleteAll");});
}


function forward(url) {
//	alert(url);
	formCRUD.action = url;
	formCRUD.submit();
}
