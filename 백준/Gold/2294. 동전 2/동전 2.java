import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//다시 봐야함
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]); //동전 개수
        int k = Integer.parseInt(st[1]); //목표 값

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp =new int[k+1]; //1원부터 시작해서 +1로 인덱스와 맞추기, 1만해도 k번이면 맞추니까 k+1이 최대값
        //동전의 개수가 최소가 되도록
        //불가능할 시 -1
        Arrays.fill(dp,-1);
        dp[0] =0;

        for(int i=1; i<=k;i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i - arr[j] >= 0 && dp[i - arr[j]] != -1) {//빼는 값이 음수가 되지 않고, 목표값(i)이 나올 수 있는가? 
                                                               //애초에 목표값 전단계가 즉 i에서 arr값을 뺀 값, 전 값은 나올 수 있었는가?
                    min = Math.min(min, dp[i - arr[j]]); //갱신
                }

            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;

            }
        }
   bw.write(String.valueOf(dp[k]));
        bw.flush();

        }

    }

