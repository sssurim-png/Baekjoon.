import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]st =br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]); //M이상

        int[] arr= new int[N];
        for(int i=0; i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); //정렬시켜서 마지막-0번째가 가장 크다 //M이거나 M에 근접하면 갱신시켜서 멈추기

        int start=0;
        int end=0;
        int temp=Integer.MAX_VALUE;

        while(end<N && start<N){

            int differ = arr[end]-arr[start];

           if (differ>=M) {
                temp = Math.min(temp,differ);
                start++;

            }else {
                end++;
            }

        }

        bw.write(String.valueOf(temp));
        bw.flush();
    }

}