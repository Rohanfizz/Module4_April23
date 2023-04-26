import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	public class Node{
		char data;
		int freq;
		Node  left;
		Node  right;
		Node(char c,int freq){
			this.data = c;
			this.freq = freq;
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
		// TC: O(nlogn)
		// SC: O(n)
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
			return a.freq < b.freq?-1:1;
		});

		for(int i = 0;i<N;i++){
			pq.add(new Node(S.charAt(i),f[i]));
		}

		while(pq.size()>1){
			Node n1 = pq.remove();//lesser because popped first
			Node n2 = pq.remove();
			
			Node me = new Node('*',n1.freq+n2.freq);
			me.left = n1;//assign lesser freq node to left
			me.right = n2;//more freq node to right

			pq.add(me);
		}
		Node root = pq.peek();//here we have root of the huffman tree
		
		ArrayList<String> ans  = new ArrayList<>();
		dfs(root,ans,"");
		return ans;
    }
    public static void dfs(Node root,ArrayList<String> ans,String  psf){
		
		if(root.left == null && root.right == null){
			//im on a leaf node OR im on a valid character node
			ans.add(psf);
			return;
		}
		dfs(root.left,ans,psf+"0");
		dfs(root.right,ans,psf+"1");
	}
}















