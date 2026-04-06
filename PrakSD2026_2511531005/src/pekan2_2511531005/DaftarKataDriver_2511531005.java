package pekan2_2511531005;

public class DaftarKataDriver_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaftarKata_2511531005 al = new DaftarKata_2511531005();
		
		al.tambah_2511531005("kami");
		al.tambah_2511531005("informatika");
		
		al.tambahPada_2511531005(1, "mahaisiwa");
		
		System.out.println("awal           : " + al);
		
		al.ubahElemen_2511531005(1, "department");
		System.out.println("setelah ubah   : " +al);
		
		String terhapus = al.hapusElemen_2511531005(0);
		System.out.println("terhapus       : "+ terhapus);
		System.out.println("setelah hapus  : "+ al);
		
		System.out.println("iterasi        : ");
		al.itereasiCetak_2511531005();
		System.out.println();
		
		

	}

}
