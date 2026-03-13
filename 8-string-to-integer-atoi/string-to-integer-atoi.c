int myAtoi(char* s) {
    int i = 0;
    while (s[i] == ' ') i++;

    int sign = 1;
    if (s[i] == '+' || s[i] == '-') {
        if (s[i] == '-') sign = -1;
        i++;
    }

    long long val = 0;
    while (s[i] >= '0' && s[i] <= '9') {
        int d = s[i] - '0';
        val = val * 10 + d;
        if (sign == 1 && val > 2147483647) return 2147483647;
        if (sign == -1 && -val < -2147483648LL) return -2147483648;
        i++;
    }
    return (int)(sign * val);
}
