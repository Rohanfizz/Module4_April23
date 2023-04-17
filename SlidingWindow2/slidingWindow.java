class Solution {

    public void addToDq(LinkedList<Integer> dq,int[] nums,int i){
        while(dq.size()>0 && nums[dq.getLast()] < nums[i])  dq.removeLast();
        dq.addLast(i);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n  = nums.length;
        int[] ans = new int[n-k+1];
        //we are ensuring that the index of the max value for a window comes to the front of the dq
        LinkedList<Integer> dq = new  LinkedList<>();
        for(int i = 0;i<k;i++){
            addToDq(dq,nums,i);
        }
        ans[0] = nums[dq.getFirst()];

        int sp = 1;
        int ep = k;
        int window = 1;
        while(ep<n){
            addToDq(dq,nums,ep);

            //i will try to remove all the extra people who are not in my window and are present on the first place in dq
            while(dq.getFirst() < sp) dq.removeFirst();
            //on this line of code, we are sure that the person who is standing in the front is actually present in my window
            ans[window] = nums[dq.getFirst()];
            window++;

            sp++;
            ep++;
        }
        return ans;
    }
}










