package pekan6_2511531005;

public class HapusDLL_2511531005 {

	public static NodeDLL_2511531005 delHead_1005(NodeDLL_2511531005 head_1005) {
		if(head_1005 == null) {
			return null;
		}
		NodeDLL_2511531005 temp_1005 = head_1005;
		head_1005 = head_1005.next_1005;
		if(head_1005 != null) {
			head_1005.prev_1005 = null;
		}
		return head_1005;
	}
	
	public static NodeDLL_2511531005 delLast_1005(NodeDLL_2511531005 head_1005) {
		if(head_1005 == null) {
			return null;
		}
		if (head_1005.next_1005 == null) {
			return null;
		}
		NodeDLL_2511531005 curr_1005 = head_1005;
		while (curr_1005.next_1005 != null) {
			curr_1005 = curr_1005.next_1005;
		}
		
		if(curr_1005.prev_1005 != null) {
			curr_1005.prev_1005.next_1005 = null;
		}
		return head_1005;
	}
	
	public static NodeDLL_2511531005 delPos_1005(NodeDLL_2511531005 head_1005, int pos_1005) {
		
		if(head_1005 == null) {
			return head_1005;
		}
		NodeDLL_2511531005 curr_1005 = head_1005;
		
		for (int i = 1; curr_1005 != null && i< pos_1005; ++i) {
			curr_1005 = curr_1005.next_1005;
		}
		
		if(curr_1005 == null) {
			return head_1005;
		}
		
		if(curr_1005.prev_1005 != null) {
			curr_1005.prev_1005.next_1005 = curr_1005.next_1005;
		}
		
		if(curr_1005.next_1005 != null) {
			curr_1005.next_1005.prev_1005 = curr_1005.prev_1005;
		}
		
		if(head_1005 == curr_1005) {
			head_1005 = curr_1005.next_1005;
		}
		return head_1005;
	}
	
	public static void printList_1005(NodeDLL_2511531005 head_1005) {
		NodeDLL_2511531005 curr_1005 = head_1005;
		while (curr_1005 != null) {
			System.out.print(curr_1005.data_1005 + " <->  ");
			curr_1005 = curr_1005.next_1005;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		NodeDLL_2511531005 head_1005 = new NodeDLL_2511531005(1);
		head_1005.next_1005 = new NodeDLL_2511531005(2);
		head_1005.next_1005.prev_1005 = head_1005;
		head_1005.next_1005.next_1005 = new NodeDLL_2511531005(3);
		head_1005.next_1005.next_1005.prev_1005 = head_1005.next_1005;
		head_1005.next_1005.next_1005.next_1005 = new NodeDLL_2511531005(4);
		head_1005.next_1005.next_1005.next_1005.prev_1005= head_1005.next_1005.next_1005;
		head_1005.next_1005.next_1005.next_1005.next_1005 = new NodeDLL_2511531005(5);
		head_1005.next_1005.next_1005.next_1005.next_1005.prev_1005= head_1005.next_1005.next_1005.next_1005;
		
		System.out.print("DLL awal : ");
		printList_1005(head_1005);
		
		System.out.print("setelah head dihapus : ");
		head_1005 = delHead_1005(head_1005);
		printList_1005(head_1005);
		
		System.out.print("seteleah node terakhir dihapus : ");
		head_1005 = delLast_1005(head_1005);
		printList_1005(head_1005);
		
		System.out.print("menghapus node ke 2 : ");
		head_1005 = delPos_1005(head_1005, 2);
		
		printList_1005(head_1005);
		
	}
	
}
