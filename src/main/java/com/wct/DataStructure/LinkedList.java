package com.wct.DataStructure;

public class LinkedList {
    Node head;
    int size;

    public void add(int data) throws Exception {
        insert(size,data);
    }

    public void insert(int index, int data) throws Exception {
        if(index<0 || index>size){
            throw new Exception("index输入不正确");
        }
        Node current = head;
        Node newNode = new Node(data);
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }else{
            for(int i=0; i<index-1; i++){   //找到要插入位置的前一个节点
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void delete(int index) throws Exception {
        if(index<0 || index>=size){
            throw new Exception("index不正确");
        }
        if(index == 0){
            head = head.next;
        }else {
            Node current = head;
            for(int i=0; i<index-1; i++){   //找到删除节点的前一个节点
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void print(){
        Node current = head;
        System.out.print("[");
        while (current != null){
            System.out.print(current.val);
            if((current=current.next) != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        list.insert(6,7);
        list.print();
        list.insert(0,0);
        list.print();
        list.insert(2,99);
        list.print();
        list.delete(0);
        list.print();
        list.delete(5);
        list.print();
        list.delete(6);
        list.print();
    }

}

class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
