import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());


        int pastW=1;//초기화 (start)
//        double curW =Math.sqrt(pastW*pastW+N);//초기화??
        int curW =2; // max=초반에 터짐//0이되는 경우는 없음 (end)

        List<Integer> list =new ArrayList<>();

        while(pastW<curW){ // 이전몸무게가 현재와 같거나 클 수 없다
           int differ= curW*curW - pastW*pastW; //이걸로 N과 같아지는것을 구해야되는데 조건과 제재를 뭘로 가하느냐//매번 달라진다

            if(differ==N){
                list.add(curW);
                pastW++;
            }else if(differ<N) { //14
                curW++;

            }else{ //differ>N  18
                pastW++;
            }

        }
        Collections.sort(list);

        if(!list.isEmpty()){
            for(int a: list) {
                bw.write(String.valueOf(a) );
                bw.newLine();
            }
        }else{
            bw.write("-1");
        }
        bw.flush();




    }
}