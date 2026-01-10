import java.io.*;
import java.util.Arrays;

public class Main {

    static boolean visited[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            } //char로 받는걸 못했다
        }




        visited = new boolean[N][N];

        int count =0;
        for (int row = 0; row < N; row++) { //세로
            for (int col = 0; col < N; col++) {//가로
                if(!visited[row][col]) {
                    count++;
                    dfs( row,col);
                }
            }
        }

        for(int i=0; i<N; i++) {
            Arrays.fill(visited[i],false);
        }
        for (int row = 0; row < N; row++) { //세로
            for (int col = 0; col < N; col++) {//가로
                if (arr[row][col] == 'G') {
                    arr[row][col] = 'R';
                } // 변환를 탐색이랑 같이 넣어버렸었다 //char인데 equals로 비료하려했다, ""로 감쌌다
            }
            }

        int count2 =0;
        for (int row = 0; row < N; row++) { //세로
            for (int col = 0; col < N; col++) {//가로
                    if(!visited[row][col]) {
                        count2++;
                        dfs(row,col); //항상 행,열 순//그냥 row,col하는게 안바뀌고 편하다

                    }
                }
            }

        bw.write(String.valueOf(count+" "+count2));
        bw.flush();





    }

    static public void dfs(int row, int col) {

        if (visited[row][col]){
            return;

        }
            visited[row][col] = true;
            for (int k = 0; k < 4; k++) {
                int nc = col + dx[k];
                int nr = row + dy[k];
                if (nc >= 0 && nr >= 0 && nc < arr[0].length && nr < arr.length) {
                    if (!visited[nr][nc] &&arr[nr][nc]==arr[row][col]) { //이동하려는 색이 같은 색인지 확인을 안했다
                        dfs(nr, nc);
                    }
                }

            }
    }
}

//temp + arr[y][x] dfs에서 이게 필요한 경우: 지나온 문자열 or 지나온 것들을 저장하고 담고있어야할때
//visit=단순히 갔다, 횟수 세기, 연겨요소 탐색 등