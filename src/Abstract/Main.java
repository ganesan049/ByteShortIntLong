package Abstract;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        String[] data = "Chennai Blore Tirupati Chennai Hyderabad".split(" ");
        int count = 0;
        for(String s: data){
            count++;
            System.out.println(s+" "+s.compareTo(data[count]));
            list.addItem(new Node(s));
        }

//        list.traverse(list.getRoot());
    }
}
