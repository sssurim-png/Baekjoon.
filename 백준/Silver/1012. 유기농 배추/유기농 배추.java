import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};//아래/위(행)  => 세로= x(밑으로 내려갈때 +)
    static int[] dy = {0, 0, -1, 1};//오른쪽/ 왼쪽(열)  => 가로=y(왼쪽으로 갈때 +)
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스

        while (T-- > 0){

            String[] st = br.readLine().split(" ");
        int M = Integer.parseInt(st[0]); //가로 //y // 행
        int N = Integer.parseInt(st[1]); //세로 //x // 열
        int K = Integer.parseInt(st[2]); //배추 심은 위치


        visited = new boolean[N][M]; //행,열 //세로,가로
        arr = new int[N][M]; //배추의 위치
        for (int i = 0; i < K; i++) {// 배추 위치 1로 표시
            String[] stt = br.readLine().split(" ");
            int x = Integer.parseInt(stt[0]);
            int y = Integer.parseInt(stt[1]);
            arr[y][x] = 1;//arr[row][col]
        }
//        y → 몇 번째 가로줄(row) 인지
//        x → 그 줄의 몇 번째 세로칸(column) 인지


        int count = 0;

        for (int i = 0; i < N; i++) { //세로가 먼저 // 세로=x(밑으로 내려갈때 +), 가로=y(왼쪽으로 갈때 +)
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) { // 갈 수 있는 길인지 && 방문한 길이지 확인
                    dfs(i, j, N, M);
                    count++; //새로운 길을 갈때마다 카운트
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
    }
        bw.flush();
    }

    static void dfs(int y, int x, int n, int m) { //종료조건이 이미 조건문 안에 들어가있어서 따로 종료 로직 없다
//        재귀를 못하는 시점이 곧 종료
        visited[y][x] = true; //행,열

        for (int a = 0; a < 4; a++) { //네방향으로 움직임
            int nx = x + dx[a];
            int ny = y + dy[a];
            if (nx >= 0 && ny >= 0 && ny < n && nx < m) { 
                if (arr[ny][nx] == 1 && !visited[ny][nx]) { //1인것 && 방문하지 않은 것(마지막 유효 인덱스가 n-1이다)
                    dfs(ny, nx, n, m);
                }
            }
        }
    }
}

