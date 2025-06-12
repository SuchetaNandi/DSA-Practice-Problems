package Trees;

import java.util.*;
public class LeftView {
    private class Node{
        int val;
        Node left, right;

        Node(){}
        Node(int val){
            this.val= val;
        }
        Node(int val, Node left, Node right){
            this.val= val;
            this.left= left;
            this.right= right;
        }
    }

    public static ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> res= new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> q= new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int lvlSize= q.size();
            for(int i=0; i< lvlSize;i++){
                Node curr= q.poll();
                if(i==0){
                    res.add(curr.val);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!= null){
                    q.offer(curr.right);
                }
            }
        }

        return res;
    }
}
