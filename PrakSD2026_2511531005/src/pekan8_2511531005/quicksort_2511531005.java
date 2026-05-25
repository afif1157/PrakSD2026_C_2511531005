package pekan8_2511531005;

public class quicksort_2511531005 {
	
	static void swap_1005 (int[] arr_1005, int i_1005, int j_1005) {
		int temp_1005 = arr_1005[i_1005];
		arr_1005[i_1005] = arr_1005[j_1005];
		arr_1005[j_1005] = temp_1005;
	}
	
	static void medianOfThree_1005(int [] arr_1005, int low_1005, int high_1005) {
		int mid_1005 = low_1005 + (high_1005 - low_1005) / 2;
		
		if (arr_1005[low_1005] > arr_1005[mid_1005]) {
			swap_1005(arr_1005, low_1005, mid_1005);
		}
		if (arr_1005[low_1005] > arr_1005[high_1005]) {
			swap_1005(arr_1005, low_1005, high_1005);
		}
		if (arr_1005[mid_1005] > arr_1005[high_1005]) {
			swap_1005(arr_1005, mid_1005, high_1005);
		}
		swap_1005(arr_1005, mid_1005, high_1005);
	}
	
	static int partition_1005(int[] arr_1005, int low_1006, int high_1005) {
		medianOfThree_1005(arr_1005, low_1006, high_1005);
		
		int pivot = arr_1005[high_1005];
		int i = (low_1006 - 1);
		
		for (int j = low_1006; j<= high_1005-1; j++) {
			if (arr_1005[j] < pivot) {
				i++;
				swap_1005(arr_1005, i, j);
			}
		}
		
		swap_1005(arr_1005, i + 1, high_1005);
		return(i +1);
	}
	
	static void quicksort_1005 (int[] arr_1005, int low_1005, int high_1005) {
		if (low_1005 < high_1005) {
			int pi = partition_1005(arr_1005, low_1005, high_1005);
			quicksort_1005(arr_1005, low_1005, pi -1 );
			quicksort_1005(arr_1005, pi + 1, high_1005);
		}
	}
	
	public static void printArr_1005(int[] arr_1005) {
		for(int i = 0; i< arr_1005.length;i++){
			System.out.print(arr_1005[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr_1005= {10,7,8,9,1,5};
		int N_1005 = arr_1005.length;
		System.out.println("data sebelum diurutkan :");
		printArr_1005(arr_1005);
		
		quicksort_1005(arr_1005, 0 , N_1005-1);
		
		System.out.println("data terurut quicksort :");
		printArr_1005(arr_1005);
	}

}
