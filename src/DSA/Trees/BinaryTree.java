package DSA.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (T Integer : list) {
            if (Integer != null)
                return false;
        }

        return true;
    }

}

class Node<T extends Comparable<?>>{
    public Integer value;
    public Node left;
    public Node right;
    public Node(Integer value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinarySearchTree{
    Node root;
    public BinarySearchTree() {
        root = null;
    }
    public void insert(Integer value){
        Node newNode = new Node(value);
        if(this.root == null){
            root = newNode;
        }else{
            Node currentNode = root;
            while(true){
                if(value < currentNode.value){
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        break;
                    }
                    currentNode = currentNode.left;
                }else if(value > currentNode.value){
                    if(currentNode.right == null){
                        currentNode.right = newNode;
                        break;
                    }
                    currentNode = currentNode.right;
                }else{
                    System.out.println("Element already present.");
                    break;
                }
            }
        }
    }

    public boolean remove(Integer value) {
        Node currentNode = root;
        if (currentNode == null) {
            return false;
        }
        if (currentNode.value == value) {
            currentNode = null;
            return true;
        }
        while (currentNode != null) {
            if (currentNode.value > value) {
                if (currentNode.left != null && currentNode.left.value == value) {
                    currentNode.left = helper(currentNode.left);
                    return true;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (currentNode.value < value) {
                if (currentNode.right != null && currentNode.right.value == value) {
                    currentNode.right = helper(currentNode.right);
                    return true;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }
    private Node helper(Node root) {
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            Node rightChild = root.right;
            Node leftExtremeRight = findLastRight(root.left);
            leftExtremeRight.right = rightChild;
            return root.left;
        }
    }

    private Node findLastRight(Node root) {
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }

    public Object lookUp(Integer value){
        Node currentNode = root;
        if(currentNode == null){
            return false;
        }
        while(currentNode != null){
            if(value < currentNode.value){
                currentNode = currentNode.left;
            }else if(value > currentNode.value){
                currentNode = currentNode.right;
            }else{
                System.out.println("Element is present.");
                return value;
            }
        }
        return false;
    }

    public void print(Node root){
        BTreePrinter.printNode(root);
    }

    public List<Integer> breadthFirstSearchR(List<Integer> list, List<Node> queue){
        if(queue.size() == 0){
            return list;
        }
        Node currentNode = queue.remove(0);
        list.add(currentNode.value);
        if(currentNode.left != null){
            queue.add(currentNode.left);
//            list.addAll(breadthFirstSearchR(list,queue));
        }
        if(currentNode.right != null){
            queue.add(currentNode.right);
//            list.addAll(breadthFirstSearchR(list,queue));
        }
        return breadthFirstSearchR(list,queue);
    }

    public List<Integer> breadthFirstSearch(){
        List<Integer> list = new ArrayList<>();
        Node currentNode = root;
        if(currentNode != null){
            List<Node> queue = new ArrayList<>();
            queue.add(currentNode);
            while(queue.size() > 0){
                currentNode = queue.remove(0);
                list.add(currentNode.value);
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }
        return list;
    }

    public List<Integer> DFSInorder(){
        return traverseInOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traverseInOrder(Node root, ArrayList<Integer> list) {
        if(root.left != null){
            traverseInOrder(root.left,list);
        }
        list.add(root.value);
        if(root.right != null){
            traverseInOrder(root.right, list);
        }
        return list;
    }

    public List<Integer> DFSPreorder(){
        return traversePreOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traversePreOrder(Node root, ArrayList<Integer> list) {
        list.add(root.value);
        if(root.left != null){
            traversePreOrder(root.left, list);
        }
        if(root.right != null){
            traversePreOrder(root.right, list);
        }
        return list;
    }

    public List<Integer> DFSPostorder(){
        return traversePostOrder(this.root, new ArrayList<>());
    }

    private List<Integer> traversePostOrder(Node root, ArrayList<Integer> list) {
        if(root.left != null){
            traversePostOrder(root.left, list);
        }
        if(root.right != null){
            traversePostOrder(root.right, list);
        }
        list.add(root.value);
        return list;
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);
        bst.print(bst.root);
//        System.out.println(bst.breadthFirstSearch());
//        System.out.println(bst.breadthFirstSearchR(new ArrayList<>(),new ArrayList<>(Arrays.asList(bst.root))));
    //        bst.remove(20);
    //        bst.print(bst.root);
    System.out.println(bst.DFSPostorder());
    }

}
