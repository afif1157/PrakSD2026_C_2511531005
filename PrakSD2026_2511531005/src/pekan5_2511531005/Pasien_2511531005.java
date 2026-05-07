package pekan5_2511531005;

public class Pasien_2511531005 {

	
	//atribut 
	
	private String namaPasien_1005;
	private String keluhan_1005;
	private int nomorAntrian_1005;
	Pasien_2511531005 next_1005;

	//konstruktor
	
	public Pasien_2511531005(String nama, String keluhan, int nomor) {
		this.namaPasien_1005 = nama;
		this.keluhan_1005 = keluhan;
		this.nomorAntrian_1005 = nomor;
		this.next_1005 = null;
	}
	
	//selektor
	public String getNamaPasien_1005() {
		return namaPasien_1005;
	}
	
	public String getKeluhan_1005() {
		return keluhan_1005;
	}
	
	public int getNomorAntrian_1005() {
		return nomorAntrian_1005;
	}
	
	public Pasien_2511531005 getNext_1005(){
		return next_1005;
	}
	
	//mutator
	public void setNamaPasien_1005(String namaPasien_1005) {
		this.namaPasien_1005 = namaPasien_1005;
	}
	
	public void setKeluhan_1005(String keluhan_1005) {
		this.keluhan_1005 = keluhan_1005;
	}
	
	public void setNomorAntrian_1005(int nomorAntrian_1005) {
		this.nomorAntrian_1005 = nomorAntrian_1005;
	}
	
	public void setNext_1005 (Pasien_2511531005 next_1005) {
		this.next_1005 = next_1005;
	}
	
}
