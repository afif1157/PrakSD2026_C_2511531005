package pekan6_2511531005;

public class PenelusuranDLL_2511531005 {

	static void forwardTraversal_1005(NodeDLL_2511531005 head_1005) {
		NodeDLL_2511531005 curr_1005 = head_1005;
		
		while (curr_1005 != null) {
			System.out.print(curr_1005.data_1005 + " <-> ");
			curr_1005 = curr_1005.next_1005;
		}
		System.out.println();
	}
	
	static void backwardTraversal_1005(NodeDLL_2511531005 tail_1005) {
		
		NodeDLL_2511531005 curr_1005 = tail_1005;
		
		while (curr_1005 != null) {
			System.out.print(curr_1005.data_1005 + " <-> ");
			curr_1005 = curr_1005.prev_1005;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		NodeDLL_2511531005 head_1005 = new NodeDLL_2511531005(1);
		NodeDLL_2511531005 second_1005 = new NodeDLL_2511531005(2);
		NodeDLL_2511531005 third_1005 = new NodeDLL_2511531005(3);
		
		head_1005.next_1005 = second_1005;
		second_1005.prev_1005 = head_1005;
		second_1005.next_1005 = third_1005;
		third_1005.prev_1005 = second_1005;
		
		System.out.println("penelusuran maju : ");
		forwardTraversal_1005(head_1005);
		
		System.out.println("penelusuran mundur : ");
		backwardTraversal_1005(third_1005);
	}
	
}
