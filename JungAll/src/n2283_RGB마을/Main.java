package n2283_RGB마을;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Student implements Comparable<Student>{
        int start;
        int end;

        public Student(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Student o) {

            return this.start < o.start? -1 : 1;
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
        }


        Arrays.sort(students);

        int start = students[0].start;
        int end = students[0].end;

        int empty = 0;
        int full = end - start;

        for(int i = 1; i < N; i++){
            Student st = students[i];
            //중복 부분이 있을때
            if(end >= start){
                //end = st.end;
                end = (end < st.end)? st.end:end;
                int newf = end - start;
                full = (newf > full)? newf:full;
            }else{
                start = st.start;
                int newe = start - end;
                end = st.end;
                empty = (empty < newe)?newe:empty;
            }
        }

        int nf = end - start;
        full = (nf > full)? nf:full;

        System.out.println(Arrays.toString(students));
        System.out.println(full + " : " + empty);



    }
}
