

//정렬을 하면 안되는 경우
//start<=end // 두수가 아니니까
//start 와 end가 같이 출발

import java.io.*;

//=>합이 15가 되는 수열의 범위 {7,8,9,2,4,5,1,3,6}
//합==target count++; end++;
//합<target end++; //전체값 커지는 것
//합>target start ++; //전체값 줄어드는  것
public class Main {
//    수들의 합2(2003)
//    연속된부분수열의 합 -프로그래머스
//    이중 for문으로 완탐 = n제곱
//    복잡도 n으로 가능//정렬x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ar = br.readLine().split(" ");
        int N = Integer.parseInt(ar[0]);
        int target = Integer.parseInt(ar[1]);

        int[] arr= new int[N];
        String[] brr = br.readLine().split(" ");
        for(int i= 0; i<N;i++){
            arr[i]=Integer.parseInt(brr[i]);
        }

        int start= 0;
        int end= 0;
        int count =0;
        int sum=arr[start];

        while(end<arr.length){
            if(sum==target) {
                count++;

                sum-= arr[start];
                start++;

            }else if(sum>target) { //start 가 더 커지면 수열이 아니다
                sum -= arr[start]; //sum-start;
                start++;

//

            }else if(sum<target){
                end++;
                if(end==arr.length){
                    break;
                }
                sum+= arr[end];
            }
        }
        System.out.println(count);

    }
}