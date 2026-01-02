import java.io.*;
import java.util.Arrays;

//이분탐색문제는 이분탐색의대산을 어떤것으로 설정할지가 핵심
//1. 이분탐색의 대상: 상한액
//2. 상한액*모든요청 == 예산총액일 경우만
public class Main {
    //    예산: 백준
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        /// //
        int start = 0;
        int end = arr[arr.length - 1];
        int answer = -1;

        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2; //상한액

            for (int i = 0; i < N; i++) {
                int num = arr[i];
                if (arr[i] > mid) {
                    num = mid;
                    sum += num;
                } else {
                    sum += arr[i];
                } //더한 수
            }

                if (sum == M) { //더한 값과 예산과 같다면
                    answer = mid; //상한액은 이게 맞다
                    break;
                } else if (sum < M) { //더한 값이 예산보다 작다면
                    answer = mid; //상한액 올려서 터질 수 있으니 일단 저장
                    start = mid + 1;//상한액을 올려라 //낮은 것중 가까우면 답이 될 수 있다 //넘기 직전


                } else if (sum > M) {
                    end = mid - 1;//상한액을 낮춰라 //넘어가면 답이 될 수 없다
                }
            }

        bw.write(String.valueOf(answer));
        bw.flush();

        }

    }
