import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Main {

    static boolean[][] visited;
    static int[][] arr;

    static int count;

    static int N;
    static BufferedWriter bw;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
                if (arr[i][j] == 1) {

                }
            }
        }
        visited = new boolean[N][N];
        int maincount =0;
        List<Integer> counts= new ArrayList<>(); //정점 노드에 연결된 개수를 따로 세기 위해서 
        for (int i = 0; i < N; i++) { //세로 먼저
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) { //새롭게 시작하는 곳
                    count=0; //초기화
                    dfs(i, j);
                    maincount++; //연결노드 개수
                    counts.add(count);//호출 끝날때마다 값에 넣어주기
                }
            }
        }
        bw.write(String.valueOf(maincount));
        bw.newLine();
        Collections.sort(counts);
        for(int a : counts){
            bw.write(String.valueOf(a));
            bw.newLine();
        }
        bw.flush();



    }

    static void dfs(int y, int x) {
        visited[y][x] = true; //오자마자 정점노드는 방문처리
         count++; //해당 정점에 연결되어있는 개수들
        for (int a = 0; a < 4; a++) {
            int nx = dx[a] + x;
            int ny = dy[a] + y;
            if(nx>=0 && ny>=0 && nx<N &&ny<N) {
                if (arr[ny][nx] == 1 && !visited[ny][nx]) { //갈 수 있는 곳이 두 방향이라도, 끝까지 갔다가visit처리 안된곳으로 바로 점프해서 넘어감
//                    visited[y][x] = true; //여기 들어오려면 매서드 호출전에도 써줘야함
                    dfs(ny, nx);
                }

            }
        }
    }
}