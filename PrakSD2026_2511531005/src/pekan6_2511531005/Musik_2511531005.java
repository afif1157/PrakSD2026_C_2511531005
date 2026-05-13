package pekan6_2511531005;
import java.util.Scanner;
import pekan5_2511531005.NodeSLL_2511531005;

public class Musik_2511531005 {
	
	private Lagu_2511531005 head_1005;
	private Lagu_2511531005 tail_1005;
	
	//tambah lagu di akhir playlist
	public void tambahLagu_1005(String judul_1005, String penyanyi_1005) {
	
		//membuat node baru
		Lagu_2511531005 newNode_1005 = new Lagu_2511531005 (judul_1005, penyanyi_1005);
		
		//jjka playlist kosong, head dan tail menunjuk ke node baru
		if(head_1005 == null) {
			head_1005 = newNode_1005;
			tail_1005 = newNode_1005;
		}
		else {
			tail_1005.next_1005 = newNode_1005;
			newNode_1005.prev_1005 = tail_1005;
			tail_1005 = newNode_1005;
		}
		System.out.println("lagu berhasil ditambahkan ");
	}
	
	//tambah menghapus lagu di awal playlist
	public void hapusLaguAwal_1005() {
		if(head_1005 == null) {
			System.out.println("playlist kosong");
			return;
		}
		System.out.println("menghapus lagu " + head_1005.getjudul_1005());
		
		
		if(head_1005 == tail_1005) {
			head_1005= null;
			tail_1005 = null;
		}
		else {
			head_1005 = head_1005.next_1005;	
			head_1005.prev_1005 = null;
		}
		System.out.println("lagu berhasil dihapus");
	}
	
	//lihat playlist maju
	public void lihatPlaylistMaju_1005() {
		if(head_1005 == null) {
			System.out.println("playlist kosong");
			return;
		}
		System.out.println("=== playlist maju ===");
		
		Lagu_2511531005 curr_1005 = head_1005 ;
		
		while (curr_1005 != null) {
			System.out.println(curr_1005.getjudul_1005()+ " -  " +curr_1005.getpenyanyi_1005());
			curr_1005 = curr_1005.next_1005;
		}
	}	
	
	//lihat playlist mundur
	public  void lihatPlaylistMundur() {
		
		if(tail_1005 == null) {
			System.out.println("playlist kosong");
			return;
		}
		System.out.println("=== playlist mundur ===");
		Lagu_2511531005 curr_1005 = tail_1005;
		while (curr_1005 != null) {
			System.out.println(curr_1005.getjudul_1005() + " - "+ curr_1005.getpenyanyi_1005());
			curr_1005 = curr_1005.prev_1005;
		}
	}
	
	//cari lagu
	public void cariLagu_2511531005 (String judul_1005) {
		if(head_1005 == null) {
			System.out.println("playlist kosong");
			return;
		}
		Lagu_2511531005 curr_1005 = head_1005;
		boolean ketemu = false;
		
		while (curr_1005 != null) {
			if(curr_1005.getjudul_1005().equalsIgnoreCase(judul_1005)) {
				System.out.println("lagu ditemukan " + curr_1005.getjudul_1005() + " - " + curr_1005.getpenyanyi_1005());
				ketemu = true;
				break;
			}
			curr_1005 = curr_1005.next_1005;
		}
		if (!ketemu) {
			System.out.println("lagu tidak ditemukan!");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		Musik_2511531005 playlist = new Musik_2511531005();
		int choice;	
		
		do {
			System.out.println("\n=== playlist musik nim : 2511531005");
			System.out.println("1. tambah lagu");
			System.out.println("2. hapus lagu pertama");
			System.out.println("3. lihat playlist meaju");
			System.out.println("4. lihat playlist mundur ");
			System.out.println("5. cari lagu");
			System.out.println("6. keluar");
			System.out.println("pilihan : ");
			choice = input.nextInt();
			input.nextLine();
			
		switch (choice) {
				
			case 1:
				System.out.println("judul :");
				String judul_1005 = input.nextLine();
				System.out.println("penyanyi :");
				String penyanyi_1005 = input.nextLine();
				playlist.tambahLagu_1005(judul_1005, penyanyi_1005);
				break;
				
			case 2:
				playlist.hapusLaguAwal_1005 ();
				break;
				
			case 3:
				playlist.lihatPlaylistMaju_1005();
				break;
				
			case 4:
				playlist.lihatPlaylistMundur();
				break;
				
			case 5:
				System.out.println("masukkan judul :");
				String cariLagu_1005 = input.nextLine();
				playlist.cariLagu_2511531005(cariLagu_1005);
				break;
			case 6: 
				System.out.println("program selesai");
				break;
				
			default:
				System.out.println("pilihan tidak valid!");
			}
		}
		while (choice != 6);
		input.close();
	}
	
}
