package pekan5_2511531005;

public class PencarianSLL_2511531005 {

	static boolean searchKey_1005 (NodeSLL_2511531005 head_1005, int key_1005) {
			NodeSLL_2511531005 curr = head_1005;
			while(curr != null) {
				if (curr.data_1005 == key_1005)
					return true;
				curr = curr.next;
			}
			return false;
	}
	public static void travelsal_1005 (NodeSLL_2511531005 head_1005) {
		NodeSLL_2511531005 curr = head_1005;
		while(curr != null) {
			System.out.print(" " + curr.data_1005);
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		NodeSLL_2511531005 head_1005 = new NodeSLL_2511531005(14);
		head_1005.next = new NodeSLL_2511531005(21);
		head_1005.next.next = new NodeSLL_2511531005(13);
		head_1005.next.next.next = new NodeSLL_2511531005(30);
		head_1005.next.next.next.next = new NodeSLL_2511531005(10);
		System.out.println("penelusuran SLL : ");
		travelsal_1005(head_1005);
		
		int key_1005 = (30);
		System.out.println("cari data " + key_1005 + " = ");
		if (searchKey_1005(head_1005, key_1005)) {
			System.out.println("ketemu");
		}else {
			System.out.println("tidak ada");
		}
	}
}
