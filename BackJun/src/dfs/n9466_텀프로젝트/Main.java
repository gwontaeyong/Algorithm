package dfs.n9466_텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int map[];
    static int count;
    static boolean cycle[];
    static boolean check[];

    static int stoi(String s) { return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = stoi(br.readLine());

        for(int t=0; t<tc; t++) {
            n = stoi(br.readLine());
            map = new int[n+1];
            cycle = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<n+1; i++)
                map[i] = stoi(st.nextToken());

            for(int i=1; i<n+1; i++) {
                check = new boolean[n+1];
                if(!cycle[i])
                    dfs(i, i);
            }

            System.out.println(count);
        }

    }

    static void dfs(int now, boolean visited[]) {
        if(visited[now])
            return;

        visited[now] = true;
        int next = map[now];

        if(visited[next] != true)
            dfs(next, visited);
        else {
            if(cycle[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                count++;
                for(int i=next; i != now; i = map[i])
                    count++;
            }
        }

        // 모든 작업이 끝나서 더이상 사용하지 않음
        cycle[now] = true;
    }

    public static void dfs(int current, int start){

        check[current] = true;
        int next = map[current];

        if(check[next]){
            if(next == start) {// 순환인 경우 방문 했던 곧은 팀으로
                for (int i = 1; i < check.length; i++) {
                    if(check[i]){
                        cycle[i] = true;
                    }
                }
            }else{
                count++;
            }
            return;
        }

        dfs(next, start);
    }



}
