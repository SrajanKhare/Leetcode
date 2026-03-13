char* convert(char* s, int numRows) {
    if (numRows == 1) return s;

    int n = 0;
    while (s[n] != '\0') n++;

    char* res = (char*)malloc((n + 1) * sizeof(char));
    int idx = 0;
    int cycle = 2 * numRows - 2;

    for (int row = 0; row < numRows; row++) {
        for (int j = row; j < n; j += cycle) {
            res[idx++] = s[j];
            int second = j + cycle - 2 * row;
            if (row != 0 && row != numRows - 1 && second < n) {
                res[idx++] = s[second];
            }
        }
    }
    res[idx] = '\0';
    return res;
}
