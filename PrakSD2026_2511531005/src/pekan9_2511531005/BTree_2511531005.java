package pekan9_2511531005;

public class BTree_2511531005 {
    private Node_2511531005 root_1005;
    private Node_2511531005 currentNode_1005;
    
    public BTree_2511531005() {
        root_1005 = null;
    }
    
    public boolean search_1005(int data_1005) {
        return search_1005(root_1005, data_1005);
    }
    
    private boolean search_1005(Node_2511531005 node_1005, int data_1005) {
        if (node_1005 == null)
            return false;
        if (node_1005.getData_1005() == data_1005)
            return true;
        if (node_1005.getLeft_1005() != null)
            if (search_1005(node_1005.getLeft_1005(), data_1005))
                return true;
        if (node_1005.getRight_1005() != null)
            if (search_1005(node_1005.getRight_1005(), data_1005))
                return true;
        return false;
    }
    
    public void printInorder_1005() {
        if (root_1005 != null)
            root_1005.printInorder_1005(root_1005);
    }
    
    public void printPreorder_1005() {
        if (root_1005 != null)
            root_1005.printPreorder_1005(root_1005);
    }
    
    public void printPostorder_1005() {
        if (root_1005 != null)
            root_1005.printPostorder_1005(root_1005);
    }
    
    public Node_2511531005 getRoot_1005() {
        return root_1005;
    }
    
    public void setRoot_1005(Node_2511531005 root_1005) {
        this.root_1005 = root_1005;
    }
    
    public boolean isEmpty_1005() {
        return root_1005 == null;
    }
    
    public int countNodes_1005() {
        return countNodes_1005(root_1005);
    }
    
    private int countNodes_1005(Node_2511531005 node_1005) {
        if (node_1005 == null) {
            return 0;
        } else {
            int count_1005 = 1;
            count_1005 += countNodes_1005(node_1005.getLeft_1005());
            count_1005 += countNodes_1005(node_1005.getRight_1005());
            return count_1005;
        }
    }
    
    public void print() {
        if (root_1005 != null)
            root_1005.print_2511531005();
    }
    
    public Node_2511531005 getCurrent_1005() {
        return currentNode_1005;
    }
    
    public void setCurrent_1005(Node_2511531005 node_1005) {
        this.currentNode_1005 = node_1005;
    }
}