package pekan7_2511531005;

public class BubleShort_2511531005 {
	
	public static void BubleShort_2511531005(int[] arr_1005) {
		int n_1005 = arr_1005.length;
		for(int i = 0; i < n_1005; i++) { 
			for(int j = 0; j < n_1005 - i - 1; j++) {
				if(arr_1005[j] > arr_1005[j+1]) {
					int temp_1005 = arr_1005[j];
					arr_1005[j] = arr_1005[j+1];
					arr_1005[j + 1] = temp_1005;
					
				}
			}  
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr_1005[] = {23, 78, 45, 8, 32, 56, 1 };
		int n_1005 = arr_1005.length;
		System.out.printf("array yang belum terurut : \n");
		for(int i = 0; i < n_1005; i++)
			System.out.print(arr_1005[i] + " ");
		System.out.println("");
		
		BubleShort_2511531005(arr_1005);
		System.out.printf("array yang terurut menggunakan bableshort : \n");
		for(int i = 0; i < n_1005; i++)
			System.out.print(arr_1005[i] + " ");
		System.out.println("");
		
	}

}
