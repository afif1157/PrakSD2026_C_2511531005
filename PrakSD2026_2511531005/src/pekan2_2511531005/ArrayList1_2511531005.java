package pekan2_2511531005;  
import java.util.ArrayList;
public class ArrayList1_2511531005 {
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//size of arrayllist
		int n = 5 ; 
		
		//declaring the arraulist with initial sica n 
		ArrayList<Integer> arrli = new ArrayList<Integer> (n);
		
		//appendig new elaments at the end of the list
		for (int i = 1 ; i<=n;i++) 
			arrli.add(i);
		
		//printing element
		System.out.println(arrli);
		
		//remove element at index 3
		arrli.remove(3);
		
		//display arraylist after deletion
		System.out.println(arrli);
		
		//print element one by one
		for(int i = 0 ; i<arrli.size();
				i++)
		System.out.print(arrli.get(i) + " ");
		
	}

}
