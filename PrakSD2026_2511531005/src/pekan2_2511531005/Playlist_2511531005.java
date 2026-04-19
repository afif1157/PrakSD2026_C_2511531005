package pekan2_2511531005;
import java.util.*;
public class Playlist_2511531005 {
	
	public static void tampilkanMenu_1005() {
		System.out.println("\n === Playlist Musik NIM : 2511531005 ===");
		System.out.println("Pilih menu ");
		System.out.println("1. Tambah Lagu");
		System.out.println("2. Lihat Playlist");
		System.out.println("3. Hapus Lagu");
		System.out.println("4. Keluar");
	}
	
	public static void tambahLagu_1005(ArrayList<Musik_2511531005> list, Scanner input) {
		System.out.println("masukkan judul : ");
		String judul_1005 = input.nextLine();
		System.out.println("masukkan penyanyi :");
		String penyanyi_1005 = input.nextLine();
		System.out.println("masukkan durasi (detik) : ");
		int durasi_1005 = Integer.parseInt(input.nextLine());
		list.add(new Musik_2511531005(judul_1005, penyanyi_1005, durasi_1005));
		System.out.println("Data berhasil ditambahkan!");
	}
	
	public static void lihatPlaylist_1005(ArrayList<Musik_2511531005> list) {
		if (list.isEmpty()) {
			System.out.println("Playlist lagu kosong");
		}
		else {
			System.out.println("Daftar Playlist : ");
			for(Musik_2511531005 musik : list) {
				System.out.println(musik);
			}
		}
	}
	
	public static void hapusLagu_1005(ArrayList<Musik_2511531005> list, Scanner input) {
		System.out.println("masukkan index lagu yang ingin dihapus : ");
		int index = input.nextInt();
		
		if(index >= 0 && index < list.size()) {
			Musik_2511531005 lagu = list.get(index);
			list.remove(index);
			System.out.println("lagu " + lagu.getjudul_1005() + " berhasil di hapus");
		}
		else {
			System.out.println("lagu tidak ditemukan");
		}
	}
	
	public static void cekKapasitas_1005(ArrayList<Musik_2511531005> list) {
		System.out.println("\n total lagu : " + list.size());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Musik_2511531005> musiklist = new ArrayList<>();
		Scanner input = new Scanner (System.in);
		
		int choice;
		
		do {
			tampilkanMenu_1005();
			System.out.println();
			choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
			case 1:
				tambahLagu_1005(musiklist, input);
				break;
			case 2:
				lihatPlaylist_1005(musiklist);
				cekKapasitas_1005(musiklist);
				break;
			case 3:
				hapusLagu_1005(musiklist, input);
				break;
			case 4:
				System.out.println("keluar dari program");
				break;
			default:
				System.out.println("pilihan tidak valid.");
				
			}
		
		}
		
		while (choice != 4);
			input.close();
	}
	
}
