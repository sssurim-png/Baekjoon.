import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        String[] tape2 = br.readLine().split(" ");
        int[] tape = new int[N];
        for (int i = 0; i < N; i++) {
            tape[i] = Integer.parseInt(tape2[i]);
        }
        Arrays.sort(tape);

        int a =tape[0]+M; //덮는 곳을 기준으로 생각
        int count = 1;

        for(int i=1; i<N;i++){
            if(tape[i]>=a){ //테이프 더한값에 다음 구멍 거리가 안에 있다면
             count++;
             a=tape[i]+M;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();

    }
}
