import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =Integer.parseInt(br.readLine());


        List<int[]>list =new ArrayList<>();
        for(int i=0 ;i<N; i++ ){
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]); //a개
            int[] b = new int[a+1];//가치
            for (int j = 0; j <= a; j++) {
                if (j == 0) {
                    b[j]= a;
                }
                b[j] = Integer.parseInt(st[j]);
            }
            list.add(b);
//            for(int[] w: list ) {
//                System.out.println(Arrays.toString(w));
//            }
        } 
        //list안에 있는 int[] 의 원소 검색





        PriorityQueue<Integer> pq =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //0을 만나면 pq에담겨 있던거 뱉기
        //p
        for(int i=0 ;i<N; i++){
           if(list.get(i).length==1){
               if(pq.isEmpty()){
                   bw.write("-1");
                   bw.newLine();
               }else {
                   bw.write(String.valueOf(pq.poll()));
                   bw.newLine();

               }


            }else if(list.get(i).length>1){
               for(int j=1; j<list.get(i).length; j++){

                   pq.add(list.get(i)[j]);

               }

           }
        }
        bw.flush();

    }
}
