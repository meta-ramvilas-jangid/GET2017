// alert('hello');
var sl= new DoublyList();
function Node(value) {
    this.data = value;
    this.previous = null;
    this.next = null;
}
 
function DoublyList() {
    this._length = 0;
    this.head = null;
    this.tail = null;
}
 function add(){
   sl.add();
}
function display(){
   document.getElementById("spanPrint").innerHTML="";
   document.getElementById("spanPrint").innerHTML+=null+"<-->";
   sl.display();
}
DoublyList.prototype.add = function() {
   var value = document.getElementById('nodeField').value.trim();
    var node = new Node(value);
 
    if (this._length) {
        this.tail.next = node;
        node.previous = this.tail;
        this.tail = node;
    } else {
        this.head = node;
        this.tail = node;
    }
 
    this._length++;
 document.getElementById('nodeField').value = "";
    return node;
};



DoublyList.prototype.display = function(){
   alert("length of Singly Linked List  "+this._length);
   currentNode = this.head;
   while (currentNode) {
        document.getElementById("spanPrint").innerHTML+=currentNode.data+"<-->";
       //document.write(currentNode.data+"-->");
     currentNode = currentNode.next;
     
    }
    document.getElementById("spanPrint").innerHTML+=null;
    
};