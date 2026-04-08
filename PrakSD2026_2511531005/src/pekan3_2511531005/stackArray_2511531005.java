package pekan3_2511531005;

public class stackArray_2511531005 {
	static final int MAX_1005 = 1000;
	int top_1005;
	int a[] = new int [MAX_1005];
	boolean isEmpty(){
		return (top_1005 <0);
	}
	
	stackArray_2511531005(){
		top_1005=-1;
	}
	
	boolean push_1005(int x) {
		if (top_1005 >= (MAX_1005 - 1 )) {
			System.out.println("stack overflow");
			return false;
		}
		else {
			a[++top_1005] = x;
			System.out.println(x + " dimasukkan dalam stack");
			return true;
		}
	}
	
	int pop_1005() {
		if (top_1005<0) {
			System.out.println("stack underflowa");
			return 0;
		}
		else {
			int x = a[top_1005--];
			return x;
		}
	}
	
	int peak_1005() {
		if (top_1005 < 0) {
			System.out.println("stack undeflow");
			return 0;
		}
		else {
			int x = a[top_1005];
			return x;
		}
	}
	void print_1005() {
		for (int i = top_1005; i>-1; i--) {
			System.out.print(" " + a[i]);
		}
	}
}
	
	
