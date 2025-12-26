import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        List<Integer> myList = new ArrayList<>();
        for(int i=1;i<=N;i++){
            myList.add(i);

        }
        List<List<Integer>> DList =new ArrayList<>();
        permu(M,myList,DList,new ArrayList<>(),0);

        for(List<Integer> a: DList){
            for(int i =0; i<a.size();i++){
                bw.write(a.get(i)+" ");
            }
            bw.newLine();
        }
bw.flush();

    }
    public static void permu(int n, List<Integer>myList,
            List<List<Integer>>DList,List<Integer>temp,int start){
        if(temp.size()==n){
            DList.add(new ArrayList<>(temp));
            return;
        }
        for(int i= start; i <myList.size(); i++){

            temp.add(myList.get(i));
            permu(n,myList,DList,temp, i+1);
            temp.remove(temp.size()-1);
        }

    }

}
