import java.io.*;

import java.util.TreeSet;

public class Main {
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N= Integer.parseInt(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0; i<N; i++) {
                set.add(Integer.parseInt(br.readLine()));

            }
            for(int a : set){
                bw.write(String.valueOf(a));
                bw.newLine();
            }

            bw.flush();

        }
}
