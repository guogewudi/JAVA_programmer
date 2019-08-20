package com.guoge.ch2_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class No10_equalroad {
    public static void FindRoad(BiTNode root, int num, int sum, ArrayList<Integer> list){
               sum = sum+root.data;
               list.add(root.data);

               if(root.lchild==null&&root.rchild==null&&sum==num){
                   for (int i = 0;i<list.size();i++){
                       System.out.println(list.get(i));
                   }
               }
               if (root.lchild!=null) {
                   FindRoad(root.lchild, num, sum, list);
               }
               if (root.rchild!=null) {
                   FindRoad(root.rchild, num, sum, list);
               }

               sum = sum - list.get(list.size()-1);
               list.remove(list.size()-1);

    }

    public  static BiTNode constructTree(){
        BiTNode root= new BiTNode();
        root.data = 6;
        BiTNode node1= new BiTNode();
        BiTNode node2= new BiTNode();
        BiTNode node3= new BiTNode();
        BiTNode node4= new BiTNode();
        root.lchild=node1;
        root.rchild = node2;
        node1.data = 3;
        node2.data =-7;
        node1.lchild = node3;
        node3.data = -1;
        node1.rchild = node4;
        node4.data = 9;
        node2.rchild = node2.lchild= node3.rchild = node3.lchild= node4.rchild = node4.lchild=null;
        return root;
        }

    public static void main(String[] args) {

        ArrayList<Integer>list = new ArrayList<Integer>();

        BiTNode root = constructTree();
        FindRoad(root,8,0,list);

    }
}
