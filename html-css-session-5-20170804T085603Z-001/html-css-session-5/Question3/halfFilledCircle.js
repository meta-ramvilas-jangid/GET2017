var c = document.getElementById("myCanvas2");
var ctx = c.getContext("2d");
ctx.fillStyle = "#3333CC";
ctx.beginPath();
ctx.arc(100, 100, 80, 0.5 * Math.PI, 1.5 * Math.PI);
ctx.fill();
ctx.closePath();
ctx.beginPath();
ctx.fillStyle = "#C0C0C0"
ctx.arc(100, 100, 80, 0.5 * Math.PI, 1.5 * Math.PI,true);
ctx.fill();
ctx.closePath();
ctx.beginPath();
ctx.fillStyle = "white"
ctx.arc(100, 100, 60, 0.5 * Math.PI, 1.5 * Math.PI,true);
ctx.fill();
ctx.closePath();
