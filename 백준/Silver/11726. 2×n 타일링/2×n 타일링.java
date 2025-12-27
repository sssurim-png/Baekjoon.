import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
//        dp[1] = 1;
//        dp[2] = 2; //이렇게 하면 N=1일때 dp[2]까지 돌면서 오류가 여기서 터진다//없는 값을 찾고 있는 것

        if(N>=1){
            dp[1] = 1;
        }
        if(N>=2){
            dp[2] =2;
        }//숫자 3, 즉 인덱스(N=2)부터 시작하기 때문에 N에 0,1등이 들어오면 오류난다// if없이 넣으면, 위처럼 오류

        for(int i=3; i<=N; i++){


            dp[i] = (dp[i-1]+dp[i-2])%10007; //결과값에서 나누면 int범위가 벗어나있다 //자료형을 바꾸던지 여기서 나누던지
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();

    }
}
