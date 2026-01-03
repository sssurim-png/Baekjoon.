import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[]st =br.readLine().split(" ");
        int N= Integer.parseInt(st[0]); //심사대 개수
        int M= Integer.parseInt(st[1]); //대기 사람명수

        int[] arr =new int[N];
        for(int i=0; i< N; i++){
            arr[i]=Integer.parseInt(br.readLine()); //실제 값
        }

        Arrays.sort(arr);

        long start=1; //값
        long end =(long) M*arr[arr.length-1]; //값넣으려고 // 최대값 인원수의 *제일 큰값
        long answer=0; //int 사용해서 반례있었다... long사용...

        while(start<=end){
            long mid = (start+end)/2; // 중간 초 수
            long total =0;
            for(int i=0;i<N;i++){ //심사대 수만큼 돈다
                total +=mid/arr[i]; //샤갈 왜 이걸 생각못했지(구현을 못함) //mid시간동안 심사할 수 있는 인원 수
                if(total>=M) {
                break;
                }
            }
            if(total>=M){ //초 수를  더 줄여도 된다 //같을 때도 더 줄일 수 있다
                answer=mid; // 터지기전에 저장
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();


    }
    }
