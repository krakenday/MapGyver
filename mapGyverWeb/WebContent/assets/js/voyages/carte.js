/**
 * Script Javascript de la carte.jsp
 */

/**
 * Utilitaire Map 
 * contributeurs
 */

var mymap = L.map('mapid').setView([47, 2], 6);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
	maxZoom: 18,
	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
	'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
	'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
	id: 'mapbox.streets'
}).addTo(mymap);


/**
 * action sur click
 */


function onMapClick(e) {
	  
    L.marker(e.latlng,{
    	title : 'Yeah!!!',
    	draggable : false
    	
    }).addTo(mymap);

}

mymap.on('click', onMapClick);




/**
 * Controles
 */




