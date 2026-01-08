import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String[]st =br.readLine().split(" ");
        int n= Integer.parseInt(st[0]);
        int k= Integer.parseInt(st[1]);

        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        //입력끗

        int[] dp = new int[k+1]; //인덱스==값
        dp[0]=1; //고르지 않는경우

        for(int i=0; i<n; i++){//중복x -> 동전개수먼저
            for(int j =arr[i]; j<=k; j++){ //목표값까지
                dp[j]= dp[j]+dp[j-arr[i]]; //현재값 dp[j] = 이전까지 저장되있던 dp[j]값+현재 dp[j]값의 이전값
            }
        }
        bw.write(String.valueOf(dp[k]));
        bw.flush();

    }

}
