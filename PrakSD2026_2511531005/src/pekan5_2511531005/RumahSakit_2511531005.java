package pekan5_2511531005;
import java.util.Scanner;
public class RumahSakit_2511531005 {

	private Pasien_2511531005 head_1005;
	private int countAntrian_1005;
	
	public RumahSakit_2511531005() {
		this.head_1005 = null;
		this.countAntrian_1005 = 0;
	}
	
	public void dartarkanPasien_1005(String nama, String keluhan) {
		countAntrian_1005++;
		
		Pasien_2511531005 newNode_1005 = new Pasien_2511531005(nama, keluhan , countAntrian_1005);
		
		if(head_1005 == null) {
			head_1005 = newNode_1005;
		}else {
			Pasien_2511531005 curr_1005 = head_1005;
			while (curr_1005.getNext_1005() != null) {
				curr_1005 = curr_1005.getNext_1005();
			}
			curr_1005.setNext_1005(newNode_1005);
		}
		
		System.out.println("pasien berhasil didaftarkan. nomor antrian : " + countAntrian_1005);
	}
	
	public void panggilPasien_1005() {
		if(head_1005 == null) {
			System.out.println("antrian kosong!");
			return;
		}
		
		Pasien_2511531005 deleteHead_1005 = head_1005;
		head_1005 = head_1005.getNext_1005();
		deleteHead_1005.setNext_1005(null);
		
		System.out.println(" ");
		System.out.println("PASIEN DIPANGGIL");
		System.out.println("nomor antrian 	: " + deleteHead_1005.getNomorAntrian_1005());
		System.out.println("nama 		: " + deleteHead_1005.getNamaPasien_1005());
		System.out.println("keluhan 		: " + deleteHead_1005.getKeluhan_1005());
		System.out.println(" ");
		
	}
	
	public void tampilkanAntrian_1005() {
		if(head_1005 == null) {
			System.out.println("antrian kosong!");
			return;
		}
		System.out.println(" ");
		System.out.println("DAFTAR ANTRIAN PASIEN");
		System.out.println(" ");
		
		Pasien_2511531005 curr_1005 = head_1005;
		int posisi_1005 = 1;
		
		while(curr_1005 != null) {
			System.out.println("posisi 		:" + posisi_1005);
			System.out.println("no antrian 	:" + curr_1005.getNomorAntrian_1005());
			System.out.println("nama 		:" + curr_1005.getNamaPasien_1005());
			System.out.println("keluhan 	:" + curr_1005.getKeluhan_1005());
			System.out.println(" ");
			
			curr_1005 = curr_1005.getNext_1005();
			posisi_1005++;
			System.out.println();
		}
		
	}
	
	public void cariPasien_1005(String search_1005) {
		if(head_1005 == null) {
			System.out.println("antrian kosong");
			return;
		}
		
		boolean ditemukan_1005 = false;
		Pasien_2511531005 curr_1005 = head_1005;
		int posisi_1005 = 1;
		
		System.out.println(" ");
		System.out.println("hasil pencarian : " + search_1005);
		System.out.println(" ");
		
		while (curr_1005 != null) {
			if (curr_1005.getNamaPasien_1005().equalsIgnoreCase(search_1005)) {
				System.out.println("[ditemukan] posisi ke- " + posisi_1005);
				System.out.println("no antrian : " +  curr_1005.getNomorAntrian_1005());
				System.out.println("nama : " + curr_1005.getNamaPasien_1005());
				System.out.println("keluhan : " + curr_1005.getKeluhan_1005());
				System.out.println(" ");
				ditemukan_1005 = true;
			}
			
			curr_1005 = curr_1005.getNext_1005();
			posisi_1005 ++;
		}
		
		if(!ditemukan_1005) {
			System.out.println("pasien " + search_1005 + " tidak ditemukan");
		}
		
	}
	
	public void cekStatus_1005() {
		if(head_1005 == null) {
			System.out.println(" ");
			System.out.println("STATUS : antrian kosong!");
			System.out.println(" ");
			return;
		}
		
		int jumlah_1005 = 0; 
		Pasien_2511531005 curr_1005 = head_1005;
		while(curr_1005 != null) {
			jumlah_1005 ++;
			curr_1005 = curr_1005.getNext_1005();
		}
		System.out.println(" ");
		System.out.println("STATUS ANTRIAN");
		System.out.println(" ");
		System.out.println("total pasien : " + jumlah_1005 + " orang");
		System.out.println("-pasien terdepan-");
		System.out.println("no antrian : " + head_1005.getNomorAntrian_1005());
		System.out.println("nama : " + head_1005.getNamaPasien_1005());
		System.out.println("keluhan : " + head_1005.getKeluhan_1005());
		System.out.println(" ");
	}
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner (System.in);
		RumahSakit_2511531005 rs_1005 = new RumahSakit_2511531005();
		int pilihan_1005;
		
		do {
			System.out.println("\n --Antrian Rumah Sakit NIM : 2511531005--");
			System.out.println("1. daftarkan pasien (insert)");
			System.out.println("2. panggil pasien (delete head)");
			System.out.println("3. tampilkan antrian (display)");
			System.out.println("4. cari pasien (search)");
			System.out.println("5. cek status antrian ");
			System.out.println("6. keluar");
			
			pilihan_1005 = input.nextInt();
			input.nextLine();
			
			switch(pilihan_1005) {
			case 1:
				System.out.println("masukkan nama pasien :");
				String nama_1005 = input.nextLine();
				System.out.println("masukkan keluhan :");
				String keluhan_1005 = input.nextLine();
				rs_1005.dartarkanPasien_1005(nama_1005, keluhan_1005);
				break;
				
			case 2:
				rs_1005.panggilPasien_1005();
				break;
				
			case 3:
				rs_1005.tampilkanAntrian_1005();
				break;
				
			case 4 :
				System.out.println("masukkan nama pasien yang dicari :");
				String cari_1005 = input.nextLine();	
				rs_1005.cariPasien_1005(cari_1005);
				break;
				
			case 5 :
				rs_1005.cekStatus_1005();
				break;
				
			case 6 :
				System.out.println("program selesai");
				break;
				
			default :
				System.out.println("pilihan tidak valid!");
			}
		}while (pilihan_1005 != 6);
			input.close();
	}
}
