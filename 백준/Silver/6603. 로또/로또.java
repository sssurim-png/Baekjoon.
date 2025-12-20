import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] st = br.readLine().split(" ");
            int k = Integer.parseInt(st[0]);

            if (k == 0) {
                break;
            }
            
            
            List<Integer> myList = new ArrayList<>();
            for (int i = 0; i < k; i++) { //값 받으면서 바로 add
                myList.add(Integer.parseInt(st[i + 1]));
            }

            List<List<Integer>> double1 =new ArrayList<>();
            combi(myList, 6, new ArrayList<>(), 0, double1);
            for(List<Integer> list : double1){
                for(int i : list){ //i=원소 (인덱스x)
                    bw.write(i+" ");

                }
                bw.newLine();// 케이스내 줄 띄기
            }
            bw.newLine();//케이스마다 줄 띄기
        }
        bw.flush();
    }

    public static void combi(List<Integer> myList, int n, List<Integer> temp, int start, List<List<Integer>>double1) {
        if (temp.size() == n) {
            double1.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combi(myList, n, temp, i + 1, double1);
            temp.remove(temp.size() - 1);

        }
    }
}



