package pekan2_2511531005;
import java.util.*;
public class DaftarKata_2511531005 {
	private final ArrayList<String> data;
	
	public DaftarKata_2511531005(){
		;this.data = new ArrayList<>();
	}
	
	public void tambah_2511531005(String elemen) {
		data.add(elemen);
	}
	
	public void tambahPada_2511531005(int index, String elemen) {
		data.add(index, elemen);
	}
	
	public void ubahElemen_2511531005(int index, String nilaiBaru) {
		data.set(index, nilaiBaru);
	}
	
	public String hapusElemen_2511531005(int index) {
		return data.remove(index);
	}
	
	public void itereasiCetak_2511531005(){
		for (int i = 0 ; i <data.size(); i++) {
			System.out.print(data.get(i)+" ");
		}
	}
	
	public String get(int index) {
		return data.get(index);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}

}
