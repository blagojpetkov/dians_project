
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

let latitude = document.getElementById("latitude").value
let longitude = document.getElementById("longitude").value

var map = L.map('map').setView([latitude, longitude], 13);
const attribution = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';
const tileUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileUrl, {attribution})
tiles.addTo(map);


let myPosition;
let markerLayer = L.layerGroup().addTo(map);
let selectedUniversity = L.marker([latitude, longitude]).addTo(markerLayer);



function geolocation() {
    document.getElementById("search").disabled = false;
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(markPosition);
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function markPosition(position) {
    myPosition = L.marker([position.coords.latitude, position.coords.longitude]).addTo(map)
}

function search(){
    let profile = document.getElementById("profile").value;
    if(selectedUniversity!==undefined)
    {
        getMapInfo(profile, myPosition, selectedUniversity);
    }
}

async function getMapInfo(profile, start, end){
    const url = "https://api.openrouteservice.org/v2/directions/"+profile+"?api_key=5b3ce3597851110001cf6248995993511b5947b081e0eedbc69cb402&start="+start.getLatLng().lng+","+start.getLatLng().lat+"&end="+end.getLatLng().lng+","+end.getLatLng().lat;
    let info = await fetch(url);
    let data = await info.json();
    let points = data.features[0].geometry.coordinates.map(x=>x.reverse());
    if(profile==="foot-walking") L.polyline(points, { color: '#6f0b77', opacity: 1, weight: 5 }).addTo(markerLayer);
    if(profile==="driving-car") L.polyline(points, { color: '#b41238', opacity: 1, weight: 5 }).addTo(markerLayer);
    if(profile==="cycling-regular") L.polyline(points, { color: '#1222c7', opacity: 1, weight: 5 }).addTo(markerLayer);
    if(profile==="wheelchair") L.polyline(points, { color: '#ffb600', opacity: 1, weight: 5 }).addTo(markerLayer);

    let distance = data.features[0].properties.summary.distance;
    let duration = data.features[0].properties.summary.duration;
    document.getElementById("distance").innerHTML = "Растојанието од вас до универзитетот изнесува " + (distance/1000).toFixed(1) + " километри."
    document.getElementById("duration").innerHTML = "Времето за да стигнете до избраниот универзитет изнесува " + (duration/60).toFixed(0) + " минути."
    document.getElementById("information").hidden = false;
}