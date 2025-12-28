import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>>graph = new ArrayList<>();

    static  boolean[] visited;

    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[]arr =br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        visited =new boolean[N+1];

        for(int i =0; i<=N;i++){
            graph.add(new ArrayList<>());
        } //0버리고 6개 만들되 어차피 1부터 5까지 인덱스 번호에 맞게 값이 들어간다


        for(int i=0; i<M;i++) {

            String[] brr = br.readLine().split(" ");
            int a = Integer.parseInt(brr[0]);
            int b = Integer.parseInt(brr[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

            for(int i =1; i<= N; i++){ //실
                Collections.sort(graph.get(i));
        }
            dfs(V);
            bw.newLine();
        Arrays.fill(visited,false);
            bfs(V);
            bw.flush();

    }

    static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node + " ");
        for(int next: graph.get(node)){
            if(!visited[next]){
                dfs(next);
            }
        }

    }

    static void bfs(int start) throws IOException {
        Deque<Integer> dq = new ArrayDeque<>();

        visited[start] =true;
        dq.offerLast(start);

        while(!dq.isEmpty()){
            int node= dq.pollFirst();

        bw.write(node +" ");
        for( int next : graph.get(node)){
            if(!visited[next]){
                visited[next]=true;
                dq.offerLast(next);
            }
        }

        }


    }


}
