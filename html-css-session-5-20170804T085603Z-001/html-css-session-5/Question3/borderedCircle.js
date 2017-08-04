var c = document.getElementById("myCanvas3");
var ctx = c.getContext("2d");
ctx.fillStyle = "#3333CC";
ctx.beginPath();
ctx.arc(100, 100, 80, 0* Math.PI, 2 * Math.PI);
ctx.fill();
ctx.closePath();
ctx.beginPath();
ctx.fillStyle = "white"
ctx.arc(100, 100, 60, 0 * Math.PI, 2 * Math.PI);
ctx.fill();
ctx.closePath();