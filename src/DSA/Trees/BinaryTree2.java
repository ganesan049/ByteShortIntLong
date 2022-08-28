package DSA.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node2<T extends Comparable<?>>{
  public Integer value;
  public Node2 left;
  public Node2 right;
  public Node2(Integer value){
    this.value = value;
    left = null;
    right = null;
  }

  @Override
  public String toString() {
    return "Node2{" +
        "value=" + value +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}

class BinarySearchTree2{
  Node2 root;

  public BinarySearchTree2(){
    root = null;
  }

  public boolean removeNode(Integer value){
    Node2 currentNode = root;
    if(root == null){
      return false;
    }
    if(root.value == value){
      root = null;
      return true;
    }
    while(currentNode != null){
      if(currentNode.value > value){
        if(currentNode.left != null && currentNode.left.value == value){
          currentNode.left = helper(currentNode.left);
          return true;
        }
        currentNode = currentNode.left;
      }else if(currentNode.value < value){
        if(currentNode.right != null && currentNode.right.value == value){
          currentNode.right = helper(currentNode.right);
          return true;
        }
        currentNode = currentNode.right;
      }
    }
    return false;
  }

  private Node2 helper(Node2 node) {
    if(node.left == null){
      return node.right;
    }else if(node.right == null){
      return node.left;
    }else{
      Node2 rightChild = node.right;
      Node2 leftExtremeRight = findExtremeRight(node.left);
      leftExtremeRight.right = rightChild;
      return node.left;
    }
  }

  private Node2 findExtremeRight(Node2 node) {
    if(node.right == null){
      return node;
    }
    return findExtremeRight(node.right);
  }

  public boolean insertNode(Integer value){
    Node2 newNode = new Node2(value);
    Node2 currentNode = root;
    if(root == null){
      root = newNode;
      return true;
    }
    while(currentNode != null){
      if(currentNode.value > value){
        if(currentNode.left == null){
          currentNode.left = newNode;
          return true;
        }
        currentNode = currentNode.left;
      }else if(currentNode.value < value){
        if(currentNode.right == null){
          currentNode.right = newNode;
          return true;
        }
        currentNode = currentNode.right;
      }else{
        return false;
      }
    }
    return false;
  }
}
 public class BinaryTree2 {
   public static void main(String[] args) {
     BinarySearchTree2 bst = new BinarySearchTree2();
     bst.insertNode(4);
     bst.insertNode(6);
     bst.insertNode(20);
     bst.insertNode(170);
     bst.insertNode(15);
     bst.insertNode(1);
     bst.removeNode(20);
     System.out.println(bst.root);
   }
}
