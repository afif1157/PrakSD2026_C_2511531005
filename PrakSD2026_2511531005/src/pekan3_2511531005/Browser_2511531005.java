package pekan3_2511531005;
import java.util.*;
public class Browser_2511531005 {
	private ArrayList<Website_2511531005>stack;
	
	public Browser_2511531005() {
		stack = new ArrayList<>();
	}

	public static void tampilkanMenu_1005() {
		System.out.println("\n === Browser Histori NIM : 2511531005 ===");
		System.out.println("1. Kunjungi Website ");
		System.out.println("2. Tombol back");
		System.out.println("3. Lihat halaman aktif");
		System.out.println("4. cek status histori");
		System.out.println("5. keluar");
	}
	
	public void push_1005(Scanner input) {
		System.out.println("Masukkan judul : ");
		String judul_1005 = input.nextLine();
		System.out.println("Masukkan URL : ");
		String url_1005 = input.nextLine();
		stack.add(new Website_2511531005(judul_1005, url_1005));
		System.out.println("berhasil mengunjungi halaman");
	}
	
	public Website_2511531005 pop_1005() {
		if(!isEmpty()) {
			return stack.remove(stack.size()-1);
		}
		return null;
	}
	
	public Website_2511531005 peek_1005() {
		if(!isEmpty()) {
			return stack.get(stack.size()-1);
		} 
		return null;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void tampilkanStack_1005() {
		if(isEmpty()) {
			System.out.println("histori kosong");
		}
		else {
			for(int i = stack.size()-1; i>=0; i--) {
				System.out.println(stack.get(i));
			}
		}
		
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Browser_2511531005 browser = new Browser_2511531005();
		Scanner input = new Scanner (System.in);
		
		int choice;
		
		do {
			tampilkanMenu_1005();
			System.out.println("Pilihan :");
			choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:
				browser.push_1005(input);
				break;
			case 2:
				Website_2511531005 removed = browser.pop_1005();
				if(removed != null) {
					System.out.println("halaman " + removed.getJudul_1005()+ " berhasil dihapus");
				}
				else {
					System.out.println("tidak ada histori untuk kembali");
				}
				break;
			case 3 :
				Website_2511531005 aktif = browser.peek_1005();
				if(aktif != null) {
					System.out.println("halaman aktif "+ aktif);
				}
				else {
					System.out.println("tidak ada halama aktif");
				}
				break;
			case 4:
				if(browser.isEmpty()) {
					System.out.println("histori kosong");
				}
				else {
					System.out.println("histori tersedia" );
				}
				break;
			case 5 :
				System.out.println("keluar dari program");
				break;
			default:
				System.out.println("pilihan tidak vaid!");
			}
			
		}
		while(choice !=5) ;
			input.close();
		
		
	}

}
