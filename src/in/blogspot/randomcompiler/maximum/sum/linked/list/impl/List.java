package in.blogspot.randomcompiler.maximum.sum.linked.list.impl;

public class List {
    private Node head;

    public void add(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        
        if(head == null) {
            head = newNode;
        } else {
            Node last = head;
            while(last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
    }
    
    public void print() {
        Node temp = head;
        
        while(temp != null) {
            System.out.println(temp + " ");
            temp = temp.getNext();
        }
    }
    
    public static List getMaximumSumList(List a, List b) {
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }
        Node maxHead1 = getMaximumSumList(a.getHead(), b.getHead(), true);
        Node maxHead2 = getMaximumSumList(a.getHead(), b.getHead(), false);

        if(sum(maxHead1) > sum(maxHead2)) {
            List result = new List();
            result.setHead(maxHead1);
            return result;
        } else {
            List result = new List();
            result.setHead(maxHead2);
            return result;
        }        
    }
    
    private static Node getMaximumSumList(Node head1, Node head2, boolean which) {
        if(which) {
            if(head1 == null) {
                return head1;
            }
            Node first = new Node();
            first.setData(head1.getData());
            Node rest = null;
            
            Node second = head1.getNext();
            Node temp = head2;
            if(second != null) {
                while(temp != null && temp.getData() <= second.getData()) {
                    head2 = temp;
                    temp = temp.getNext();
                }
            }
            
            if(head2 == null) {
                rest = head1.getNext();
            } else if(head2 != null && head1.getData() == head2.getData()) {
                Node rest1 = getMaximumSumList(head1.getNext(), head2.getNext(), true);
                Node rest2 = getMaximumSumList(head1.getNext(), head2.getNext(), false);
                rest = sum(rest1) > sum(rest2) ? rest1 : rest2; 
            } else {
                rest = getMaximumSumList(head1.getNext(), head2, true);
            }
            first.setNext(rest);
            return first;
        } else {
            if(head2 == null) {
                return head2;
            }
            Node first = new Node();
            first.setData(head2.getData());
            Node rest = null;
            
            Node second = head2.getNext();
            Node temp = head1;
            if(second != null) {
                while(temp != null && temp.getData() <= second.getData()) {
                    head1 = temp;
                    temp = temp.getNext();
                }
            }
            
            if(head1 == null) {
                rest = head2.getNext();
            } else if(head1 != null && head1.getData() == head2.getData()) {
                Node rest1 = getMaximumSumList(head1.getNext(), head2.getNext(), true);
                Node rest2 = getMaximumSumList(head1.getNext(), head2.getNext(), false);
                rest = sum(rest1) > sum(rest2) ? rest1 : rest2; 
            } else {
                rest = getMaximumSumList(head1, head2.getNext(), false);
            }
            first.setNext(rest);
            return first;         
        }
    }

    private Node getHead() {
        return head;
    }
    
    private int sum() {
        return sum(head);
    }
    
    private static int sum(Node node) {
        Node current = node;
        int sum = 0;
        while(current != null) {
            sum += current.getData();
            current = current.getNext();
        }
        return sum;
    }
    
    private void setHead(Node head) {
        this.head = head;
    }
}
