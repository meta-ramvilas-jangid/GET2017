function getContact(){
			document.getElementById("contact").href="contact.html";

		}
		function getIndex(){
			document.getElementById("index").href="index.html";

		}


		function nameValidation(){

			var x=document.getElementById("name");
             //x.value = x.value.toUpperCase();

              var letters = /^[A-Za-z ]+$/;
   				if(!x.value.match(letters))
     			{
      			    var msg=document.getElementById("msg");
                  msg.innerHTML="only char allow";
                  //msg.innerHTML.style.borderColor = "red";
                //
            
     			}

             else if(x.value==null||x.value==""){
               var msg=document.getElementById("msg");
               msg.innerHTML="name can't be blank";
            

             }
             else if(x.value.length>20 ||x.value.length<4){

              var msg=document.getElementById("msg");
               msg.innerHTML="invalid length";
               
             }else{
             	var msg=document.getElementById("msg");
               msg.innerHTML="correct Name";
             }
			
		}

		function emailValidation()  { 
			
            var x=document.getElementById("email");  
			var atposition=x.value.indexOf("@");  
			var dotposition=x.value.lastIndexOf(".");  
			
			if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.value.length){  
		     var emailMsg=document.getElementById("emailMsg");
               emailMsg.innerHTML="invalid email";
         	  
		  }  else{
		 var emailMsg=document.getElementById("emailMsg");
               emailMsg.innerHTML="valid email";
          	
		  }
		}



		function orgValidation()  { 
			
            var x=document.getElementById("org");
             //x.value = x.value.toUpperCase();

              var letters = /^[A-Za-z ]+$/;
   				if(!x.value.match(letters))
     			{
      			    var msg=document.getElementById("orgMsg");
                  msg.innerHTML="only char allow";
                  //msg.innerHTML.style.borderColor = "red";
                //
     			}
     			else{
     			  var msg=document.getElementById("orgMsg");
                  msg.innerHTML="";
                	
     			}
		}


		function mobValidation()  { 
			
            var x=document.getElementById("mob");
             //x.value = x.value.toUpperCase();

              var num = /^[0-9]+$/;
   				if(!x.value.match(num))
     			{
                	 var msg=document.getElementById("mobMsg");
                  	 msg.innerHTML="only num allow";
                 	
     			}else if(x.value.length>14||x.value.length<6){
					 var msg=document.getElementById("mobMsg");
                  	 msg.innerHTML="6-14 digit!";
                	               
     			}
     			else{
     				var msg=document.getElementById("mobMsg");
                  	 msg.innerHTML="";

     			}
		}

		function messageValidation()  { 
			
            var x=document.getElementById("message");
             //x.value = x.value.toUpperCase();

              if(x.value.length>250){
					 var msg=document.getElementById("messageMsg");
                  	 msg.innerHTML="max 250 char allowed";
                	               
     			}
     			else{
     				var msg=document.getElementById("messageMsg");
                  	 msg.innerHTML="";

     			}
		}
		function chooseCity(){
			var city = document.getElementById("city");
			var msg = document.getElementById("selectedMsg");
			var x = document.getElementsByClassName("cityMsg");

			var iterator;
			for(iterator =0; iterator < x.length; iterator++)
			{
				x[iterator].style.visibility = "visible";
			}
			selectedMsg.value = city.value;
			return true;
		}