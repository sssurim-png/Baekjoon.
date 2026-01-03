import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]); //조카 명수
        int M = Integer.parseInt(st[1]); //개수

        int[] arr= new int[M];
        String[] stt=br.readLine().split(" ");
        for(int i=0; i<M;i++){
            arr[i] =Integer.parseInt(stt[i]);
        }

        Arrays.sort(arr);

        int start=1;
        int end= arr[arr.length-1];
        int answer=0;



        while(start<=end){
            int temp = 0;
            int mid= (start+end)/2; //과자 중간 값
            for(int i =0; i<M; i++){
                    temp+= (arr[i]/mid);//해당 길이에서 줄 수 있는 조카 명수 누적합
            }
            
            if( N<=temp){//목표조카 수 보다 해당 길이를 먹을 수 있는 조카수가 많으면 -> 과자 길이 늘려도 된다
//               //==이상: 3명이 됐어도 2명으로 줄어들지 않는다면 과자 길이를 더 늘려봐도 된다.
                answer=mid;//늘리고 터질 수 있으니 일단 저장
                start=mid+1; //과자 길이를 조정해야된다 
            }
            else{
               end=mid-1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();

    }
}