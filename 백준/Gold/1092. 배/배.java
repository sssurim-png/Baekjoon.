import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] st = br.readLine().split(" ");
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }//크레인 무게 제한 값

        int M = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        String[] stt = br.readLine().split(" ");
        int[] brr = new int[M];
        for (int i = 0; i < M; i++) {
            brr[i] = Integer.parseInt(stt[i]);
            list.add(brr[i]);
        }//박스 무게 값

        Arrays.sort(arr, Collections.reverseOrder()); //얘만 Integer 처리\
        Collections.sort(list,Collections.reverseOrder());

        int count =0;



        while(!list.isEmpty()){

            if(arr[0]<list.get(0)){
                bw.write("-1");
                bw.flush();
                return;
            }

            for( int i=0; i<N;i++){
                if(list.isEmpty()){
                    break;
                }

               for( int j =0; j<list.size();j++){
                   if(arr[i]>=list.get(j)){
                       list.remove(j);
                       break; //해당박스 할당량 끝
                   }
                }

            }
            count++;
            



        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
