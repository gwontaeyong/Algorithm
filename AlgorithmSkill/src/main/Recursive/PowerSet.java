package Recursive;

class PowerSet {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4};
        int n = arr.length;

        boolean check[] = new boolean[n];
        int r = 3;

        // combination(arr, check, n, 0, r);
         dupleCombination(arr, new int[r], n, 0, r, 0);
       // permutation(arr, new int[r], check, n, 0, r);
        //duplePermutation(arr, new int[r], n, r, 0);
    }

    public static void combination(int arr[], boolean check[], int n, int i, int r) {

        if (i == r) {


            for (int j = 0; j < n; j++) {

                if (check[j])
                    System.out.print(arr[j] + " ");

            }

            System.out.println();

            return;
        }


        for (int j = i; j < n; j++) {
            if (!check[j]) {
                check[j] = true;
                combination(arr, check, n, i + 1, r);
                check[j] = false;
            }
        }

    }

    public static void dupleCombination(int arr[], int result[], int n, int i, int r, int count) {

        if (count == r) {


            for (int j = 0; j < r; j++) {

                System.out.print(result[j] + " ");

            }

            System.out.println();

            return;
        }


        for (int j = i; j < n; j++) {

            result[count] = arr[j];
            dupleCombination(arr, result, n, j, r, count + 1);


        }

    }

    public static void permutation(int arr[], int result[], boolean check[], int n, int i, int r) {

        if (i == r) {


            for (int j = 0; j < r; j++) {

                System.out.print(result[j] + " ");

            }

            System.out.println();

            return;
        }


        for (int j = 0; j < n; j++) {


            if (!check[j]) {
                check[j] = true;
                result[i] = arr[j];
                permutation(arr, result, check, n, i + 1, r);
                check[j] = false;
            }


        }

    }

    public static void duplePermutation(int arr[], int result[], int n, int r, int count) {

        if (count == r) {


            for (int j = 0; j < r; j++) {

                System.out.print(result[j] + " ");

            }

            System.out.println();

            return;
        }


        for (int j = 0; j < n; j++) {
            result[count] = arr[j];
            duplePermutation(arr, result, n, r, count + 1);
        }

    }

}