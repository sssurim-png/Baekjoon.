import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");

        int N =Integer.parseInt(st[0]);
        int C =Integer.parseInt(st[1]);
        List<Integer>list =new ArrayList<>();
        for(int i=0; i<N;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int mini=1; //최소거리
        int max = list.get(list.size()-1)-list.get(0); //최대거리


        int answer = 0 ;

        while(mini<=max){
            int mid = (mini+max)/2;
            int count = 1; //1개 설치했다
            int last =list.get(0); //첫번째 값에다가

            for(int i= 0; i<N;i++){ //공유기 먼저 길이별로 설치하기
                if(list.get(i)-last>=mid){
                    count++;
                    last=list.get(i);
                }
            }

            if(count>=C){ //공유기 설치 개수따라 이분
                answer =mid;
                mini=mid+1;
            }else{
                max=mid-1;
            }

        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
