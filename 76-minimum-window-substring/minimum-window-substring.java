class Solution {
    public String minWindow(String sti, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int l = 0, r = 0;
        int length = Integer.MAX_VALUE; 

        int st = 0;
        int ed = 0; 

        char[] s = sti.toCharArray();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (r < s.length) {
            char cl = s[r];

            if (map.containsKey(cl)) {
                map2.put(cl, map2.getOrDefault(cl, 0) + 1);
            }

            while (mapCompare(map, map2) && l <= r) {
                // 1. Update the best window BEFORE modifying frequency/pointers
                if (length > r - l + 1) {
                    st = l;
                    ed = r;
                    length = r - l + 1;
                }

                // 2. Decrement frequency if the left character is part of target 't'
                if (map.containsKey(s[l])) {
                    map2.put(s[l], map2.get(s[l]) - 1);
                }

                l++;
            }

            r++;
        }

        // 3. Return empty string if no valid window was found
        return length == Integer.MAX_VALUE ? "" : new String(Arrays.copyOfRange(s, st, ed + 1));
    }

    public static boolean mapCompare(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            int val = entry.getValue();
            if (!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()) < val) {
                return false;
            }
        }
        return true;
    }
}