import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int N= Integer.parseInt(st[0]);
        int M= Integer.parseInt(st[1]);

        String[] stt = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(stt[i]);
        }
        Arrays.sort(arr);

        int mini=0;
        int max=0;
        for(int i:arr){ //사실 정렬해서 max값 안찾고 arr[N - 1]; 해도 된다...
            if(i>max){
                max=i;
            }
        }
        int mid;
        int answer=0; //이상일 때 값 저장할려고



        while(mini<=max) {
            mid =(max+mini)/2; //매번 다른값으로 갱신되니까 여기서 초기화. 밖에 있으면 돌아올때 첫번째값으로만 나온다.
            long value = 0; //얘도 밖에 있으면 매번 처음값으로 초기화된다

            for(int i= 0; i<N;i++) {
                if (arr[i] > mid) {
                    value += arr[i] - mid;
                }
            } //톱 길이마다의 나무값 계산 로직
            if (value >= M) {
                answer=mid;
                mini = mid + 1; //결과가 M보다 크거나 같으면 시작값을 mid+1, if mid+1했을 때 value<M일 수 있으니 그전 값 저장
            } else {
                max = mid - 1; //아닐경우 끝 값 mid-1로 줄임
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();


    }
}
