package pekan3_2511531005;
import java.util.*;
public class stackArrayDriver_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		stackArray_2511531005 s = new stackArray_2511531005();
		s.push_1005(10);
		s.push_1005(20);
		s.push_1005(30);
		System.out.println(s.pop_1005()+ " dikeluarkan dari stack");
		System.out.println("elemen teratas adalah : " + s.peak_1005());
		System.out.print("elemen pada stack : ");
		s.print_1005();
		
	}

}
