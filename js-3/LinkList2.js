var singlylist = new SinglyLinkList();

function Node(data){
	this.data = data;
	document.getElementById("add").value = "";
	this.next=null;
}

 function SinglyLinkList(){
	 this.head=null;
	 this.next=null;
	 this.size=0;
	 var temp,data;

this.addToList= function(){
	var data =document.getElementById("add").value;
		var node = new Node(data);
		if(this.head == null){
		this.head=node;
		this.size+=1;
		document.getElementById("spanAdd").innerHTML = "Element added successfully";
		}
		else
		{
			this.temp=this.head;
			while(this.temp.next!=null)
			{
				this.temp=this.temp.next;
			}
			this.temp.next=node; 
			this.size+=1;
			document.getElementById("spanAdd").innerHTML = "Element added successfully";
		}

	
}



this.printList=function(){
	this.temp=this.head;
	document.getElementById("spanList").innerHTML="";
	if(!this.temp){
		document.getElementById("spanList").innerHTML ="List is empty"
	}
	else{
		while(this.temp!=null)
		{
			document.getElementById("spanList").innerHTML += this.temp.data + " ";
			this.temp = this.temp.next;
		}
	}
}


this.searchPosFromList = function(){
	this.temp=this.head;
	
	var val = document.getElementById("searchPos").value;
	document.getElementById("searchPos").value="";
	var count=1,flag=true;
			while(count<=this.size){
				if(count==val){
					document.getElementById("spanSearchPos").innerHTML = this.temp.data;
					flag=false;
					break;
				}
				count++;
				this.temp=this.temp.next;
			}
			if(flag){
					document.getElementById("spanSearchPos").innerHTML = "No element exist at this position";
			}

}

this.deletePosFromList = function(){
	this.temp=this.head;
	var val = document.getElementById("deletePos").value;
	document.getElementById("deletePos").value="";
	var count=1,flag=true;
		
			while(count<=this.size){
				if(count==val){
					document.getElementById("spanDeletePos").innerHTML = "Element is deleted from the list";
					if(val ==1){
						this.head=this.head.next;
					}
					else{
						for(var index = 1;index<val-1;index++){
							this.temp=this.temp.next;
						}
						if(!this.temp.next.next){
							this.temp.next = null;
						}
						else{
							this.temp.next = this.temp.next.next;
						}
					}
					this.size-=1;
					flag=false;
					break;
				}
				count++;
			}
			if(flag){
					document.getElementById("spanDeletePos").innerHTML = "No element exist at this position";
			}

}
}

function addVal(){
	singlylist.addToList();
}

function deleteVal(){
	singlylist.deleteFromList();
}

function printVal(){
	singlylist.printList();
}

function searchPos(){
	singlylist.searchPosFromList();
}

function deletePos(){
	singlylist.deletePosFromList();
}