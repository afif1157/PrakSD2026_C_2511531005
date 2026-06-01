package pekan8_2511531005;
import java.util.Scanner;
class Lagu_2511531005{
	String judul_1005;
	String penyanyi_1005;
	int durasi_1005;
	
	Lagu_2511531005(String judul, String penyanyi, int durasi){
		this.judul_1005 = judul;
		this.penyanyi_1005 = penyanyi;
		this.durasi_1005 = durasi;
	}
}

public class Sorting_2511531005 {
	
	Lagu_2511531005[] dataLagu_1005 = new Lagu_2511531005[20];
	int jumlahLagu_1005 = 0; 
	
	void inputData_1005() {
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("kicau mania", "endy", 220);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("mas buahlil ganteng", "bang galid", 129);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("dj malam pagi", "karim", 123);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("bintang lima", "arip ganteng", 254);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("so asu", "nopal", 226);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("malu malu boy", "pahri", 283);	
		dataLagu_1005[jumlahLagu_1005++] = new Lagu_2511531005("tabola bale", "rehan", 190);	
	}
	
	void tampilData_1005() {
		for (int i = 0; i < jumlahLagu_1005; i++) {
			System.out.println((i + 1)+". " + dataLagu_1005[i].judul_1005 + " - " + dataLagu_1005[i].penyanyi_1005 + " - " + dataLagu_1005[i].durasi_1005 + " detik");
		}
	}
	
	void shellSort_1005() {
		int n_1005 = jumlahLagu_1005;
		
		for (int gap_1005 = n_1005/2; gap_1005 > 0; gap_1005/=2) {
			for (int i = gap_1005; i < n_1005; i++) {
				Lagu_2511531005 temp_1005 = dataLagu_1005[i];
				int j;
				for(j = i; j >= gap_1005 && dataLagu_1005[j - gap_1005].judul_1005.compareToIgnoreCase(temp_1005.judul_1005) > 0; j -= gap_1005) {
					dataLagu_1005[j] = dataLagu_1005[j - gap_1005];
				}
				dataLagu_1005[j] = temp_1005;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input_1005 = new Scanner (System.in);
		
		Sorting_2511531005 playlist_1005 = new Sorting_2511531005();
		
		playlist_1005.inputData_1005();
		System.out.println("=== SHORTING PLAYLIST NIM : 2511531005 ===");
		System.out.println("pilih algoritma (1=Shell, 2=Quick, 3=Merge) : ");
		int pilihan = input_1005.nextInt();
		
		System.out.println("\n data sebelum sorting :");
		playlist_1005.tampilData_1005();
		
		if (pilihan == 1) {
			playlist_1005.shellSort_1005();
			
			System.out.println("\n data setelah shellsort(judul A-Z) : ");
			playlist_1005.tampilData_1005();
		}
		else {
			System.out.println("\n yang disuruh cuma catu metode sorting\n pilih nomor 1");
		}
		input_1005.close();

	}

}
