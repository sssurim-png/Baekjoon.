import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        List<List<Integer>> list1 = new ArrayList<>();

        combi( 1, M, N, list1, new ArrayList<>());

        for(List <Integer> a : list1){
            for(int b : a){
                bw.write(String.valueOf(b)+" ");
            }
            bw.newLine();
        }
        bw.flush();

    }

    public static void combi( int start,int m, int n, List<List<Integer>> list1, List<Integer> temp) {

        if (temp.size() == m) {
            list1.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {

            temp.add(i);

            combi( i, m, n, list1, temp);
            temp.remove(temp.size() - 1);


        }
    }
    }