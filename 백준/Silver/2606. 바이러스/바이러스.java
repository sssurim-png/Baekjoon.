import java.io.*;
import java.util.ArrayList;
import java.util.List;

//dfs

public class Main {

    static List<List<Integer>> list =new ArrayList<>();
    static boolean[] visited;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());
        int M= Integer.parseInt(br.readLine());

        int[][] arr = new int[M][2];
        for(int i=0; i<M; i++){
            String[]st = br.readLine().split(" ");
            arr[i][0] =Integer.parseInt(st[0]);
            arr[i][1] =Integer.parseInt(st[1]);
        }

        int [] n= new int[N+1];
        for(int i=0; i<=N; i++){ //노드 객체 만들기
            list.add( new ArrayList<>());
        }

        for(int i=0; i<arr.length; i++){ //간선 연결
            int a =arr[i][0];
            int b =arr[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited= new boolean[N+1];


        dfs(1);

        bw.write(String.valueOf(count));
        bw.flush();
        }

        static void dfs(int start){
        visited[start] = true;
        for (int i=0; i<list.get(start).size();i++){
            int target = list.get(start).get(i);
            if(!visited[target]){ //정점 노드에서 새로운  노드를 들어갈 때마다
                count++;
                dfs(target);
            }

        }



        }

    }

