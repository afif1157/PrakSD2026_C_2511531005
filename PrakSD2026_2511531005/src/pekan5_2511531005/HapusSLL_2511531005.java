package pekan5_2511531005;

public class HapusSLL_2511531005 {

	public static NodeSLL_2511531005 deletHead_1005(NodeSLL_2511531005 head_1005) {
		
		if (head_1005 == null)
			return null;
		
		head_1005 = head_1005.next;
		return head_1005;
	}
	
	public static NodeSLL_2511531005 removeLastNode_1005(NodeSLL_2511531005 head_1005) {
		
		if (head_1005 == null) {
			return null;
		}
		if (head_1005.next == null) {
			return null;
		}
		
		NodeSLL_2511531005 secondLast_1005 = head_1005;
		while (secondLast_1005.next.next != null) {
			secondLast_1005 = secondLast_1005.next;
		}
		
		secondLast_1005.next = null;
		return head_1005;
	}
	
	public static NodeSLL_2511531005 deleteNode_1005(NodeSLL_2511531005 head_1005, int position_1005) {
		NodeSLL_2511531005 temp = head_1005;
		NodeSLL_2511531005 prev = null;
		
		if (temp == null)
			return head_1005;
		
		if (position_1005 == 1) {
			head_1005 = temp.next;
			return head_1005;
		}
		
		for (int i = 1 ; temp != null && i < position_1005 ; i++) {
			prev = temp; 
			temp = temp.next;
		}
		
		if (temp != null) {
			prev.next = temp.next;
		}else{
			System.out.println("data tidak ada");
		}
		
		return head_1005; // ❗ ini tadi hilang
	}
	
	public static void printList_1005(NodeSLL_2511531005 head_1005) {
		NodeSLL_2511531005 curr = head_1005;
		while (curr != null) {
			System.out.print(curr.data_1005);
			if (curr.next != null) {
				System.out.print(" --> ");
			}
			curr = curr.next;
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		
		NodeSLL_2511531005 head = new NodeSLL_2511531005(1);
		head.next = new NodeSLL_2511531005(2);
		head.next.next = new NodeSLL_2511531005(3);
		head.next.next.next = new NodeSLL_2511531005(4);
		head.next.next.next.next = new NodeSLL_2511531005(5);
		head.next.next.next.next.next = new NodeSLL_2511531005(6);
		
		System.out.println("list awal :");
		printList_1005(head);
		
		head = deletHead_1005(head);
		System.out.println("list setelah head dihapus :");
		printList_1005(head);
		
		head = removeLastNode_1005(head);
		System.out.println("list setelah simpul terakhir dihapus");
		printList_1005(head);
		
		int position = 2;
		head = deleteNode_1005(head, position);
		
		System.out.println("list setelah posisi 2 dihapus");
		printList_1005(head);
	}
}
