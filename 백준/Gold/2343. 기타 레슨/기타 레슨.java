import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] st =br.readLine().split(" ");
        int N =Integer.parseInt(st[0]);
        int M =Integer.parseInt(st[1]);

        int[] arr = new int[N];
        String[] stt =br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] =Integer.parseInt(stt[i]);
        }//입력 끝

        int sh =0;
        for(int i=0; i<N; i++) {
            sh= Math.max(sh,arr[i]);
        }
        int shorts =sh;
        //1이 안되는 이유: arr[i]원소 값 자체가 mid보다 커지는 문제를 여기서 처리해야한다
        // 때문에 원소값 중 원소 자체의 최대값이 최소값으로 잡혀야한다

        int longssum =0;
        for(int i=0; i<N; i++){
            longssum+=arr[i];
        }
        int longs =longssum;



        int temp=0;

        while(shorts<=longs){
            int mid =(shorts+longs)/2;
            int differ= mid;
            int blue=1;
            for(int i=0; i<N; i++) {
                if(mid>=arr[i]){
                    if (differ<arr[i]){
                        blue++;
                        differ=mid;
                    }
                    differ-=arr[i];
                }
                //blue가 0일수는 없다 arr[i]자체가 mid보다 크다면 그 문제를 해결할 것
            }

            if(blue<=M){
                temp=mid;
                longs=mid-1;
            }else{
                shorts=mid+1;
            }

            }
        bw.write(String.valueOf(temp));
        bw.flush();


    }
}
