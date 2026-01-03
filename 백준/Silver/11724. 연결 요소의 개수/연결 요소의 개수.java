import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
/// ///////가장 기본적인 dfs틀 (중간에 count세는거 빼고)
public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]st =br.readLine().split(" ");
        int N = Integer.parseInt(st[0]); //정점 수
        int M = Integer.parseInt(st[1]); //간선 수

        visited= new boolean[N+1]; //정점 번호 그대로 쓰려고. visite[0]은 버림

        int[][] node =new int[M][2];
        for(int i=0; i<M;i++){ //간선?
            String[]stt =br.readLine().split(" ");
            node[i][0]= Integer.parseInt(stt[0]);
            node[i][1]= Integer.parseInt(stt[1]);

        }

        for(int i=0; i<=N;i++){ //노드 별 객체만들기
            list.add(new ArrayList<>());
        }

        for(int[]n : node){
            list.get(n[0]).add(n[1]); //양방향 간선
            list.get(n[1]).add(n[0]);
        }

        for(List<Integer>l:list){ //정렬
            l.sort(Comparator.naturalOrder());
        }

        int count=0;

        for(int i =1; i<=N;i++){ //1부터 시작하는 문제라서
            if(!visited[i]){ //새로운 정점(노드)을 시작
                dfs(i);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();

    }

    static void dfs(int start) {

        visited[start] = true;
        for (int a : list.get(start)) {
            if (!visited[a]) { //해당 정점에 연결되어잇는 애들을 체크

                dfs(a);
            }
        }

}
}