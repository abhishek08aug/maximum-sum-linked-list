package in.blogspot.randomcompiler.maximum.sum.linked.list.impl;

public class Node {
    private int data;
    private Node next;

    public Node getNext() {
        return next;
    }
    
    public void setNext(Node node) {
        this.next = node;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + "]";
    }
    
}
