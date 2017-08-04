var x = document.getElementById("paragraph");
	function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition,showError);
    } else {
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
	}
		function showPosition(position){
			x.innerHTML = "Latitude: " + position.coords.latitude +
    			"<br>Longitude: " + position.coords.longitude;
			var latlon = position.coords.latitude + "," +position.coords.longitude;
			var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="+latlon+"&zoom=14&size=1600x900&sensor = false";
			document.getElementById('mapholder').innerHTML = "</br><img src="+img_url+">";

		}
		function showError(error){
			switch(error.code){
				case error.PERMISSION_DENIED:x.innerHTML = "User Denied the request"; break;
				case error.POSITION_UNAVAILABLE:x.innerHTML = "Location Unavailable";break;
				case error.TIMEOUT:x.innerHTML = "Request Timeout"; break;
				case error.UNKNOWN_ERROR:x.innerHTML = "unknown error in loading maps";break;
			}
		}