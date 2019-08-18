package com.guoge.ch1_LinkerList.ch1.No1_LinkedList_Reverse;

import com.guoge.ch1_LinkerList.ch1.LNode;

//带头结点的链表逆置
public class Test {
    public static void Reverse(LNode head){
        if(head==null||head.next==null){
            return;
        }
        LNode pre = null;
        LNode cur = null;
        LNode next = null;

        //链表逆置第一步是当前结点是 头结点后的第一个结点
        cur = head.next;
        next = cur.next;
        cur.next = null;

        //孤立头结点 现在cur head都被孤立了，然后第三个结点开始循环，指向前面的一个结点
        head.next = null;

        pre = cur;
        cur = next;
        while (cur.next!=null){
            next = cur.next;
            cur.next = pre;
            //后移
            pre = cur;
            cur = next;
        }
        //到最后了cur.next=null
        cur.next = pre;
        //前面孤立的结点现在指向cur
        head.next = cur;
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        head.next=null;
        LNode cur = head;
        LNode temp = null;
        for (int i = 1;i<=7;i++){
            temp = new LNode();
            temp.data=i;
            temp.next=null;
            cur.next = temp;
            cur = temp;
        }
        System.out.println("逆序前");
        for(cur = head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data);
        }

        Reverse(head);
        System.out.println("  ");
        System.out.println("逆序后");
        for(cur = head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data);
        }

    }
}
