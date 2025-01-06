class First_NonRepeating_Character {
    public int firstUniqChar(String s) {
        // int arr[] = new int[26];

        // for (int i = 0; i<s.length(); i++) {
        //     int idx = s.charAt(i)-'a';
        //     arr[idx]++;
        // }

        // for (int i = 0; i<s.length(); i++) {
        //     int idx = s.charAt(i)-'a';
        //     if (arr[idx] == 1) {
        //         return i;
        //     }
        // }

        // return -1;

        int ans = Integer.MAX_VALUE;

        for (char c = 'a'; c<='z'; c++) {
            int idx = s.indexOf(c);
            if(idx!=-1 && idx == s.lastIndexOf(c)) {
                ans = Math.min(ans, idx);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}