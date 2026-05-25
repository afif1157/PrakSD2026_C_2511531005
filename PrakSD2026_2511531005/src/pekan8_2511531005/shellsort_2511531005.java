package pekan8_2511531005;

public class shellsort_2511531005 {
	  
	public static void shellsort_2511531005(int[] A_1005) {
		
		int n_1005 = A_1005.length;
		int gap_1005 = n_1005/2;
		while (gap_1005 > 0) {
			for(int i = gap_1005; i < n_1005; i++) {
				int temp_1005 = A_1005[i];
				int j = i;
				while (j >= gap_1005 && A_1005[j - gap_1005] > temp_1005) {
					A_1005[j] = A_1005[j - gap_1005];
					j = j -gap_1005;
				} 
				A_1005[j] = temp_1005;
			}
			gap_1005= gap_1005/2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		System.out.println("sebelum : ");
		printArray(data);
		
		shellsort_2511531005(data);
		
		System.out.println("sesudah shellsort : ");
		printArray(data);
		

}
	
	public static void printArray(int[] arr) {
		for (int i: arr) System.out.print(i + " ");
		System.out.println();
	}
}
