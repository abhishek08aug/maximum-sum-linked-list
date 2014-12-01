package in.blogspot.randomcompiler.maximum.sum.linked.list.demo;

import in.blogspot.randomcompiler.maximum.sum.linked.list.impl.List;

public class MaximumSumDemo {

    public static void main(String[] args) {
        List list1 = new List();
        list1.add(1);
        list1.add(3);
        list1.add(30);
        list1.add(90);
        list1.add(120);
        list1.add(240);
        list1.add(511);
        
        List list2 = new List();
        list2.add(1);
        list2.add(3);
        list2.add(12);
        list2.add(32);
        list2.add(90);
        list2.add(125);
        list2.add(240);
        list2.add(249);
        
        List maxSumList1 = List.getMaximumSumList(list1, list2);
        maxSumList1.print();
        
        System.out.println();
        
        List list3 = new List();
        list3.add(10);
        list3.add(20);
        list3.add(30);
        list3.add(40);
        list3.add(50);
        list3.add(60);
        list3.add(70);
        
        List list4 = new List();
        list4.add(10);
        list4.add(500);
        
        List maxSumList2 = List.getMaximumSumList(list3, list4);
        maxSumList2.print();
    }

}
