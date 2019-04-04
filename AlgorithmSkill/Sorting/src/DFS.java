import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {

    }

    void DFS(int arr[],boolean result[], int n, int Idx, int Cnt)
    {
        if (Cnt == 3)
        {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = Idx; i < n; i++)
        {
            result[i] = true;
            DFS(arr, result, n, i+1, Cnt + 1);
            result[i] = false;
        }
    }
}
