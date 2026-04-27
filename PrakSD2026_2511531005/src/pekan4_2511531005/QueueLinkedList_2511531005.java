package pekan4_2511531005;

import java.util.*;

public class QueueLinkedList_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i<6; i++) {
			q.add(i);
		}
		
		System.out.println("elemen antrian " + q);
		
		int hapus = q.remove();
		System.out.println("hapus elemen = " + hapus);
		System.out.println(q);
		
		int depan = q.peek();
		System.out.println("kepala antrian = " + depan);
		
		int banyak = q.size();
		System.out.println("size antrian = " + banyak);
	}

}
