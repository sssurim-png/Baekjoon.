import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> list =new ArrayList<>();
    static boolean[] visited;
    static int answer=0;

    public int solution(int k, int[][] dungeons) {
       
        visited =new boolean[dungeons.length];


        dfs(k,dungeons,0);
        return answer;

    }
    static void dfs(int k, int[][] dungeons,int count){

        answer=Math.max(answer,count);

        for(int i=0;i< dungeons.length; i++){
            if(k>=dungeons[i][0] && !visited[i]){
                visited[i]=true;
                dfs(k- dungeons[i][1],dungeons,count+1);
                visited[i]=false;

            }
            }
        }

    }