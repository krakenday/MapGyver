/**
 * Script Javascript de la carte.jsp
 */

/**
 * affiche la map au demarrage de la page aux coordonnéees et au Zoom indiqué
 * .setView([lat, long], Zoom);
 */

var map = L.map('mapid').setView([47, 2], 5);

/**
 * affiche les references des contributeurs
 */
L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?' + 
		'access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYy' + 
		'cXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
	maxZoom: 18,
	attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">' + 
	'OpenStreetMap</a> contributors, ' +
	'<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
	'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
	id: 'mapbox.streets'
}).addTo(map);


/**
 * Lance l'action onMapCLick, lorsque l'on clique sur la carte
 */
map.on('click', onMapClick);
/**
 *Function qui affiche un marker avec une popup
 */
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

}/**
 * Html de la popup du marker
 * la fenetre comprend 
 * les coordonnées du point
 * une liste de POI
 * un bouton ajouter
 * un bouton supprimer
 */

var HTMLcontent = '<form  id="popup-form">\
	<div class="form-group">\
		<label for="selectPOI">Selectionner le lieu</label>\
		<input class="form-control" list=POI>\
		<datalist id="POI" name="POI" value="France">\
			<option value="France">France</option>\
			<option value="Espagne">Espagne</option>\
		</datalist>\
	</div>\
	<div class="mb-2">\
		<input type="button" value="valider" class="marker-add-button btn btn-primary btn-sm mr-3"/>\
		<input type="button" value="supprimer" class="marker-delete-button btn btn-danger btn-sm"/>\
	</div>\
	</form>';



/**
 * Function qui affecte les methodes aux boutons delete et add de la popup
 */
function onPopupOpen() {

	var tempMarker = this;

	var tempMarkerGeoJSON = this.toGeoJSON();

	//var lID = tempMarker._leaflet_id; // Getting Leaflet ID of this marker

	// To remove marker on click of delete
	$(".marker-delete-button:visible").click(function () {
		map.removeLayer(allMarkersGeoJsonArray);
	});

	$(".marker-add-button:visible").click(function (e) {
		alert(tempMarkerGeoJSON.geometry.coordinates);
	});
}

//getting all the markers at once
//function getAllMarkers() {
//
//	var allMarkersObjArray = [];//new Array();
//	var allMarkersGeoJsonArray = [];//new Array(); 
//
//	$.each(map._layers, function (ml) {
//		//console.log(map._layers)
//		if (map._layers[ml].feature) {
//
//			allMarkersObjArray.push(this)
//			allMarkersGeoJsonArray.push(JSON.stringify(this.toGeoJSON()))
//		}
//	})
//
//	console.log(allMarkersObjArray);
//	alert("total Markers : " + allMarkersGeoJsonArray.length + "\n\n" + 
//			allMarkersGeoJsonArray + "\n\n Also see your console for object view of this array" );
//}
//
//$(".get-markers").on("click", getAllMarkers);