import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] arr =new int[N];
        String[] st= br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] =Integer.parseInt(st[i]);
        }

        Arrays.sort(arr);


        int start=0;
        int end = arr.length-1;
        int absmin=Integer.MAX_VALUE;

        int [] v= new int[2];
        v[0]=0;
        v[1]=0;

        while(start<end){
            int sum =arr[start]+arr[end];

            if(Math.abs(sum)<absmin){
                absmin=Math.abs(sum);
                v[0]=arr[start];
                v[1]=arr[end];
            }

            if(sum==0){
                v[0]=arr[start];
                v[1]=arr[end];
                break;

            }else if(sum>0){
                end--;

            }else if(sum<0){
                start++;
            }
        }

        Arrays.sort(v);

        for(int q : v){

            bw.write(q+" ");
        }
        
        bw.flush();

    }
}
