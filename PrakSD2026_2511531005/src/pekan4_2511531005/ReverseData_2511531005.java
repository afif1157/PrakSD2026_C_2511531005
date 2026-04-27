package pekan4_2511531005;
import java.util.*;
public class ReverseData_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println("sebelum reverse " + q);
		Stack<Integer> s = new Stack<Integer>();
		while (!q.isEmpty()) {
			s.push(q.remove());
	}
		while (!s.isEmpty()) {
			q.add(s.pop());
		}
		System.out.println("sesudah reverse = " + q);

}
}