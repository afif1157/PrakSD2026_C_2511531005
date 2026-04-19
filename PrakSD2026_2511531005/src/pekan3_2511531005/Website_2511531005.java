package pekan3_2511531005;

public class Website_2511531005 {

	private String judul_1005;
	private String url_1005;
	
	public Website_2511531005(String judul_1005, String url_1005) {
		this.judul_1005=judul_1005;
		this.url_1005=url_1005;
	}
	
	public String getJudul_1005() {
		return judul_1005;
	}
	public String getUrl_1005() {
		return url_1005;
	}
	
	public void setJudul_1005(String judul_1005) {
		this.judul_1005=judul_1005;
	}
	public void setUrl_1005(String url_1005) {
		this.url_1005=url_1005;
	}
	
	public  String toString() {
		return "\n judul website : " + judul_1005 + "\n url website   : " + url_1005; 
	}
}
