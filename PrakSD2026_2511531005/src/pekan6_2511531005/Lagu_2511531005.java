package pekan6_2511531005;

public class Lagu_2511531005 {
	
	private String judul_1005;
	private String penyanyi_1005;
	Lagu_2511531005 next_1005;
	Lagu_2511531005 prev_1005;
	
	// konstruktor
	public Lagu_2511531005 (String judul_1005, String penyanyi_1005) {
		this.judul_1005 = judul_1005;
		this.penyanyi_1005 = penyanyi_1005;
		this.next_1005 = null;
		this.prev_1005 = null;
	}
	
	
	//getter
	public String getjudul_1005() {
		return judul_1005;
	}
	public String getpenyanyi_1005() {
		return penyanyi_1005;
	}

	
	//setter
	public void setjudul_1005(String judul_1005) {
		this.judul_1005 = judul_1005;
	}
	public void setpenyanyi_1005(String penyanyi_1005) {
		this.penyanyi_1005 = penyanyi_1005;
	}
	

}
