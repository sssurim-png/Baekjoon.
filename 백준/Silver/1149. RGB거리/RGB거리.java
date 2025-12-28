import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];


        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp =new int[N][3];
        for(int j = 0; j<3; j++){
            dp[0][j] =cost[0][j];
        } //첫번째 집//rgb뭐쓸건지 선택 아직 안한거

        for(int i =1; i <N; i++){ //두번째집이라서 1시작
            for(int j =0; j<3; j++){ //색 돌림
                int min = Integer.MAX_VALUE; //최소화 비교를 위해 제일 큰 값으로 초기화

                for(int k=0; k<3;k++){ //이전 집의 색
                    if(j==k) continue; //j==k: 현재집(i)과 이전 집(i-1)색 같아진다=> pass
                    min =Math.min(min,dp[i-1][k]); //j =현재색, k = 현재색을 제외하고 이전집에 넣어보는 색의 최소비용 비교

                }
                dp[i][j]=min +cost[i][j];
            }
        }

        int answer =Math.min(dp[N-1][0],Math.min (dp[N-1][1],dp[N-1][2]));
        bw.write(String.valueOf(answer));
        bw.flush();

    }
}
