class Solution {

    public class Pair{
        int i;
        int j;
        int effort;
        Pair(int i,int j,int effort){
            this.i= i;
            this.j = j;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.effort - b.effort;
        });

        pq.add(new Pair(0,0,0));
        boolean[][] vis = new boolean[n][m];

        int[] di  = {-1,0,1,0};
        int[] dj =  {0,-1,0,1};

        while(pq.size()>0){
            Pair curr = pq.remove();

            if(vis[curr.i][curr.j]) continue;
            vis[curr.i][curr.j] = true;

            //work
            if(curr.i == n-1 && curr.j == m-1) return curr.effort;
            //add nbrs
            for(int dir = 0;dir<4;dir++){
                int ni = curr.i+di[dir];
                int nj = curr.j+dj[dir];

                if(ni <0 || nj<0 || ni==n || nj ==m || vis[ni][nj]) continue;
                int absDiff = Math.abs(arr[ni][nj] - arr[curr.i][curr.j]);
                pq.add(new Pair(ni,nj, Math.max( curr.effort , absDiff ) ));

            }

        }
        return -1;

    }
}








