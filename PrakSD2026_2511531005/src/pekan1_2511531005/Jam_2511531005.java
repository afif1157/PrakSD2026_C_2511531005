	package pekan1_2511531005;
public class Jam_2511531005 {
	private int hh;
	private int mm;
	private int ss;
	//validator 
	public static boolean isValid(int h, int m, int s) {
		return (0 <= h && h <=23)&&(0 <= m && m <= 59)&&(0 <= s && s <= 59);
	}
	
	//konstruktor
	public Jam_2511531005(int h, int m, int s) {
		this.hh = h ; this.mm = m; this.ss =s;
	}
	
	//selector
	public int getHour() {
		return hh;
	}
	public int getMinute() {
		return mm;
	}
	public int getSecond() {
		return ss;
	}
	
	//mutator
	public void setHour(int h) {
		this.hh = h;
	}
	public void setMinite(int m) {
		this.mm = m;
	}
	public void setSecond(int s) {
		this.ss = s;
	}
	
	//konersi
	public int toSeconds() {
		return hh * 3600 + mm * 60 + ss;
	}
	public static Jam_2511531005 fromSeconds(int total) {
		if (total < 0) throw new IllegalArgumentException("detik negatif");
		total %= 24 *3600;
		int h = total/3600; total %=3600;
		int m = total / 60; 
		int s = total % 60;
		return new Jam_2511531005(h, m,s);
	}
	
	//relational
	public int compareTo(Jam_2511531005 other) {
		return Integer.compare(this.toSeconds(), other.toSeconds());
	}
	public boolean equals(Object o) {
		if(!(o instanceof Jam_2511531005 j)) return false;
		return hh == j.hh && mm == j.mm && ss == j.ss;
	}
	
	public int hasscode() {
		return java.util.Objects.hash(hh, mm, ss);
	}
	
	public Jam_2511531005 plus (Jam_2511531005 other) {
		return fromSeconds(this.toSeconds()+other.toSeconds());
	}
	public Jam_2511531005 minus (Jam_2511531005 other) {
		return fromSeconds(Math.floorMod(this.toSeconds()-other.toSeconds(), 24*3600));
	}
	public Jam_2511531005 nextSecond() {
		return fromSeconds(this.toSeconds()+1);
	}
	public Jam_2511531005 nextSecond(int n) {
		return fromSeconds(this.toSeconds()+Math.max(0,n));
	}
	public Jam_2511531005 prevSeconds() {
		return fromSeconds(Math.floorMod(this.toSeconds()-1, 24*3600));
	}
	public Jam_2511531005 prevSeconds(int n) {
		return fromSeconds(Math.floorMod(this.toSeconds()-Math.max(0, n), 24*3600));
	}
	
	public static int durasiDetik(Jam_2511531005 jaw, Jam_2511531005 jakh) {
		return jakh.toSeconds()-jaw.toSeconds();
	}
	
	public String toString() {
		return String.format("%2d:%2d:%2d", hh, mm, ss);
	}    
}  
