package pekan4_2511531005;
import java.util.*;
public class AntrianLoket_2511531005 {
	
	private int front, rear, max;
	private String [] queue;
   
	public AntrianLoket_2511531005(int max) {
		this.max = max;
		queue = new String[max];
		front = -1;
		rear = -1;
	}
	
	boolean isEmpty() {
		return front == -1;
	}
	
	boolean isFull() {
		return rear == max -1;
	}
	
	void enqueue(String nama) {
		if (isFull()) {
			System.out.println("antrian penuh!");
		}else {
			if (front == -1) front = 0;
			rear++;
			queue[rear] = nama;
			System.out.println("data berhasil ditambahkan ke antrian");
		}
	}
	
	void dequeue() {
		if (isEmpty()) {
			System.out.println("antrian kosong!");
		}else {
			String served = queue[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			}else {
				front++;
			}
			System.out.println(served + " telah dilayani");
		}
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("antrian kosong!");
		}else {
			System.out.println("isi antrian : ");
			int nomor =1;
			for (int i = front ; i <= rear ; i++) {
				System.out.println(nomor +". "+ queue[i]);
				nomor++;
			}
		}
	}
	
	void reverse() {
		if(isEmpty()) {
			System.out.println("antrian kosong!");
			return;
		}
		int i = front; 
		int j = rear;
		while(i<j) {
			String temp = queue[i];
			queue[i] = queue[j];
			queue[j] = temp;
			i++;
			j--;
		}
		System.out.println("isi antrian :");
		int nomor = 1;	
		for (int k = front ; k <= rear; k++){
			System.out.println(nomor + ". " + queue[k]);
			nomor++;
		}
	}
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner (System.in);
		AntrianLoket_2511531005 antrian = new AntrianLoket_2511531005(10);
		
		int choice;
		
		do {
			System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
			System.out.println("1. tambah antrian");
			System.out.println("2. hapus antrian");
			System.out.println("3. tampilkan antrian");
			System.out.println("4. reverse");
			System.out.println("5. keluar");
			System.out.println("pilih menu : ");
			choice = input.nextInt();
			input.nextLine();
			
			
			switch (choice) {
			case 1:
				System.out.println("masukkan nama pelanggan : ");
				String nama = input.nextLine();
				antrian.enqueue(nama);
				break;
			case 2:
				antrian.dequeue();
				break;
			case 3:
				antrian.display();
				break;
			case 4:
				antrian.reverse();
				break;
			default:
				System.out.println("program selesai");
				break;
			}
		}
		while (choice !=5); 
			input.close();
		
	}
}

