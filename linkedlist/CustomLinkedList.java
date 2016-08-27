//javac -d . CustomLinkedList.java Node.java && java linkedlist.CustomLinkedList
package linkedlist;


import java.util.*;


public class CustomLinkedList {
  Node head = null;
  int count = 0;


  public CustomLinkedList(Node head){
    this.head = head;
    this.count++;
  }

  private Node getIthNode(Node start, int position){
    for (long i = 0; i < position; i++){
      start = start.getNextNode();
    }
    return start;
  }
  //add
  public void add(Node newNode, int position){
      if (position > this.count) {
        position = this.count;
      }
      Node prevNode = this.getIthNode(this.head, position - 1);
      newNode.setNextNode(prevNode.getNextNode());
      prevNode.setNextNode(newNode);
      this.count++;
  }
  //get
  public Node get(int position){
    return this.getIthNode(this.head, position);
  }
  //size
  public int size(){
    return this.count - 1;
  }
  //isEmpty
  public boolean isEmpty(){
    if (this.count == 0){
      return true;
    } else {
      return false;
    }
  }
  //remove
  public void remove(int position){
    Node prevNode = this.getIthNode(this.head, position - 1);
    prevNode.setNextNode(prevNode.getNextNode().getNextNode());
  }

  public void printList() {
    Node temp = head;
    while (temp != null){
      System.out.println(temp.getData());
      temp = temp.getNextNode();
    }

  }
  
  public boolean hasLoop(){
    //collection to store seen nodes
    ArrayList<Node> seen = new ArrayList<>();
    Node temp = head;
    while(temp != null){
      seen.add(temp);
      if (seen.contains(temp.getNextNode()))
        return true;
      temp = temp.getNextNode();
    }
    
    return false;
  }

  public static void main(String[] args){
    
    Node<Integer> head = new Node<>(10);
    CustomLinkedList linkedList = new CustomLinkedList(head);
    for (int i = 2; i <= 10; i++){
          linkedList.add(new Node<>(i * 10), i);      
    }
    linkedList.printList();
    linkedList.remove(5);
    System.out.println("Removed 5th Node");
    linkedList.printList();
    Node<Integer> nodeReplacement = new Node<>(-5);
    System.out.println("Add 5th Node");
    linkedList.add(nodeReplacement, 5);
    linkedList.printList();
    System.out.println("Size of linked list: " + Integer.toString(linkedList.size()));

    //Sample Interview Question 1
    System.out.println("Has loop: " + Boolean.toString(linkedList.hasLoop()));
    nodeReplacement.setNextNode(linkedList.get(7));
    linkedList.add(nodeReplacement, 5);
    System.out.println("Has loop: " + Boolean.toString(linkedList.hasLoop()));
    
  }

}
