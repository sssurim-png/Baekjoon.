import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) - Math.abs(o2) == 0) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        for(int i= 0; i<N; i++){
            int a =Integer.parseInt(br.readLine());
            if(a==0){
                if(queue.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(queue.poll()+"\n");
                }
            }else{
                queue.add(a);
            }
        }

        bw.flush();
    }
}
