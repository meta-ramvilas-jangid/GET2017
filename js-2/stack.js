function Node(data){
	this.data = data;
	this.prev=null;
}

function MyStack(){
		this.top=null;
 }

MyStack.prototype.pushItem = function(){
		data = document.getElementById("push").value;
		document.getElementById("push").value = "";
		var node = new Node(data);
		node.prev = this.top;
		this.top=node;
	}	
	
	MyStack.prototype.popItem = function(){
		document.getElementById("spanPop").innerHTML = "";
		if(this.top){
			document.getElementById("spanPop").innerHTML = this.top.data;
			this.top=this.top.prev;
		}
		else{
			document.getElementById("spanPop").innerHTML = "Empty stack";
		}
	}
 
	MyStack.prototype.printStack = function(){
		temp = this.top;
		document.getElementById("spanStack").innerHTML="";
		while(temp!=null){
			document.getElementById("spanStack").innerHTML += temp.data + " ";
			temp=temp.prev;
		}
	}

var stack = new MyStack();
 
 function pushVal(){
	stack.pushItem();
 }
 
 function popVal(){
	stack.popItem();
 }
 
 function printVal(){
	stack.printStack();
 }