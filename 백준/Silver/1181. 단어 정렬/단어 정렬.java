import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String> list =new ArrayList<>();
        for(int i= 0; i<N; i++){
            String a= br.readLine();
            list.add(a);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return o1.length()-o2.length();
                }
            }
        });


        String sdf = null;
        for(String b : list){
            if(!b.equals(sdf)){
                bw.write(b);
                bw.newLine();
                sdf=b;
            }
        }
        bw.flush();

        //길이 짧은 것 길이대로 정렬
        //길이 같으면 사전순
        //중복없이
}
}

