package com.mysqltest.collection;

public class MyNode {
    private MyNode next ;
    private MyNode pre;
    private Object node;

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getPre() {
        return pre;
    }

    public void setPre(MyNode pre) {
        this.pre = pre;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "next=" + next +
                ", pre=" + pre +
                ", node=" + node +
                '}';
    }
}
