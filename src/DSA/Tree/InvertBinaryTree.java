package DSA.Tree;

import java.util.function.Function;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
//        tree.left.right = new TreeNode(-3);
//        tree.left.left = new TreeNode(-1);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);
//        tree=invertBinaryTree(tree);
//        print(tree);

        maxPathSum(tree);
    }
    private static void maxPathSum(TreeNode treeNode) {
        Res res = new Res();
        res.val =  treeNode.val;
        System.out.println(dfs(treeNode,res));
    }

    private static int dfs(TreeNode treeNode, Res res) {
        if(treeNode == null){
            return 0;
        }
        int leftMax = dfs(treeNode.left,res);
        int rightMax = dfs(treeNode.right,res);
        leftMax = Math.max(0,leftMax);
        rightMax = Math.max(0,rightMax);
        int max_single = Math.max(Math.max(leftMax,rightMax)+treeNode.val,treeNode.val);
        int max_top = Math.max(max_single,leftMax+rightMax+treeNode.val);
        res.val = Math.max(res.val,max_top);
        return max_single;
    }


    private static void print(TreeNode tree) {
        if(tree == null){
            return;
        }
        System.out.println(tree.val);
        print(tree.left);
        print(tree.right);
    }

    private static TreeNode invertBinaryTree(TreeNode tree) {
        if(tree == null){
            return null;
        }
        TreeNode tmp = tree.left;
        tree.left = tree.right;
        tree.right  = tmp;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        return tree;
    }
}

class Res{
    public int val;
}