import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<List<Object>> list =new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] st = br.readLine().split(" ");
            int age =Integer.parseInt(st[0]);

            List<Object> person =new ArrayList<>();
            person.add(age);

            for(int j=1; j<st.length; j++){
            person.add(st[j]);
        }
            list.add(person);
    }

        Collections.sort(list, new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> o1, List<Object> o2) {
                int age1 = (int) o1.get(0);
                int age2 = (int) o2.get(0);
                if (age1 == age2) {
                    return 0;
                } else {
                    return age1 - age2;
                }
            }
        });
        for(List<Object>person : list){
            bw.write(person.get(0)+ " "+person.get(1));
            bw.newLine();
        }
        bw.flush();
        }
    }

