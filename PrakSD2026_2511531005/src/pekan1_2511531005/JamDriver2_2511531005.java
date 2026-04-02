package pekan1_2511531005;
import java.util.Scanner;
public class JamDriver2_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("=== Program Driver Objek Jam ===");
		// input jam pertana
		System.out.println("/n--- input jam 1 ---");
		Jam_2511531005 j1 = buatJamDariInput(input);
		
		// input jam kedua
		System.out.println("/n--- input jam 2 ---");
		Jam_2511531005 j2 = buatJamDariInput(input);
		
		//menampilkan data
		System.out.println("/n--- Hasil Operasi ---");
		System.out.println("jam 1 string = " + j1.toString());
		System.out.println("jam 2 string = " + j2.toString());
		System.out.println("jam 1 dalam detik = " + j1.toSeconds());
		System.out.println("jam 2 dalam detik = " + j2.toSeconds());
		
		//operasi relasional
		int perbandingan = j1.compareTo(j2);
		if (perbandingan > 0) {
			System.out.println("status : jam 1 lebih lebih lambat (setelah) jam 2");
		}
		else if (perbandingan < 0){
			System.out.println("status : jam 1 lebih awal lambat (setelah) jam 2");
		}
		else  {
			System.out.println("status : jam 1 dan jam 2 persis");
		}
		
		//operasi aritmetika
		System.out.println("durasi (j1 ke j2) : "+ Jam_2511531005.durasiDetik(j1, j2)+" detik" );
		
		Jam_2511531005 jNext = j1.nextSecond();
		System.out.println("jam 1 detik berikutnya : " + jNext);
		
		Jam_2511531005 jPrev = j1.prevSeconds();
		System.out.println("jam 1 detik sebelumnya : " + jPrev);
		
		//operasi penjumlahan jam
		Jam_2511531005 jHasilPlus = j1.plus(j2);
		System.out.println("hasil j1 + j2 : " + jHasilPlus );
		
		input.close();
		System.out.println("/n program selesai.");
	}

	private static Jam_2511531005 buatJamDariInput(Scanner input) {
		int h, m, s;
		while (true) {
			System.out.println("masukkan jam (0-23) : ");
			h=input.nextInt();
			System.out.println("masukkkan menit (0-59) :");
			m=input.nextInt();
			System.out.println("masukkan detik (0-59) : ");
			s=input.nextInt();
			
			if (Jam_2511531005.isValid(h, m, s)) {
				return new Jam_2511531005(h, m, s);
			}
			else {
				System.out.println("[Eror] input tidak valid! silahkan ulangi.");
			}
		}
	}

}
