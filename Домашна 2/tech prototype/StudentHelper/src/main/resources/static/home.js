
//json.features[0].properties.segments[0].distance
//json.features[0].properties.segments[0].duration
//json.features[0].properties.segments[0].steps


function keyword(){}

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



var map = L.map('map').setView([41.994626, 21.430379], 13);
const attribution = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';
const tileUrl = 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
const tiles = L.tileLayer(tileUrl, {attribution})
tiles.addTo(map);

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
    const polyline = L.polyline(points).addTo(map);
}


// var user = L.marker();
// map.on('click', onMapClick);
// function onMapClick(e) {
//     user.setLatLng(e.latlng).addTo(map);
// }




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
let selectedUniversity;
let myPosition;

async function loadUniversities(){
    const url = "/universities/all";
    let items = await fetch(url);
    let parsed = await items.json();

    for(let item of parsed){
        let marker = L.marker([item.latitude, item.longitude], {icon: uniicon}).addTo(map).bindPopup("<h3>"+item.name+"</h3><br><a href=/home/" + item.id + ">Click here for detailed view</a>");
        marker.on('click', () => {
            selectedUniversity = marker;
        });
    }

}
loadUniversities();

