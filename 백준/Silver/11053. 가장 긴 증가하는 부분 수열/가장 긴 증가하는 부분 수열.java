
import java.io.*;

public class Main {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N= Integer.parseInt(br.readLine());

    String[] arr = br.readLine().split(" ");
    int[] a = new int[N];
    for(int i=0; i<N;i++){  //받아온 값
        a[i]= Integer.parseInt(arr[i]);

    }

    int[] dp =new int[N];
//    dp식: max(dp[n-1],dp[n-2]...) 중에 arr[n]보다 작은 dp값 +1

    for(int i=0; i<N;i++){ //초기화
        dp[i]=1;
    }

    for(int i=1; i<N; i++){
        for(int j=0; j<i; j++){
            if(a[i]>a[j]){
                dp[i]=Math.max(dp[i],dp[j]+1);
           }

        }
    }
    int max =0;
    for(int b: dp){
        if(b>max){
            max=b;
        }
    }
    System.out.println(max);


}
}
