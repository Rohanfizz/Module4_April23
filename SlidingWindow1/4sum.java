class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        //we are avoiding duplicate cases by ensuring that whenever we;ll move a pointer that pointer points to a new number, in case we are having duplicate numbes in the array.
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;

        int i = 0;
        while(i<n){
            int j = i+1;
            while(j<n){
                //problem is reduced to two sum on the remaining target
                int l = j+1; //remaining array will start at j+
                int r = n-1; //last index in array
                long newTarget =(long) ((long)target - (long)(arr[i] + arr[j]));

                while(l < r){
                    long currSum = (long)((long)arr[l] + (long)arr[r]);
                    if(currSum == newTarget){//newTarget is the target we are searching for in the remaing array
                        List<Integer> currQuad = new ArrayList<>();
                        currQuad.add(arr[i]);
                        currQuad.add(arr[j]);
                        currQuad.add(arr[l]);
                        currQuad.add(arr[r]);
                        ans.add(currQuad);
                        
                        //this ensures that l comes to a new number in the array
                        
                        int prevL = arr[l];
                        while(l<r && arr[l] == prevL) l++;

                        int prevR = arr[r];
                        while(r>l && arr[r] == prevR) r--;
                    }else if(currSum < newTarget){

                        int prevL = arr[l];
                        while(l<r && arr[l] == prevL) l++;

                    }else{

                        int prevR = arr[r];
                        while(r>l && arr[r] == prevR) r--;

                    }
                }
                int prevJ = arr[j];
                while(j<n && arr[j]== prevJ) j++;
            }
            int prevI = arr[i];
            while(i<n && arr[i] == prevI) i++;
        }
        return ans;
    }
}





