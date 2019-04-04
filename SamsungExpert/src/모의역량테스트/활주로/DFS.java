package 모의역량테스트.활주로;

import java.util.Arrays;

public class DFS {

    static boolean Select[];

    public static void main(String[] args) {

        Select = new boolean[4];
        DFS(0, 0);
    }
    public static void DFS(int Idx, int Cnt)
    {
        if (Cnt == 3)
        {
            System.out.println(Arrays.toString(Select));
            return;
        }

        for (int i = Idx; i < 4; i++)
        {
            //if (Select[i] == true) continue;
            Select[i] = true;
            DFS(i+1, Cnt + 1);
            Select[i] = false;
        }
    }
}
