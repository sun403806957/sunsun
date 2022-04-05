package com.mysqltest.collection;

public class MyLinkList {

        MyNode fri = null;
        MyNode last = null;
        int count = 0;

    public MyLinkList() {
    }
    public void add(Object o){
        if (fri == null){
            MyNode myNode = new MyNode();
            myNode.setNext(null) ;
            myNode.setNode(o);
            myNode.setPre(null);
            fri = myNode;
            last = myNode;
        }
        else{
            MyNode myNode = new MyNode();
            myNode.setPre(last);
            myNode.setNode(o);
            myNode.setNext(null);
            last.setNext(myNode);
            last = myNode;
        }
        count ++;
    }
    public MyNode get(int index){
        MyNode n = fri;
        for (int i = 0;i <index;i++){
            n = n.getNext();
        }
        return n;
    }
}
class test{
    public static void main(String[] args) {
        MyLinkList myLinkListtest = new MyLinkList();
        myLinkListtest.add("12");
        myLinkListtest.add("13");
        System.out.println(myLinkListtest.count);
    }
}