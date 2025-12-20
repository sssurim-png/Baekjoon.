import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());
        List<int[]> list =new ArrayList<>();


        for(int i= 0; i<N;i++){
            String[] st = br.readLine().split(" ");
            int x =Integer.parseInt(st[0]);
            int y =Integer.parseInt(st[1]);
            list.add(new int[]{x,y});
        }

        Collections.sort(list, new Comparator<int[]>() { //일단 정렬, 0인덱스 순으로, 같으면 1인덱스 크기순으로
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        long answer =0;
        int start = list.get(0)[0];
        int end   = list.get(0)[1];

       for(int i=0; i<list.size()-1;i++) {
           int start0 =list.get(i+1)[0];
           int end1 =list.get(i+1)[1];
           if(start0<=end){
               end= Math.max(end,end1);
           }else{
               answer+=end -start;

               start =start0;
               end=end1;

           }

       }
       bw.write(String.valueOf(answer+=end-start)); //끊어진 이후의 start, end값
       bw.flush();
    }
}



