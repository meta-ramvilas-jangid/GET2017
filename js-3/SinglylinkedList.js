// alert('hello');
function Node(data) {
   this.data = data;
   this.next = null;
}

function SinglyList() {
   this._length = 0;
   this.head = null;
}
var sl= new SinglyList();
function add(){
   sl.add();
}
function display(){
   document.getElementById("spanPrint").innerHTML="";
   sl.display();
}

SinglyList.prototype.add = function() {
   var value = document.getElementById('nodeField').value.trim();
   if(value==""){
       document.getElementById('errorMsg').innerHTML = "node value can't be empty";
       document.getElementById('nodeField').value = "";
       return ;
   }
   var node = new Node(value),
       currentNode = this.head;

   // 1st use-case: an empty list
   if (!currentNode) {
       this.head = node;
       this._length++;
       document.getElementById('nodeField').value = "";
       return node;

   }

   // 2nd use-case: a non-empty list
   while (currentNode.next) {
       currentNode = currentNode.next;
   }

   currentNode.next = node;

   this._length++;
   document.getElementById('nodeField').value = "";
    
   return node;
};
SinglyList.prototype.display = function(){
   alert("length of Singly Linked List  "+this._length);
   currentNode = this.head;
   while (currentNode) {
        document.getElementById("spanPrint").innerHTML+=currentNode.data+"-->";
       //document.write(currentNode.data+"-->");
     currentNode = currentNode.next;
     
    }
    document.getElementById("spanPrint").innerHTML+=null;
    
};



 function remove(){
   sl.remove();
}
SinglyList.prototype.remove = function() {
  
  var delposition=document.getElementById("delposition").value;
  
    var currentNode = this.head,
        length = this._length,
        count = 0,
       
        beforeNodeToDelete = null,
        nodeToDelete = null,
        deletedNode = null;
 alert(delposition);
    if (delposition < 0 || delposition > length) {
        document.getElementById("delpositionerror").innerHTML="invalid position";
        alert(delpositionerror);
    }
 
    if (delposition === 1) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this._length--;
         document.getElementById("delNode").innerHTML="deleted node"+deletedNode.data;
        return deletedNode;
    }
 
    while (count < delposition) {
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
        count++;
    }
 
    beforeNodeToDelete.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this._length--;
    document.getElementById("delNode").innerHTML="deleted node"+deletedNode.data;
    return deletedNode;
};