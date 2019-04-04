package n1350_최대신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Edge implements Comparable<Edge> {

        int a;
        int b;
        int w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return o.w - this.w;
        }

        @Override
        public String toString() {
            return a + " - " + b + " = " + w;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        //N = 5;

        int parent[] = new int[N + 1];
        int rank[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            makeSet(parent, rank, i);
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Edge(a, b, c));

        }


        int count = 0;
        int answer = 0;

        while(true){

            if(count == N - 1)
                break;

            Edge temp = queue.poll();

            int a = temp.a;
            int b = temp.b;

            int ap = findSet(parent, a);
            int bp = findSet(parent, b);

            if(ap == bp)
                continue;
            else
                union(parent, rank, ap, bp);

            answer += temp.w;
            count++;

        }

        System.out.println(answer);

    }

    public static void makeSet(int parent[], int rank[], int x) {

        parent[x] = x;
        rank[x] = 0;

    }

    public static int findSet(int parent[], int x) {
        if (parent[x] == x)
            return x;

        parent[x] = findSet(parent, parent[x]);
        return parent[x];
    }

    public static void union(int parent[], int rank[], int x, int y) {
        int xp = findSet(parent, x);
        int yp = findSet(parent, y);

        if (rank[xp] > rank[yp]) {
            parent[yp] = xp;
            rank[xp]++;
        } else {
            parent[xp] = yp;
            if (rank[xp] == rank[y])
                rank[yp]++;
        }

    }

}
