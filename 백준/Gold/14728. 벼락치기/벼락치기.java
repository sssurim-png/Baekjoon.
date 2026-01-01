import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]); //단원 개수
        int T = Integer.parseInt(st[1]); //쓸 수 있는 시간

        int [][] a = new int[N][2]; // 인덱스 0,1,2 // 50,100,200
        for(int i=0; i<N; i++) {
            String[] stt = br.readLine().split(" ");
            a[i][0]= Integer.parseInt(stt[0]);
            a[i][1]= Integer.parseInt(stt[1]);
            }

        int [] timeDp =new int[T+1];//ex. 311개 만들어서 310를 인덱스로 접근 할 수 있도록


        for(int i=0; i<a.length;i++){// 몇번째를 볼건지 확정, 단원
            for( int j =T; j>=a[i][0]; j--){ // 시간
                timeDp[j]=Math.max(timeDp[j],timeDp[j-a[i][0]]+a[i][1]); //311번째 인덱스, 즉 310시간 = 311번째 인덱스의 값과,, 261번의 인덱스(260)의 값(아직0)+ a[50]의 값(40)중 큰값으로 결정
            }

        }
        bw.write(String.valueOf(timeDp[T]));
        bw.flush();


    }
}
