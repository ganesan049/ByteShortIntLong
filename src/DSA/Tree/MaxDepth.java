package DSA.Tree;

import java.util.*;

public class MaxDepth {
    static Node root;
    public static void main(String[] args) {
        MaxDepth tree = new MaxDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(22);
        MaxDepth tree2 = new MaxDepth();
        tree2.root = new Node(1);
        tree2.root.right = new Node(3);
        boolean res = isSameTree(tree.root,tree2.root);
        System.out.println(res);
//        tree.BFS(tree.root);
//        System.out.println("Height of tree is : " +
//                tree.calcDepth(tree.root));
    }

    private static boolean isSameTree(Node node1, Node node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null || node1.data != node2.data){
            return false;
        }
        return isSameTree(node1.left,node2.left) && isSameTree(node1.right,node2.right);
    }

    private static int calcDepth(Node root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(calcDepth(root.left),calcDepth(root.right));
    }
    private static int BFS(Node root){
        if(root == null){
            return -1;
        }
        Deque<Node> d = new ArrayDeque<Node>(){{add(root);}};
        for(Node n: d){
            System.out.println(n);
        }
        return 0;
    }
}


class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
