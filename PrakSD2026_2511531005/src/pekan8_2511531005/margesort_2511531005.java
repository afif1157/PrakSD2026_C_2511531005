package pekan8_2511531005;

public class margesort_2511531005 {
    
    void marge_1005(int arr[], int l, int m, int r) {
        int n1_1005 = m - l + 1;
        int n2_1005 = r - m;
        
        int L[] = new int[n1_1005];
        int R[] = new int[n2_1005];
        
        for(int i = 0; i < n1_1005; ++i) 
            L[i] = arr[l + i];
        for(int j = 0; j < n2_1005; ++j) 
            R[j] = arr[m + 1 + j];   
        
        int i_1005 = 0, j = 0;
        int k_1005 = l;
        
        while (i_1005 < n1_1005 && j < n2_1005) {
            if (L[i_1005] <= R[j]) {
                arr[k_1005] = L[i_1005];
                i_1005++;
            }else {
                arr[k_1005] = R[j];
                j++;
            }
            k_1005++;
        }
        
        while(i_1005 < n1_1005) {
            arr[k_1005] = L[i_1005];
            i_1005++;
            k_1005++;
        }
        
        while(j < n2_1005) {
            arr[k_1005] = R[j];
            j++;
            k_1005++;
        }
    }
    
    void sort_1005(int arr[], int l, int r) {
        if(l < r) {
            int m_1005 = (l + r) / 2;
            
            sort_1005(arr, l, m_1005);
            sort_1005(arr, m_1005 + 1, r);  
            
            marge_1005(arr, l, m_1005, r);
        }
    }
    
    static void printArr_1005(int arr[]) {
        int n_1005 = arr.length;
        for(int i = 0; i< n_1005; ++i)
            System.out.print(arr[i] +" ");  
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12,11,13,5,6,7};
        
        System.out.println("sebelum terurut :");
        printArr_1005(arr);
        
        margesort_2511531005 ob = new margesort_2511531005();
        ob.sort_1005(arr, 0 , arr.length-1);
        
        System.out.println("sesudah terurut menggunakan margesort :");
        printArr_1005(arr);
    }
}
