package pekan9_2511531005;

public class Node_2511531005 {
    int data_1005;
    Node_2511531005 left_1005;
    Node_2511531005 right_1005;
    
    public Node_2511531005(int data_1005) {
        this.data_1005 = data_1005;
        left_1005 = null;
        right_1005 = null;
    }
    
    public void setLeft_2511531005(Node_2511531005 node_1005) {
        if (left_1005 == null)
            left_1005 = node_1005;
    }
    
    public void setRight_2511531005(Node_2511531005 node_1005) {
        if (right_1005 == null)
            right_1005 = node_1005;
    }
    
    public Node_2511531005 getLeft_1005() {
        return left_1005;
    }
    
    public Node_2511531005 getRight_1005() {
        return right_1005;
    }
    
    public int getData_1005() {
        return data_1005;
    }
    
    public void setData_1005(int data_1005) {
        this.data_1005 = data_1005;
    }
    
    void printPreorder_1005(Node_2511531005 node_1005) {
        if (node_1005 == null)
            return;
        System.out.print(node_1005.data_1005 + " ");
        printPreorder_1005(node_1005.left_1005);
        printPreorder_1005(node_1005.right_1005);
    }
    
    void printPostorder_1005(Node_2511531005 node_1005) {
        if (node_1005 == null)
            return;
        printPostorder_1005(node_1005.left_1005);
        printPostorder_1005(node_1005.right_1005);
        System.out.print(node_1005.data_1005 + " ");
    }
    
    void printInorder_1005(Node_2511531005 node_1005) {
        if (node_1005 == null)
            return;
        printInorder_1005(node_1005.left_1005);
        System.out.print(node_1005.data_1005 + " ");
        printInorder_1005(node_1005.right_1005);
    }
    
    public void print_2511531005() {
        print_1005("", true, "");
    }
    
    public void print_1005(String prefix_1005, boolean isTail_1005, String sb_1005) {
        if (right_1005 != null) {
            right_1005.print_1005(prefix_1005 + (isTail_1005 ? "|   " : "    "), false, sb_1005);
        }
        System.out.println(prefix_1005 + (isTail_1005 ? "\\--" : "/--") + data_1005);
        if (left_1005 != null) {
            left_1005.print_1005(prefix_1005 + (isTail_1005 ? "    " : "|   "), true, sb_1005);
        }
    }
}