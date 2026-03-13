bool isMatch(char* s, char* p) {
    int m = 0, n = 0;
    while (s[m] != '\0') m++;
    while (p[n] != '\0') n++;

    bool** dp = (bool**)malloc((m + 1) * sizeof(bool*));
    for (int i = 0; i <= m; i++)
        dp[i] = (bool*)calloc(n + 1, sizeof(bool));

    dp[0][0] = true;

    // patterns like a*, a*b*, a*b*c* can match empty string
    for (int j = 2; j <= n; j++) {
        if (p[j - 1] == '*')
            dp[0][j] = dp[0][j - 2];
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (p[j - 1] == '*') {
                dp[i][j] = dp[i][j - 2]; // zero occurrence
                if (p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]; // one or more
                }
            } else {
                dp[i][j] = false;
            }
        }
    }

    bool ans = dp[m][n];
    for (int i = 0; i <= m; i++) free(dp[i]);
    free(dp);
    return ans;
}
