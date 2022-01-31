
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
