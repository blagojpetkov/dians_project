var map = L.map('map').setView([41.994626, 21.430379], 13);
const attribution = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';
const tileUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileUrl, {attribution})
tiles.addTo(map);

let selectedUniversity;
let myPosition;
let markerLayer = L.layerGroup().addTo(map);
async function loadUniversities(){
    const url = "/universities/all";
    let items = await fetch(url);
    let parsed = await items.json();

    for(let item of parsed){
        let marker = L.marker([item.latitude, item.longitude], {icon: uniicon}).addTo(markerLayer).bindPopup("<h3>"+item.name+"</h3><br><a style='width: 290px' class='btn btn-outline-dark' href=/home/" + item.id + ">Детален поглед</a>");
        marker.on('click', () => {
            selectedUniversity = marker;
        });
    }
}
loadUniversities();

//search by keyword
async function keyword(){
    let value = document.getElementById("keyword").value;
    if(value==="") return
    const url = "/universities/keyword/" + value;
    let items = await fetch(url);
    let parsed = await items.json();
    markerLayer.clearLayers();

    for(let item of parsed){
        let marker = L.marker([item.latitude, item.longitude], {icon: uniicon}).addTo(markerLayer).bindPopup("<h3>"+item.name+"</h3><br><a style='width: 290px' class='btn btn-outline-dark' href=/home/" + item.id + ">Детален поглед</a>");
        marker.on('click', () => {
            selectedUniversity = marker;
        });
    }
}

let open = false;
function hamburgerClick(){
    if(open) {
        document.getElementById("hamburger").classList.remove("rotate")
        document.getElementById("map").style.width = screen.width.toString();
        document.getElementById("map").style.margin = "20px"
        open = false;
        document.getElementById("sidebar").hidden = true;
    }
    else
    {
        document.getElementById("hamburger").classList.add("rotate")
        document.getElementById("map").style.width = (screen.width - 300).toString();
        document.getElementById("map").style.margin = "20px 20px 20px 320px"
        open = true;
        document.getElementById("sidebar").hidden = false;
    }
}


var uniicon = L.icon({
    iconUrl: 'icon.png',
    iconSize:     [38, 40],
    iconAnchor:   [19, 40],
    popupAnchor:  [0, -40]
});


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
    document.getElementById("instructions").hidden = true;
    document.getElementById("information").hidden = false;
    document.getElementById("distance").innerHTML = "Растојанието од вас до универзитетот изнесува " + (distance/1000).toFixed(1) + " километри."
    document.getElementById("duration").innerHTML = "Времето за да стигнете до избраниот универзитет изнесува " + (duration/60).toFixed(0) + " минути."

}




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

document.getElementById("keyword")
    .addEventListener("keyup", function(event) {
        event.preventDefault();
        if (event.key === "Enter") {
            document.getElementById("keywordbutton").click();
        }
    });