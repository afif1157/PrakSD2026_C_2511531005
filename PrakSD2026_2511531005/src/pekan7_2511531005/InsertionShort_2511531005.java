package pekan7_2511531005;

public class InsertionShort_2511531005 {

	public static void InsertionShort_2511531005 (int[] arr_1005) {
		int n_1005 = arr_1005.length;
		for (int i = 1; i< n_1005; i++) {
			int key_1005 = arr_1005[i];
			int j = i - 1;
			while (j >= 0 && arr_1005[j] > key_1005) {
				arr_1005[j + 1] = arr_1005[j];
				j--;
			}
			arr_1005[j + 1] = key_1005;
		}
	}
	
	public static void main(String[] args) {
		int arr_1005[] = { 23, 78, 45, 8, 32, 56, 1};
		int n_1005 = arr_1005.length;
		System.out.printf("array yang belum terurut : \n");
		for(int i = 0; i<n_1005; i++) 
			System.out.print(arr_1005[i] + " ");
		System.out.println("");
		InsertionShort_2511531005(arr_1005);
		System.out.printf("array yang terurut : \n");
		for(int i = 0; i< n_1005; i++)
			System.out.print(arr_1005[i] + " ");
		System.out.println("");
		
	}
	
}
