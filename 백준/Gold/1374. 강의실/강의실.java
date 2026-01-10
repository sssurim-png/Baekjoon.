import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());



        int[][] arr=new int[N][3];
        for(int i=0; i<N; i++){
            String[]st =br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(st[0]);
            arr[i][1] = Integer.parseInt(st[1]);
            arr[i][2] = Integer.parseInt(st[2]);
        }
//arr을 정렬해놔야 처리 순서를 보장한다. 
//없으면 나중에 시작하는 강의를 먼저 처리할 수가 있다
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1]!=b[1]){
                    return a[1]-b[1];
                }
                return a[2]-b[2];
            }
        });

        //pq를 종료시간 기준으로 정렬하여, 종료시간 작은 것이 poll의 조건으로 설정
        PriorityQueue<int[]>pq =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2]-b[2];
            }
        });
// 들어오는 시작값이 이전에 pq에 넣어놓은 값의 종료시간과 같거나 이후의 수인것 중 가장 가까운 값을 poll
        for(int i=0; i<N; i++) {
            int start = arr[i][1];
            if(!pq.isEmpty() && start>=pq.peek()[2]){
                pq.poll();
            }
            pq.offer(arr[i]);

        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
    }
}
