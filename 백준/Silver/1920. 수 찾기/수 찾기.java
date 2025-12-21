import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr8 = new int[N];
        for (int i = 0; i < N; i++) {
            arr8[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr8);

        int M = Integer.parseInt(br.readLine());

        String[] input2 = br.readLine().split(" ");
        int[] arr9 = new int[M];
        for (int i = 0; i < M; i++) {
            arr9[i] = Integer.parseInt(input2[i]);
        }


        for (int i = 0; i < M; i++) {
            int target = arr9[i];
            int mini = 0;
            int max = arr8.length - 1;
            int result = 0;

            while (mini <= max) {
                int mid = (mini + max) / 2;
                if (arr8[mid] == target) {
                    result = 1;
                    break;
                } else if (arr8[mid] < target) {
                    mini = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
    }} //이진탐색 //No binary함수

