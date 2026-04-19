package pekan3_2511531005;   
import java.util.*;
public class NilaiMaksimum_2511531005 {

	public static int max_1005 (Stack <Integer>s ) {
		Stack <Integer> backup = new Stack<Integer> ();
		int maxvalue_1005 = s.pop();
		backup.push(maxvalue_1005);
		while(!s.isEmpty()) {
			int next_1005 = s.pop();
			backup.push(next_1005);
			maxvalue_1005 = Math.max(maxvalue_1005, next_1005);
		}
		while (!backup.isEmpty()) {
			s.push(backup.pop());  
		}
		return maxvalue_1005;
	}
	public static void main (String[] args) {
		Stack <Integer> s = new Stack<Integer>();
		s.push(70);
		s.push(12);
		s.push(20);
		
		System.out.println("isi stack " + s);
		System.out.println("stack teratas " + s.peek());
		System.out.println("nilai maksimum " + max_1005(s));
	}
}
