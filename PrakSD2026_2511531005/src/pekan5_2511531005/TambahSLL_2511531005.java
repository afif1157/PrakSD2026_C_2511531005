package pekan5_2511531005;

public class TambahSLL_2511531005 {

	public static NodeSLL_2511531005 insertAtFront_1005 (NodeSLL_2511531005 head_1005, int value_1005) {
		NodeSLL_2511531005 new_node = new NodeSLL_2511531005(value_1005);
		new_node.next = head_1005;
		return new_node;
	}
	 
	public static NodeSLL_2511531005 insertAtEnd_1005(NodeSLL_2511531005 head_1005, int value_1005) {
		NodeSLL_2511531005 newNode = new NodeSLL_2511531005(value_1005);
		if(head_1005 == null) {
			return newNode;
		}
		   
		NodeSLL_2511531005 last = head_1005;
		
		while (last.next != null) {
			last = last.next;
		}
		
		last.next = newNode;
		return head_1005;
	}
	
	static NodeSLL_2511531005 GetNode_1005(int data_1005) {
		return new NodeSLL_2511531005(data_1005);
	}
	
	static NodeSLL_2511531005 insertPost_1005(NodeSLL_2511531005 headNode_1005, int position_1005, int value_1005) {
		NodeSLL_2511531005 head_1005 = headNode_1005;

		if(position_1005 < 1) {
			System.out.println("invalid position");
			return head_1005;
		}

		if(position_1005 == 1 ) {
			NodeSLL_2511531005 new_node = new NodeSLL_2511531005(value_1005);
			new_node.next = head_1005;
			return new_node;
		}else {
			while(position_1005-- !=0 && headNode_1005 != null) {
				if(position_1005 ==1) {
					NodeSLL_2511531005 newNode = GetNode_1005(value_1005);
					newNode.next = headNode_1005.next;
					headNode_1005.next = newNode;
					break;
				}
				headNode_1005 = headNode_1005.next;
			}
			if(position_1005 !=1) 
				System.out.println("posisi di luar jangkauan");
		}
		return head_1005;
	}

	public static void printList_1005(NodeSLL_2511531005 head_1005) {
		NodeSLL_2511531005 curr = head_1005;
		while(curr != null) {
			System.out.print(curr.data_1005);
			if(curr.next != null) {
				System.out.print(" --> ");
			}
			curr = curr.next;
		}
		System.out.println();  
	}	
	
	public static void main(String[] args) {
		NodeSLL_2511531005 head_1005 = new NodeSLL_2511531005(2);
		head_1005.next = new NodeSLL_2511531005(3);
		head_1005.next.next = new NodeSLL_2511531005(5);
		head_1005.next.next.next = new NodeSLL_2511531005(6);
		
		System.out.println("tambah 1 simpul di depan :");
		int data = 1;
		head_1005 = insertAtFront_1005(head_1005, data);
		
		printList_1005(head_1005);
		
		System.out.println("tambah 1 simpul di belakang :");
		int data2 = 7;
		head_1005 = insertAtEnd_1005(head_1005, data2);
		
		printList_1005(head_1005);
		
		System.out.println("tambah 1 simpul ke data 4:");
		int data3 = 4;
		int pos=4;
		head_1005= insertPost_1005(head_1005, pos, data3);
		
		printList_1005(head_1005);
	}
}
