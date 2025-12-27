import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;//항상 가능한 경우이고 if와 같거나 더 오래걸림 //때문에 간헐적으로 되는 if에서 값을 비교

            if (i % 2 == 0) {
                dp[i]=Math.min(dp[i], dp[i / 2] + 1); //어차피 나눠놓은 값 있으니까
            }
            if (i % 3 == 0) {
                dp[i]=Math.min(dp[i], dp[i / 3] + 1); // ex. dp[9]= dp[3]+1 // dp[3]=1값 이미 구해져 있다
            }

        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();

    }
}
