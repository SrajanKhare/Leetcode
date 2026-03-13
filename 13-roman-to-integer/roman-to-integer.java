class Solution {
    public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;

        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int val = map[s.charAt(i) - 'A'];
            if (i + 1 < n && val < map[s.charAt(i + 1) - 'A']) {
                res -= val;
            } else {
                res += val;
            }
        }
        return res;
    }
}
