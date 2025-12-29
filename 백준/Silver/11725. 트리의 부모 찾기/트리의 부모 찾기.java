import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list=new ArrayList<>();
    static boolean[] visited;
    static  int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<N-1;i++){
            String[]arr = br.readLine().split(" ");
            int a =Integer.parseInt(arr[0]);
            int b =Integer.parseInt(arr[1]);

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(List<Integer> l : list){
            l.sort(Comparator.naturalOrder());
        }

        visited =new boolean[N+1];
        parent =new int[N+1];

        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(1);
        visited[1] =true;

        while(!myQue.isEmpty()){
            int temp =myQue.poll();

            for(int i: list.get(temp)){
                if(!visited[i]){
                    parent[i]=temp;
                    myQue.add(i);
                    visited[i]=true;
                }
            }
        }
        for(int i=2;i<=N;i++) {
            bw.write(String.valueOf(parent[i])); //배열의 '원소'=toString안쓴다
            bw.newLine();
        }

        bw.flush();



    }
}
