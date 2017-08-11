function fun(){
	var str=document.getElementById("string").value;
	var ans=document.getElementById("ans");
    ans.innerHTML=str;
	var index=0;
	var j=0;
	var len=str.length;
	while(index<str.length-1){
	  var s="";
	  var count=index; 
	  while(str.charAt(index)==str.charAt(index+1)){
	        index++;
	  }
	  if(count!=index){
	     for(var i=count;i<=index;i++) {	
	     	s=s+str.charAt(i);
	     }
		str=str.replace(s,"");
	  	document.getElementById("ans").innerHTML +=" -> " +str;
	  	
	  	index=0;
	    continue;
	  }else{    
	   	   index++;
	  }
	    
	}
}