int lengthOfLongestSubstring(char* s) {
    int last[128];
    for (int i = 0; i < 128; i++) last[i] = -1;

    int start = 0, maxLen = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        unsigned char c = s[i];
        if (last[c] >= start) {
            start = last[c] + 1;
        }
        last[c] = i;
        int len = i - start + 1;
        if (len > maxLen) maxLen = len;
    }
    return maxLen;
}
