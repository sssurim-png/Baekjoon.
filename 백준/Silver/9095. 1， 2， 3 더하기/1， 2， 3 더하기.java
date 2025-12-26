import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());
        int max=0;
        int[] arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            if(arr[i]>max){
                max=arr[i];
            }
        }



        int[] dp = new int[max+1];
        dp[0]=1;
        if(max>=1) {
            dp[1]=1;
        }
        if(max>=2) {
            dp[2]=2;
        }
        if(max>=3) {
            dp[3]=4;
        }
        for(int i=4; i<=max;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }



        for(int i=0; i<N;i++) {
            bw.write(String.valueOf(dp[arr[i]])); //dp[i] =그냥 1,2,3번째들어가는 것 그거를 구하는 값// arr[i]1,2,3에 1,4,7번째라는 값을 가지고 있다
        bw.newLine();
        }
        bw.flush();


    }
}
