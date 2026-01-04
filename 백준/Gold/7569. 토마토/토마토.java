import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    //    static boolean[][][] visited; arr방문해서 값 바꾸는 것 자체가 visit라 안쓴다
    static int arr[][][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int M = Integer.parseInt(st[0]); //가로
        int N = Integer.parseInt(st[1]); //세로
        int H = Integer.parseInt(st[2]); //상자수(높이)

        //값 받아옴과 동시에 Q 삽입 및 표시
        boolean zero = false;

        arr = new int[H][N][M];
        Queue<int[]> myQue = new LinkedList<>(); //h,x,y 담아야함
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                String[] stt = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[h][i][j] = Integer.parseInt(stt[j]);
                    if (arr[h][i][j] == 1) {
                        myQue.add(new int[]{h, i, j}); //이걸 입력 받으면서 q에 넣어버리네;
                    }
                    if (arr[h][i][j] == 0) {
                        zero = true;
                    }
                }
            }
        }
        //전부 0인 상황
        if (myQue.isEmpty() && zero) { //시작점이 없다는 것이 1.1로 다 차있음 2.다 -1. 이렇게 두가지 이기 때문에 boolean체크 해줘야한다
            bw.write("-1");
            bw.flush();
            return;
        }//시작부터 다 -1 시작 자체가 불가능하다

        //1로 변환 시키는 핵심 로직
        while (!myQue.isEmpty()) {
            int[] cur = myQue.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];

            for (int d = 0; d < 6; d++) {
                int nz = dz[d] + z;
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < H && nx < N && ny < M) { //범위 설정
                    if (arr[nz][nx][ny] == 0) { //0이라면
                        arr[nz][nx][ny] = arr[z][x][y] + 1; //1로 변환 시켜준다 //이때부터 arr= 날짜,상태를 겸한다
                        myQue.add(new int[]{nz, nx, ny}); //새 객체로 q에 넣어줌 //1로 채워가는 것
                    }//for을 도는 동안 한칸이내로 갈 수 있는것은 다 1로 변환(상태, 날짜)// 그다음에 +1 또 가증(날짜) (+상태는 또0->1로 변환)
                }
            }
        }
        //결과값 구하는 로직
        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[h][i][j] == 0) {
                        bw.write("-1"); //다 돌고 났는데도 안익은 토마토(익을 수 없는 토마토)가 있을 경우 "-1"
                        bw.flush();
                        return;
                    }
                    max = Math.max(max, arr[h][i][j]);
                }


            }
        }
        bw.write(String.valueOf(max - 1)); //상태와 날짜를 겸하고 있음 1부터 시작하는 것으로 초기화 했었다
        bw.flush();
    }
}