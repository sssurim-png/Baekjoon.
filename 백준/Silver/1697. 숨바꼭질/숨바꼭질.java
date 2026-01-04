import javax.management.StringValueExp;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);//target

        int max =100000;
        boolean[]visited =new boolean[max+1];
        int[]dist =new int[max+1]; //생성시 자동으로 배열 0으로 초기화


        Queue<Integer>myQue = new LinkedList<>();
        myQue.add(N);
        visited[N]=true;

        while(!myQue.isEmpty()){
            int cur = myQue.poll();
            if(cur==K){
                bw.write(String.valueOf(dist[cur]));
                bw.flush();
                return;

            }

            int[] nexts = {cur-1, cur+1, cur*2}; //해당 경로를 다 탐색할 수 있게 //이전q는 노드랑 간선연결한 것들을 탐색했지만 이건 경우싀 수로 이동하여 탐색
            for(int next: nexts){
                if(next>=0 &&next<=max && !visited[next]){
                    visited[next]=true;
                    dist[next] = dist[cur]+1; //항상 1초가 걸린다//다음위치=현재위치+1초
                    myQue.add(next);
                }
            }

            }
    }
}