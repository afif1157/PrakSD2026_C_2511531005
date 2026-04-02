package pekan1_2511531005;
import java.util.*;
public class ADTmobil_2511531005 {
	private String nama;
	private int tahun;
	private int cc;
	private int harga;
	private String merek;
	private ArrayList<ADTmobil_2511531005> daftarmobil;
	
	public ADTmobil_2511531005() {
	     this.daftarmobil = new ArrayList<>();
	 }

	
	public ADTmobil_2511531005(String nama, int tahun, int cc, int harga, String merek) {
		this.nama = nama;
		this.tahun = tahun;
		this.cc = cc;
		this.harga = harga;
		this.merek = merek;
	}
	
	public String getnama() {
		return nama;
	}
	public int gettahun() {
		return tahun;
	}
	public int getcc() {
		return cc;
	}
	public int getharga() {
		return harga;
	}
	public String getmerek() {
		return merek;
	}
	public ArrayList<ADTmobil_2511531005> getdaftarmobil() {
		return daftarmobil;   
		}  
	
	
	public void setnama(String nama) {
		this.nama = nama;
	}
	public void settahun(int tahun) {
		this.tahun = tahun;
	}
	public void setcc(int cc) { 
		this.cc = cc;
	}
	public void harga(int harga) {
		this.harga = harga;
	}
	public void merek(String merek) {
		this.merek = merek;
	}
	
	
	public void tambahmobil(ADTmobil_2511531005 m) {
	     daftarmobil.add(m);
	     System.out.println("daftar mobil : " + this.getdaftarmobil());
	 }
	
	public void hapusmobil (ADTmobil_2511531005 m) {
		daftarmobil.remove(0);
		System.out.println("daftar mobil setelah dihapus : "+this.getdaftarmobil());
	}
	
	 
	public String toString() {
		return "nama : " + nama + ",tahun : " + tahun + ",cc : "+ cc+ ",harga : " + harga + ",merek : " +merek; 
	}
	
	
}
