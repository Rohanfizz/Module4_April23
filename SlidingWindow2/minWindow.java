class Solution {
    public boolean isValid(HashMap<Character,Integer> ht,HashMap<Character,Integer>  hw){
        for(char c: ht.keySet()){
            int idealFreq = ht.get(c);
            if(!hw.containsKey(c) || hw.get(c) < idealFreq) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> ht = new HashMap<>();
        HashMap<Character,Integer> hw = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            ht.put(c,ht.getOrDefault(c,0) + 1);
        }

        int sp = 0;
        int ep = 0;
        String ans = "";
        int ansLen = Integer.MAX_VALUE;

        while(ep<s.length()){
            //introduce the new person in the window
            hw.put( s.charAt(ep) , hw.getOrDefault(s.charAt(ep),0) + 1 );

            //i will try to update the answer and shrink the window if possible
            while(isValid(ht,hw)){
                if(ansLen > ep-sp+1){
                    ans = s.substring(sp,ep+1);
                    ansLen = ep-sp+1;
                }
                hw.put(s.charAt(sp) , hw.get(s.charAt(sp)) - 1);
                sp++;
            }
            ep++;
        }

        return ans;
        


    }
}





