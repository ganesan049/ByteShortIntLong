package Abstract;

public class MyLinkedList implements NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(root == null){
            root = item;
            return true;
        }
        ListItem currentItem = root;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
                if(currentItem.next() != null){
                    ListItem nextItem = currentItem.next();
                    currentItem.setNext(item);
                    item.setPrevious(currentItem);
                    item.setNext(nextItem);
                    nextItem.setPrevious(item);
                    return true;
                }else {
                    currentItem.setNext(item);
                    item.setPrevious(currentItem);
                    return true;
                }
            }else if(comparison > 0){
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(item);
                    item.setPrevious(currentItem.previous());
                    item.setNext(currentItem);
                    currentItem.setPrevious(item);
                }else {
                    currentItem.setPrevious(item);
                    item.setNext(currentItem);
                    root = item;
                }
                    return true;
            }else {
                System.out.println("Items already present");
                return false;
            }
//            currentItem = currentItem.next();
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem item) {
        if (root == null){
            System.out.println("The List is empty");
        }
        while (root != null){
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
