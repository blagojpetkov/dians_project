
//json.features[0].properties.segments[0].distance
//json.features[0].properties.segments[0].duration
//json.features[0].properties.segments[0].steps


const items = [
    {
        id: 390431519,
        latitude: 41.1078977,
        longitude: 20.8087351,
        name: 'Факултет за туризам и угостителство',
        type: 'university',
    },
    {
        id: 1867248510,
        latitude: 41.9973091,
        longitude: 21.4351329,
        name: 'Факултет за музичка уметност',
        type: 'university',
    },
    {
        id: 3098482742,
        latitude: 41.5109634,
        longitude: 20.9595002,
        name: 'Правен Факултет Св. Климент Охридски',
        type: 'university',
    },
    {
        id: 3189871864,
        latitude: 41.6373260,
        longitude: 22.4618690,
        name: 'Електротехнички факултет',
        type: 'university',
    },
    {
        id: 3832632320,
        latitude: 41.9898623,
        longitude: 21.4246243,
        name: 'Медицински Факултет',
        type: 'university',
    },
    {
        id: 6054050089,
        latitude: 42.0017934,
        longitude: 21.4348281,
        name: 'Меѓународен балкански универзитет',
        type: 'university',
    },
    {
        id: 7781686838,
        latitude: 41.5108839,
        longitude: 20.9596189,
        name: 'Технолошко-техничкиот факултет - Нутриционизам',
        type: 'university',
    },
    {
        id: 1000000016669251,
        latitude: 42.0001211,
        longitude: 21.4429258,
        name: 'Универзитет „Св. Кирил и Методиј“',
        type: 'university',
    },
    {
        id: 1000000028214330,
        latitude: 42.0048024,
        longitude: 21.4060363,
        name: 'Факултет за драмски уметности',
        type: 'university',
    },
    {
        id: 1000000032657855,
        latitude: 42.0020499,
        longitude: 21.3362188,
        name: 'Универзитет „Њујорк“',
        type: 'university',
    },
    {
        id: 1000000032688305,
        latitude: 42.0001276,
        longitude: 21.4055326,
        name: 'Педагошка Академија',
        type: 'university',
    },
    {
        id: 1000000035829281,
        latitude: 42.0048012,
        longitude: 21.4083577,
        name: 'Техничко-технолошки кампус',
        type: 'university',
    },
    {
        id: 1000000037626725,
        latitude: 42.0056465,
        longitude: 21.4066339,
        name: 'Машински Факултет',
        type: 'university',
    },
    {
        id: 1000000037996998,
        latitude: 42.0020503,
        longitude: 21.4592269,
        name: 'Шумарски факултет',
        type: 'university',
    },
    {
        id: 1000000038081117,
        latitude: 41.9887436,
        longitude: 21.4374427,
        name: 'Економски институт - Скопје',
        type: 'university',
    },
    {
        id: 1000000043444610,
        latitude: 41.9812276,
        longitude: 21.4546477,
        name: 'Универзитет Американ Колеџ Скопје',
        type: 'university',
    },
    {
        id: 1000000044040587,
        latitude: 41.9791577,
        longitude: 21.4259383,
        name: 'Институт за земјотресно инженерство и инженерска сеизмологија - ИЗИИС',
        type: 'university',
    },
    {
        id: 1000000059339418,
        latitude: 42.0016016,
        longitude: 21.4518169,
        name: 'Природно Математички Факултет',
        type: 'university',
    },
    {
        id: 1000000087338471,
        latitude: 41.9869840,
        longitude: 20.9626467,
        name: 'Универзитет на Југоисточна Европа',
        type: 'university',
    },
    {
        id: 1000000163003846,
        latitude: 41.9885200,
        longitude: 21.4250843,
        name: 'Фармацевтски Факултет',
        type: 'university',
    },
    {
        id: 1000000163027019,
        latitude: 41.9999512,
        longitude: 21.4181017,
        name: 'Архитектонски Факултет',
        type: 'university',
    },
    {
        id: 1000000175094125,
        latitude: 42.0022287,
        longitude: 21.4583354,
        name: 'Факултет за земјоделски науки и храна',
        type: 'university',
    },
    {
        id: 1000000176176612,
        latitude: 41.9930174,
        longitude: 21.4098921,
        name: 'Православен Богословски факултет - Свети Климент Охридски',
        type: 'university',
    },
    {
        id: 1000000177017257,
        latitude: 42.0001345,
        longitude: 21.4186806,
        name: 'Градежен факултет',
        type: 'university',
    },
    {
        id: 1000000179091097,
        latitude: 41.9929199,
        longitude: 21.4740172,
        name: 'ФОН Универзитет',
        type: 'university',
    },
    {
        id: 1000000182436642,
        latitude: 42.0313019,
        longitude: 21.4530707,
        name: 'Институт за лозарство и винарство',
        type: 'university',
    },
    {
        id: 1000000194613382,
        latitude: 41.1017070,
        longitude: 20.8148319,
        name: 'Хидробиолошки Институт',
        type: 'university',
    },
    {
        id: 1000000234411277,
        latitude: 41.9571005,
        longitude: 21.5575977,
        name: 'Факултет за безбедност',
        type: 'university',
    },
    {
        id: 1000000235779165,
        latitude: 41.1133075,
        longitude: 20.8025818,
        name: 'Универзитет за Инфоматички Науки и Технологии „Св. Апостол Павле“',
        type: 'university',
    },
    {
        id: 1000000406048965,
        latitude: 41.3693879,
        longitude: 21.5145619,
        name: 'Научен институт за тутун - Прилеп',
        type: 'university',
    },
    {
        id: 1000000444884442,
        latitude: 41.7367383,
        longitude: 22.2034127,
        name: 'Кампус 4',
        type: 'university',
    },
    {
        id: 1000000445153499,
        latitude: 41.7338389,
        longitude: 22.1991075,
        name: 'Факултет за Медицински Науки - Деканат',
        type: 'university',
    },
    {
        id: 1000000445970187,
        latitude: 41.7465031,
        longitude: 22.1835390,
        name: 'Кампус 2',
        type: 'university',
    },
    {
        id: 1000000446067014,
        latitude: 41.7598777,
        longitude: 22.1659847,
        name: 'Кампус 4',
        type: 'university',
    },
    {
        id: 1000000446112058,
        latitude: 41.7369521,
        longitude: 22.1911505,
        name: 'Кампус 1',
        type: 'university',
    },
    {
        id: 1000000459340458,
        latitude: 42.0025342,
        longitude: 21.4579685,
        name: 'Факултет за дизајн и технологии на мебел и ентериер',
        type: 'university',
    },
    {
        id: 1000000459340459,
        latitude: 42.0024672,
        longitude: 21.4591177,
        name: 'Лабораторија за тестирање мебел - ФДТМЕ',
        type: 'university',
    },
    {
        id: 1000000572339618,
        latitude: 41.9931370,
        longitude: 20.9623640,
        name: 'Државен Универзитет Тетово',
        type: 'university',
    },
    {
        id: 1000000588687226,
        latitude: 42.0087773,
        longitude: 21.4130242,
        name: 'Институт за Сточарство',
        type: 'university',
    },
    {
        id: 1000000678119479,
        latitude: 41.7362137,
        longitude: 22.1822087,
        name: 'Ректорат',
        type: 'university',
    },
    {
        id: 1000000678121136,
        latitude: 41.7364225,
        longitude: 22.1947887,
        name: 'Кампус 3',
        type: 'university',
    },
    {
        id: 1000000810051427,
        latitude: 41.3539070,
        longitude: 21.5409813,
        name: 'Економски факултет - Прилеп',
        type: 'university',
    },
    {
        id: 1000000919665113,
        latitude: 41.0221417,
        longitude: 21.3310960,
        name: 'Правен Факултет - Кичево',
        type: 'university',
    },
    {
        id: 1000000925913817,
        latitude: 41.0231553,
        longitude: 21.3261335,
        name: 'Факултет за биотехнички науки - Битола',
        type: 'university',
    },
    {
        id: 1000000989817719,
        latitude: 41.9991337,
        longitude: 21.4353055,
        name: 'South East European University',
        type: 'university',
    },
    {
        id: 1000000990060751,
        latitude: 41.0209050,
        longitude: 21.3413451,
        name: 'Технички факултет - Битола',
        type: 'university',
    },
    {
        id: 1000000991661503,
        latitude: 41.0221474,
        longitude: 21.3256333,
        name: 'Факултет за информатички и комуникациски технологии - Битола',
        type: 'university',
    },
    {
        id: 1000000991662298,
        latitude: 41.0230063,
        longitude: 21.3189164,
        name: 'Висока медицинска школа - Битола',
        type: 'university',
    },
    {
        id: 1000000991666686,
        latitude: 41.0322459,
        longitude: 21.3148170,
        name: 'Педагошки факултет - Битола',
        type: 'university',
    },
    {
        id: 2000000005360061,
        latitude: 42.0016700,
        longitude: 21.4377751,
        name: 'Сули-ан - Факултет за ликовна уметност',
        type: 'university',
    },
]

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


for(let item of items){
    let marker = L.marker([item.latitude, item.longitude], {icon: uniicon}).addTo(map).bindPopup("<h3>"+item.name+"</h3><br><a href=/home/" + item.id + ">Click here for detailed view</a>");
    marker.on('click', () => {
        selectedUniversity = marker;
    });
}
