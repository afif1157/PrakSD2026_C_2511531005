package pekan4_2511531005;
import java.util.*;
public class IterasiQueue_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> q = new LinkedList<>();
		
		q.add("praktikum");
		q.add("struktur");
		q.add("data");
		q.add("dan");
		q.add("algoritma");
		Iterator<String> iterator = q.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+ " ");
		}
	}

}
