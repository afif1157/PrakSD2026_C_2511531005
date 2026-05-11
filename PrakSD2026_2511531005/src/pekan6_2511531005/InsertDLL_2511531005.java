package pekan6_2511531005;

public class InsertDLL_2511531005 {

	static NodeDLL_2511531005 InsertBegin_1005(NodeDLL_2511531005 head_1005, int data_1005) {
		NodeDLL_2511531005 new_node_1005 = new NodeDLL_2511531005(data_1005);
		
		new_node_1005.next_1005 = head_1005;
		
		if(head_1005 != null) {
			head_1005.prev_1005 = new_node_1005;  
		}
		return new_node_1005;
	}
	
	public static NodeDLL_2511531005 InsertEnd_1005(NodeDLL_2511531005 head_1005, int newData) {
		
		NodeDLL_2511531005 newNode_1005 = new NodeDLL_2511531005(newData);
		
		if (head_1005 == null) {
			head_1005 = newNode_1005;
		}
		else {
			NodeDLL_2511531005 curr = head_1005;
			while (curr.next_1005 != null) {
				curr = curr.next_1005;
			}
			curr.next_1005 = newNode_1005;
			newNode_1005.prev_1005 = curr;
		}
		return head_1005;
	}
	
	public static NodeDLL_2511531005 InsertAtPosition_1005(NodeDLL_2511531005 head_1005, int pos_1005, int new_data_1005) {
		
		NodeDLL_2511531005 new_node_1005 = new NodeDLL_2511531005(new_data_1005);
		
		if(pos_1005 == 1 ) {
			new_node_1005.next_1005 = head_1005;
			if(head_1005 != null) {
				head_1005.prev_1005 = new_node_1005;
				
			}
			head_1005 = new_node_1005;
			return head_1005;
		}
		
		NodeDLL_2511531005 curr_1005 = head_1005;
		
		for (int i = 1; i < pos_1005-1 && curr_1005 != null; ++i) {
			curr_1005 = curr_1005.next_1005;
		}
		if(curr_1005 == null) {
			System.out.println("posisi tidak ada");
			return head_1005;
		}
		new_node_1005.prev_1005 = curr_1005;
		new_node_1005.next_1005 = curr_1005.next_1005;
		curr_1005.next_1005 = new_node_1005;
		
		if(new_node_1005.next_1005 != null) {
			new_node_1005.next_1005.prev_1005 = new_node_1005;
		}
		return head_1005;
		
	}
	public static void printList_1005(NodeDLL_2511531005 head_1005) {
		
		NodeDLL_2511531005 curr_1005 = head_1005;
		
		while (curr_1005 != null) {
			System.out.print(curr_1005.data_1005 + " <-> ");
			curr_1005 = curr_1005.next_1005;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		NodeDLL_2511531005 head_1005 = new NodeDLL_2511531005(2);
		head_1005.next_1005 = new NodeDLL_2511531005(3);
		head_1005.next_1005.prev_1005 = head_1005;
		head_1005.next_1005.next_1005 = new NodeDLL_2511531005(5);
		head_1005.next_1005.next_1005.prev_1005 = head_1005.next_1005;
		
		System.out.println("DLL awal : ");
		printList_1005(head_1005);
		
		head_1005 = InsertBegin_1005(head_1005, 1);
		System.out.print("simpul 1 ditambahkan di awal : ");
		printList_1005(head_1005);
		
		System.out.print("simpul 6 ditambahkan di akhir : ");
		int data_1005 = 6;
		head_1005 = InsertEnd_1005(head_1005, data_1005);
		printList_1005(head_1005);
		
		System.out.print("tambah node 4 di posisi 4 : ");
		int data2_1005 = 4;
		int pos_1005 = 4;
		head_1005 = InsertAtPosition_1005(head_1005, pos_1005, data2_1005);
		printList_1005(head_1005);
	}
	
}
