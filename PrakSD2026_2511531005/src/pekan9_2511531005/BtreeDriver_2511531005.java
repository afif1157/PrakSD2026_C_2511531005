package pekan9_2511531005;

public class BtreeDriver_2511531005 {

    public static void main(String[] args) {
        // membuat Pohon
        BTree_2511531005 tree_1005 = new BTree_2511531005();
        System.out.print("Jumlah Simpul awal pohon: ");
        System.out.println(tree_1005.countNodes_1005());
        
        // menambahkan simpul data 1
        Node_2511531005 root_1005 = new Node_2511531005(1);
        
        // menjadikan simpul 1 sebagai root
        tree_1005.setRoot_1005(root_1005);
        System.out.println("Jumlah simpul jika hanya ada root");
        System.out.println(tree_1005.countNodes_1005());
        
        Node_2511531005 node2 = new Node_2511531005(2);
        Node_2511531005 node3 = new Node_2511531005(3);
        Node_2511531005 node4 = new Node_2511531005(4);
        Node_2511531005 node5 = new Node_2511531005(5);
        Node_2511531005 node6 = new Node_2511531005(6);
        Node_2511531005 node7 = new Node_2511531005(7);
        Node_2511531005 node8 = new Node_2511531005(8);
        Node_2511531005 node9 = new Node_2511531005(9);
        
        root_1005.setLeft_2511531005(node2);
        node2.setLeft_2511531005(node4);
        node2.setRight_2511531005(node5);
        node4.setRight_2511531005(node8);
        root_1005.setRight_2511531005(node3);
        node3.setLeft_2511531005(node6);
        node3.setRight_2511531005(node7);
        node6.setLeft_2511531005(node9);
        
        // set current node
        tree_1005.setCurrent_1005(tree_1005.getRoot_1005());
        System.out.println("menampilkan simpul terakhir: ");
        System.out.println(tree_1005.getCurrent_1005().getData_1005());
        
        System.out.println("jumlah simpul setelah simpul ditambahkan ");
        System.out.println(tree_1005.countNodes_1005());
        
        System.out.println("InOrder: ");
        tree_1005.printInorder_1005();
        
        System.out.println("\nPreOrder: ");
        tree_1005.printPreorder_1005();
        
        System.out.println("\nPostOrder: ");
        tree_1005.printPostorder_1005();
        
        System.out.println("\nmenampilkan simpul dalam bentuk pohon");
        tree_1005.print();
    }
}