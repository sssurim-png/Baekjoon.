import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> list =new ArrayList<>();
    static boolean[] visited;
    static int count;
    static BufferedWriter bw;
    static int depth=0;
    static boolean found =false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);


        for (int i = 0; i < N; i++) {//숫자가 N-1까지 매겨져 있다
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { //간선 받으면서 연결(친구관계)
            String[] sttt = br.readLine().split(" ");
            int a = Integer.parseInt(sttt[0]);
            int b = Integer.parseInt(sttt[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[N];

        loop:
        for(int i=0; i<N;i++){ //시작 지점이 없어 모든 곳 시작
            if (found) break ;
            dfs(i,0);
        }//depth가 5이상있는게 있는지 알아내기

        if(found==false){
            bw.write("0");
        }
        bw.flush();
    }

        static void dfs(int i, int depth) throws IOException {
        if(found) return;
        if(depth>=4){
            found =true;
           bw.write("1");
            return;
        }
        visited[i]=true;

        for(int target: list.get(i)){
            if(!visited[target]){
                dfs(target,depth+1);
                if (found) return;
            }
            }
        visited[i]=false;
        }

    }

