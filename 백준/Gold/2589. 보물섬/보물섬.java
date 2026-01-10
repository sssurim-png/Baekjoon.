import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;
    static int dx[]= {1,-1,0,0};
    static int dy[]= {0,0,1,-1};
    static  char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]st =br.readLine().split(" ");
        int N = Integer.parseInt(st[0]); //세로 row
        int M = Integer.parseInt(st[1]); //가로 col


        arr= new char[N][M];
        for(int i=0; i<N; i++){//토마토는 한번에 여러군데에서 시작해서 arr받으면서 여러개 대입한것
            String line = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = line.charAt(j);
                }
            }

        int answer = 0;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[N][M];
                    Queue<int[]> q = new LinkedList<>();//돌때마다 초기화 해줘야된다 visit가 남아있으면 안된다

                    q.add(new int[]{i, j, 0}); //row, col,dist
                    visited[i][j] = true;



                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int row = cur[0];
                        int col = cur[1];
                        int dist = cur[2];//받는거 순서대로

                        answer = Math.max(answer, dist);

                        for (int k = 0; k < 4; k++) {
                            int nr = dy[k] + row;
                            int nc = dx[k] + col;

                            if (nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[0].length) {
                                if (!visited[nr][nc] && arr[nr][nc] == 'L') {
                                    visited[nr][nc] = true; //visit처리를 안함
                                    q.add(new int[]{nr, nc, dist + 1});// 토마토만 보고 따라하다가 dist+1만해주고 나머지를 안넣음
                                }
                            }
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}

