
import java.io.*;

public class Main {
    //평범한 배낭 -백준 : 이해하고 외우기
//    여러개의 선택대상이 있고, 전체자원한도내에서 선택조합을 구성하여 최대값/최소값을 구하는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); //물건 개수
        int K = Integer.parseInt(arr[1]); //최대 무게

        int[][] a = new int[N][2]; //무게,가치
        for (int i = 0; i < N; i++) {
            String[] brr = br.readLine().split(" ");
            a[i][0] = Integer.parseInt(brr[0]); // 무게
            a[i][1] = Integer.parseInt(brr[1]); // 가치
        }


        int[]dp =new int[K+1]; //가방의 무게

        for(int i=0; i<a.length; i++){ //자리 확정
//            System.out.println(i+" i값: " + dp[i]);
            for(int j=K; j>=a[i][0]; j--){//무게
//                System.out.println(j+"전: "  + dp[j]);
            dp[j]=Math.max(dp[j],dp[j-a[i][0]]+a[i][1]);//기존값, 새롭게 가산한 값(인덱스에 있던 값+새 값 ex. 4kg 무게 담을 때 가치+ 3kg 가치)

//                System.out.println(j+"후: " + dp[j]);

            }
        }
        bw.write(String.valueOf(dp[K]));
        bw.flush();
    }
}