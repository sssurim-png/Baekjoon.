import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int arr[][];
    static Set<String> set =new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }
        for (int i = 0; i < 5; i++) {//세로 ==arr.length
            for (int j = 0; j < 5; j++) { //가로 ==arr[0].length
                    dfs(i, j,"");

            }

        }
        bw.write(String.valueOf(set.size()));
//        bw.write(String.valueOf(set)); //안에 있는 배열도 출력
        bw.flush();
    }

    static void  dfs(int y, int x,String temp){ //이러면 x에 세로, y에 가로가들어간다
        if(temp.length()==6){
            set.add(temp);
            return;
        }

        for(int a=0; a<4; a++){
            int nx= dx[a] +x;
            int ny= dy[a] +y;
            if(nx>=0 && ny>=0 && ny<arr.length && nx<arr[0].length){ //y 세로(행), x가로(열_=)
                dfs(ny,nx,temp+arr[ny][nx]); //행(세로),열(가로)
                
            }
        }

    }
}