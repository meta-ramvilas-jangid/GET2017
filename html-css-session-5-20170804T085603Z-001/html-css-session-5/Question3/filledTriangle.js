
	var c = document.getElementById("myCanvas4");
	var ctx = c.getContext("2d");
	ctx.fillStyle = "purple";
    ctx.moveTo(0, 0); // start at top left corner of canvas
    ctx.lineTo(200, 0); // go 200px to right (x), straight line from 0 to 0
    ctx.lineTo(100, 200); // go to horizontal 100 (x) and vertical 200 (y)
    ctx.fill(); // connect and fill