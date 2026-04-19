	package pekan2_2511531005;
	import java.util.*;
	public class MahasiswaDriver_2511531005 {
		
		public static void tampilkanMenu_2511531005() {
			System.out.println("\nmenu:");
			System.out.println("1. tambah mahasiswa ");
			System.out.println("2. tampilkan semua mahasiswa ");
			System.out.println("3. hapus mahasiswa berdasarkan nim ");
			System.out.println("4. cari mahasiswa berdasarkan nim ");
			System.out.println("5. keluar ");
		}
		
		public static void tambahMahasiswa_2511531005(ArrayList<Mahasiswa_2511531005> list, Scanner sc) {
			System.out.println("masukkan nim :");
			String nim = sc.nextLine();
			System.out.println("masukkan nama : ");
			String nama = sc.nextLine();
			System.out.println("masukkan prodi :");
			String prodi = sc.nextLine();
			list.add(new Mahasiswa_2511531005(nim, nama, prodi));
			System.out.println("mahasiswa berhasil ditambahkan.");
		}
		
		public static void tampilkanSemuaMahasiswa_2511531005(ArrayList<Mahasiswa_2511531005> list) {
			if (list.isEmpty()) {
				System.out.println("daftar mahasiswa kosong");
			}else {
				System.out.println("data mahasiswa : ");
				for (Mahasiswa_2511531005 mhs : list) {
					System.out.println(mhs);
				}
			}
		}
		
		public static void hapusMahasiswa_2511531005(ArrayList<Mahasiswa_2511531005> list, Scanner sc) {
			System.out.println("masukkan NIM yang akan dihapus : ");
			String nimHapus=sc.nextLine();
			boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
			
			if(removed) {
				System.out.println("data dengan NIM " + nimHapus + " berhasil dihapus.");
			}else {
				System.out.println("NIM tidak ditemukan.");
			}
		}
		
		public static void cariMahasiswa_2511531005(ArrayList<Mahasiswa_2511531005> list, Scanner sc) {
			System.out.println("Masukkan NIM yang dicari : ");
			String nimCari = sc.nextLine();
			boolean ditemukan = false;
			
			for (Mahasiswa_2511531005 mhs : list) {
				if(mhs.nim.equals(nimCari)) {
					System.out.println("hasil pencarian : " + mhs);
					ditemukan = true;
					break;
				}
			}
			
			if (!ditemukan) {
				System.out.println("NIM tidak ada.");
			}
		}
		
		public static void main(String[] args) {
			ArrayList<Mahasiswa_2511531005> mahasiswaList = new ArrayList<>();
			Scanner Scanner = new Scanner (System.in);
			int choice;
			
			do {
				tampilkanMenu_2511531005();
				System.out.println();
				choice = Scanner.nextInt();
				Scanner.nextLine();
				
				switch(choice) {
				case 1:
					tambahMahasiswa_2511531005(mahasiswaList, Scanner);
					break;
				case 2:
					tampilkanSemuaMahasiswa_2511531005(mahasiswaList);
					break;
				case 3:
					hapusMahasiswa_2511531005(mahasiswaList, Scanner);
					break;
				case 4:
					cariMahasiswa_2511531005(mahasiswaList, Scanner);
					break;
				case 5:
					System.out.println("keluar dari program.");
					break;
				default:
					System.out.println("pilihan tidak valid.");
					
				}
			}while(choice !=5);
			Scanner.close();
		}
	}
