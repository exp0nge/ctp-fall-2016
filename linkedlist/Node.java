package linkedlist;


public class Node<T> {
  private T data = null;
  private Node nextNode = null;

  public Node(T data) {
    this.data = data;
  }

  public Node(T data, Node nextNode) {
    this.data = data;
    this.nextNode = nextNode;
  }

  public T getData(){
    return this.data;
  }

  public void setData(T data){
    this.data = data;
  }

  public Node getNextNode(){
    return this.nextNode;
  }

  public void setNextNode(Node nextNode){
    this.nextNode = nextNode;
  }

}
