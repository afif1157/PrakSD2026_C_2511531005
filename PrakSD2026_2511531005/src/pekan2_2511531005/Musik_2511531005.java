package pekan2_2511531005;

public class Musik_2511531005 {
	
	private String judul_1005;
	private String penyanyi_1005;
	private int durasi_1005;
	
	//konstruktor
	Musik_2511531005(String judul_1005, String penyanyi_1005, int durasi_1005){
		this.judul_1005=judul_1005;
		this.penyanyi_1005=penyanyi_1005;
		this.durasi_1005=durasi_1005;
	}
	
	//getter
	public String getjudul_1005() {
		return judul_1005;
	}
	public String getpenyanyi_1005() {
		return penyanyi_1005;
	}
	public int getdurasi_1005() {
		return durasi_1005;
	}
	
	//setter
	public void setjudul_1005(String judul_1005) {
		this.judul_1005=judul_1005;
	}
	public void setpenyanyi_1005(String penyanyi_1005) {
		this.penyanyi_1005=penyanyi_1005;
	}
	public void setdurasi_1005(int durasi_1005) {
		this.durasi_1005=durasi_1005;
	}
	
	public String toString() {
		return "\n Judul    : " + judul_1005 + "\n Penyanyi : "+ penyanyi_1005+"\n Durasi   : "+durasi_1005;
	}
	
}
