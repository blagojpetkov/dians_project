var map = L.map('map').setView([41.994626, 21.430379], 13);
const attribution = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';
const tileUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileUrl, {attribution})
tiles.addTo(map);



var user = L.marker();
map.on('click', onMapClick);
function onMapClick(e) {
    user.setLatLng(e.latlng).addTo(map);
    document.getElementById("submit").disabled = false;
    document.getElementById("latitude").value = e.latlng.lat;
    document.getElementById("longitude").value = e.latlng.lng;
}



let open = false;
function hamburgerClick(){
    if(open) {
        document.getElementById("hamburger").classList.remove("rotate")
        open = false;
        document.getElementById("sidebar").hidden = true;
    }
    else
    {
        document.getElementById("hamburger").classList.add("rotate")
        open = true;
        document.getElementById("sidebar").hidden = false;
    }
}