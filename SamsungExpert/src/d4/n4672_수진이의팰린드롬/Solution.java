package d4.n4672_수진이의팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        System.setIn(Solution.class.getResourceAsStream("input.txt"));
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for (int t = 1; t <= T; t++) {
            String line = scan.next();
            int len = line.length();
            max = 0;
            int charset[] = new int[26];

            for (int i = 0; i < len; i++) {
                charset[line.charAt(i) - 'a']++;
            }

            makeStr(charset, len);
            System.out.println(String.format("#%d %d", t, max));
        }


    }

    public static class Data implements Comparable<Data>{
        char c;
        int n;

        Data(char c , int n){
            this.c = c;
            this.n = n;
        }

        @Override
        public int compareTo(Data o) {

            return o.n - this.n;
        }

        @Override
        public String toString() {
            return c + " : " + n;
        }
    }
    public static void makeStr(int charset[], int len){

        PriorityQueue<Data> queue = new PriorityQueue<>();

        for(int i = 0; i < 26; i++){
            if(charset[i] > 0)
                queue.add(new Data((char)(i + 'a'), charset[i]));
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            Data temp = queue.peek();
            if(temp.n == 1)
                break;

            sb.append(temp.c);
            queue.poll();
            int tn = temp.n - 2;

            if(tn != 0)
                queue.add(new Data(temp.c, temp.n - 2));
        }

        String str = sb.toString();
        str += sb.reverse();



        while(!queue.isEmpty()){
            Data temp = queue.poll();
            str += temp.c;
        }

        int temp = 1;

        for(int i = 0; i < len - 1; i++){
            for(int j = 1; j <= len - i; j++){
                String st = str.substring(i, i + j);
                if(isP(st)) {
                    temp++;
                }
            }
        }

        max = temp;


    }


    public static void makeP(int charset[], String result, int count, int len) {

        if (count == len) {

            int temp = 1;

            System.out.println(result );
            System.out.println();
            for(int i = 0; i < len - 1; i++){
                for(int j = 1; j <= len - i; j++){
                    String str = result.substring(i, i + j);
                    System.out.println(str);
                    if(isP(str))
                        temp++;
                }
                System.out.println();
            }

            System.out.println();
            max = Math.max(max, temp);
            return;
        }


        for (int i = 0; i < 26; i++) {

            if (charset[i] > 0) {
                charset[i]--;
                String temp = result + (char) (i + 'a');
                makeP(charset, temp, count + 1, len);
                charset[i]++;
            }
        }
    }

    public static boolean isP(String line) {
        int len = line.length();

        int f = 0;
        int t = len - 1;
        len /= 2;

        for (int i = 0; i < len; i++) {
            if (line.charAt(f) != line.charAt(t)) {
                return false;
            }
        }

        return true;
    }
}
