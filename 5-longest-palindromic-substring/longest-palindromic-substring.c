char* longestPalindrome(char* s) {
    int n = 0;
    while (s[n] != '\0') n++;
    if (n < 2) return s;

    int start = 0, maxLen = 1;

    for (int center = 0; center < n; center++) {
        // odd length
        int l = center, r = center;
        while (l >= 0 && r < n && s[l] == s[r]) {
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            l--; r++;
        }
        // even length
        l = center; r = center + 1;
        while (l >= 0 && r < n && s[l] == s[r]) {
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            l--; r++;
        }
    }

    char* res = (char*)malloc((maxLen + 1) * sizeof(char));
    for (int i = 0; i < maxLen; i++) res[i] = s[start + i];
    res[maxLen] = '\0';
    return res;
}
