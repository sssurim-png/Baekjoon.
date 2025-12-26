import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        int[]arr =new int [N];
        String[] stt = br.readLine().split(" ");
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(stt[i]);
        }

        List<List<Integer>> list2 =new ArrayList<>();
        combi(new boolean[arr.length], M,new ArrayList<>(),arr,list2);




list2.sort(new Comparator<List<Integer>>() {
    @Override
    public int compare(List<Integer> a, List<Integer> b) {

        for(int i =0; i<a.size(); i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i)-b.get(i);
            }

        }
        return 0;
    }
});

        for(List<Integer> a : list2){
            for(int b : a){
                bw.write(String.valueOf(b)+" ");
            }
            bw.newLine();
        }
        bw.flush();



    }

    public static void combi(boolean[] visit, int m, List<Integer> temp,int[] arr, List<List<Integer>> list2){
        if(temp.size()==m){
            list2.add(new ArrayList<>(temp));
            return;
        }

        for(int i =0; i<arr.length; i++){
            if(visit[i]) continue;
            temp.add(arr[i]);
            visit[i] =true;
            combi(visit,m,temp,arr, list2);
            temp.remove(temp.size()-1);
            visit[i]=false;

        }
    }


}
