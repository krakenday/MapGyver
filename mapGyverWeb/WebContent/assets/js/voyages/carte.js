/**
 * Script Javascript de la carte.jsp
 */

/**
 * Utilitaire Map 
 * contributeurs
 */

var map = L.map('mapid').setView([47, 2], 6);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
	maxZoom: 18,
	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
	'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
	'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
	id: 'mapbox.streets'
}).addTo(map);


/**
 * action sur click
 */


function onMapClick(e) {

	L.marker(e.latlng,{
		title : 'Yeah!!!',
		riseOnHover: true,
		draggable : false,
	}).addTo(mymap);

}

map.on('click', onMapClick);




/**
 * Controles
 */



//Script for adding marker on map click
function onMapClick(e) {

	var geojsonFeature = {
			"type": "Feature",
			"properties": {},
			"geometry": {
				"type": "Point",
				"coordinates": [e.latlng.lat, e.latlng.lng]
			}
	}

	var marker;

	L.geoJson(geojsonFeature, {

		pointToLayer: function(feature, latlng){

			marker = L.marker(e.latlng, {

//				title: "Resource Location",
//alt: "Resource Location",
				riseOnHover: true,
				draggable: false,

			}).bindPopup('<div class="mb-2">'+e.latlng+'</div>'+ HTMLcontent);

			marker.on("popupopen", onPopupOpen);

			return marker;
		}
	}).addTo(map);
	marker.openPopup();
}

var HTMLcontent = '<form  id="popup-form">\
	<div class="form-group">\
		<label for="selectPOI">Selectionner le lieu</label>\
		<input class="form-control" list=lieu>\
		<datalist id="lieu" name="lieu" value="Marseille">\
			<option value="Aix"></option>\
			<option value="Auriol"></option>\
		</datalist>\
	</div>\
	<div class="mb-2">\
		<input type="button" value="valider" class="marker-add-button btn btn-primary btn-sm mr-3"/>\
		<input type="button" value="supprimer" class="marker-delete-button btn btn-danger btn-sm"/>\
	</div>\
	</form>';



//Function to handle delete as well as other events on marker popup open
function onPopupOpen() {

	var tempMarker = this;

	var tempMarkerGeoJSON = this.toGeoJSON();

	//var lID = tempMarker._leaflet_id; // Getting Leaflet ID of this marker

	// To remove marker on click of delete
	$(".marker-delete-button:visible").click(function () {
		map.removeLayer(tempMarker);
	});

	$(".marker-add-button:visible").click(function (e) {
		alert(tempMarkerGeoJSON.geometry.coordinates);
	});
}


//getting all the markers at once
function getAllMarkers() {

	var allMarkersObjArray = [];//new Array();
	var allMarkersGeoJsonArray = [];//new Array(); 

	$.each(map._layers, function (ml) {
		//console.log(map._layers)
		if (map._layers[ml].feature) {

			allMarkersObjArray.push(this)
			allMarkersGeoJsonArray.push(JSON.stringify(this.toGeoJSON()))
		}
	})

	console.log(allMarkersObjArray);
	alert("total Markers : " + allMarkersGeoJsonArray.length + "\n\n" + allMarkersGeoJsonArray + "\n\n Also see your console for object view of this array" );
}

$(".get-markers").on("click", getAllMarkers);