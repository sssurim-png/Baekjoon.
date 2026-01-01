import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st= br.readLine().split(" ");
        int C = Integer.parseInt(st[0]);
        int N = Integer.parseInt(st[1]);

        int[][]a = new int[N][2];
        for(int i=0; i<N; i++){ //비용에 따른 유치가능 사람 수받기
            String[]stt =br.readLine().split(" ");
            a[i][0] = Integer.parseInt(stt[0]);
            a[i][1] = Integer.parseInt(stt[1]);
        }

        int[] dpPerson = new int[C+101]; //최대 탐색 사람 수의 인덱스(ex. 12명 113개의 인덱스 - 11명까지는 +1해서 최소값, 12명 부터는 인원이 넘어도 최소인 값)
//       cost에 인원수가 C미만인경우+다른 것 더해서 최소가 되는 경우, cost에 인원수C이상일 경우 앞보다 비용이 적은경우

        for(int i =0; i<dpPerson.length; i++){
            dpPerson[i]= Integer.MAX_VALUE;
        } //사람 전체C+101이거 초기화
        dpPerson[0]=0; //시작값  //안해놓으면 아래 dpPerson[0]+a[i][0]가 될 때 오버플로우 //시작은 할 수 있도록 // 오버플로우 1.

        for(int i= 0; i<a.length; i++){ //실제 차고 있는 인원수 위치(ex. 5,1) (index [i][1]번에 위치
            for(int j =a[i][1]; j<dpPerson.length; j++){ //인원수를 채워가며 최소값을 찾을 것
                if(dpPerson[j-a[i][1]]!=Integer.MAX_VALUE){ //ex.dpPerson[1]+a[i][0]가 될 때 오버플로우.
                    // 아직Max로 남아있는 것은 검사x. 갱신 된것 들만 값있는 것들로만 갱신 //어차피 dpPerson[1]로 cost갱신못한다 처음에는(5전) //오버플로우 2.
//
                dpPerson[j]= Math.min(dpPerson[j], dpPerson[j-a[i][1]]+a[i][0]); //ex.12명이상의 최소값을 찾을 때, 5명이 들어오면 112까지 5의 배수로 cost가 얼마가 드는지 기록
            }
}
        }




        int ans= Integer.MAX_VALUE;
        for(int i=C; i< dpPerson.length; i++){
            ans= Math.min(ans, dpPerson[i]);
        }
        bw.write(String.valueOf(ans));
        bw.flush();

    }
}