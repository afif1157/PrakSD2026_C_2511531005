package pekan1_2511531005;

public class JamDriver_2511531005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jam_2511531005 a = new Jam_2511531005(23, 59, 59);
		Jam_2511531005 b = new Jam_2511531005(0, 0, 15);
		System.out.println("a			= "+a);
		System.out.println("b			= "+b);
		System.out.println("a+b			= "+a.plus(b));
		System.out.println("next 20s			= "+a.nextSecond(20));
		System.out.println("durasi(a,b) 		= " + Jam_2511531005.durasiDetik(a, b));
		System.out.println("a.compareTo(b) 		= " + a.compareTo(b));
	}

}
   