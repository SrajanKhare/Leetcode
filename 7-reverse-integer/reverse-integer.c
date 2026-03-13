int reverse(int x) {
    long long rev = 0;
    while (x != 0) {
        int d = x % 10;
        rev = rev * 10 + d;
        if (rev > 2147483647 || rev < -2147483648) return 0;
        x /= 10;
    }
    return (int)rev;
}
