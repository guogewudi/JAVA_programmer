package com.guoge.ch1_LinkerList.ch1.No2_Remove_DuplicateElements;

import com.guoge.ch1_LinkerList.ch1.LNode;
//删除链表之中重复的元素
public class TestNo2 {
    public static void removeDuplicatedElements(LNode head){
        if(head==null||head.next==null){
            return;
        }

        LNode outCur = head.next;
        LNode innerPre = null;
        LNode innerCur = null;

        for(outCur = head.next;outCur!=null;outCur = outCur.next){
            for (innerCur = outCur.next,innerPre = outCur;innerCur!=null;){

                if (innerCur.data==outCur.data){
                    innerPre.next = innerCur.next;
                    innerCur=innerCur.next;
                }else {
                    innerPre = innerCur;
                    innerCur = innerCur.next;
                }

            }
        }
    }

    public static void main(String[] args) {
        LNode head = new LNode();
        head.next=null;
        LNode cur = head;
        LNode temp = null;
        for (int i = 1;i<20;i++){
            temp = new LNode();
            if(i%2==0){
                temp.data=i+1;
            }else if (i%3==0){
                temp.data = i -2;
            }else {
                temp.data = i;
            }

            temp.next=null;
            cur.next = temp;
            cur = temp;
        }
        System.out.println("删除结点前");
        for(cur = head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }
        System.out.println(" ");
        System.out.println("删除结点后");
        removeDuplicatedElements(head);

        for(cur = head.next;cur!=null;cur=cur.next){
            System.out.print(cur.data+" ");
        }

    }

}
