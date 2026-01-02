

import java.io.*;
import java.util.Arrays;

//정렬이 필요한 경우
//start<end의 조건 //작거나 같으면 안된다 =>한수가 되어버린다
//start가 0부터 시작. end가 length-1부터 시작
public class Main {
    //    두 수의 합: 백준 골드문제로 잘못갔다;;
//    두용액(2470) :백준
//    수 고르기 (2230):백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr =new int[n];
        String[] st= br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st[i]);
        }

        int x = Integer.parseInt(br.readLine()); //target

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length-1;
        int count=0;


        while(start<end){
            int sum =arr[start]+arr[end];
            if(sum==x){
                count++;
                start++;

            }else if(sum<x){
                start++;

            }else if(sum>x){
                end--;
            }

        }
        bw.write(String.valueOf(count));
        bw.flush();


    }
}

