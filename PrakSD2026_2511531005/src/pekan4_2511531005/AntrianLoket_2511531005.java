package pekan4_2511531005;
import java.util.*;
public class AntrianLoket_2511531005 {
	
	private int front_1005, rear_1005, max_1005;
	private String [] queue_1005;
   
	public AntrianLoket_2511531005(int max) {
		this.max_1005 = max;
		queue_1005= new String[max];
		front_1005 = -1;
		rear_1005 = -1;
	}
	
	boolean isEmpty_1005() {
		return front_1005 == -1;
	}
	
	boolean isFul_1005l() {
		return rear_1005 == max_1005 -1;
	}
	
	void enqueue_1005(String nama) {
		if (isFul_1005l()) {
			System.out.println("antrian penuh!");
		}else {
			if (front_1005 == -1) front_1005 = 0;
			rear_1005++;
			queue_1005[rear_1005] = nama;
			System.out.println("data berhasil ditambahkan ke antrian");
		}
	}
	
	void dequeue_1005() {
		if (isEmpty_1005()) {
			System.out.println("antrian kosong!");
		}else {
			String served = queue_1005[front_1005];
			if (front_1005 == rear_1005) {
				front_1005 = -1;
				rear_1005 = -1;
			}else {
				front_1005++;
			}
			System.out.println(served + " telah dilayani");
		}
	}
	
	void display() {
		if(isEmpty_1005()) {
			System.out.println("antrian kosong!");
		}else {
			System.out.println("isi antrian : ");
			int nomor =1;
			for (int i = front_1005 ; i <= rear_1005 ; i++) {
				System.out.println(nomor +". "+ queue_1005[i]);
				nomor++;
			}
		}
	}
	
	void reverse() {
		if(isEmpty_1005()) {
			System.out.println("antrian kosong!");
			return;
		}
		int i = front_1005; 
		int j = rear_1005;
		while(i<j) {
			String temp = queue_1005[i];
			queue_1005[i] = queue_1005[j];
			queue_1005[j] = temp;
			i++;
			j--;
		}
		System.out.println("isi antrian :");
		int nomor = 1;	
		for (int k = front_1005 ; k <= rear_1005; k++){
			System.out.println(nomor + ". " + queue_1005[k]);
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
				antrian.enqueue_1005(nama);
				break;
			case 2:
				antrian.dequeue_1005();
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

