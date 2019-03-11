import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static int min = Integer.MAX_VALUE;
    static int max = -1;

    static int blank;
    static int full;


    static class Student {
        int start;
        int end;

        public Student(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(Main.class.getResourceAsStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];


        for (int i = 0; i < N; i++) {
            String line[] = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            students[i] = new Student(start, end);

            min = (start < min) ? start : min;
            max = (end > max) ? end : max;

        }

        int len = max - min + 1;
        boolean arr[] = new boolean[len];

        for (int i = 0; i < N; i++) {
            int start = students[i].start - min;
            int end = students[i].end - min;

            for (int j = start; j <= end; j++) {
                arr[j] = true;
            }
        }

        int count = 1;

        boolean flag = true;


        for (int i = 1; i < len; i++) {

            if (flag == true) {// full 갯수 세던도중
                if (arr[i] == false) { // 아무도 없으면
                    flag = false;
                    count = 2;
                }
                full = (count > full) ? count : full;
            } else { // blank 갯수 세다가
                if (arr[i] == true) { //사람이 들어오면
                    flag = true;
                    count = 2;
                }
                blank = (count > blank) ? count : blank;
            }
            count++;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(full + " " + blank);

    }
}
