import java.util.Arrays;


public class InsertSort {

    public static void main(String[] args) {

        int arr[] = {5, 1, 3, 8, 6, 7};
        int n = arr.length;


        //insert sort

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j;

            for(j = i -1; j >=0 && arr[j] > key; j--){
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
