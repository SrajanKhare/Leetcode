int max(int a, int b) { return a > b ? a : b; }
int min(int a, int b) { return a < b ? a : b; }

double findMedianSortedArrays(int* nums1, int n1, int* nums2, int n2) {
    if (n1 > n2) return findMedianSortedArrays(nums2, n2, nums1, n1);

    int totalLeft = (n1 + n2 + 1) / 2;
    int lo = 0, hi = n1;

    while (lo <= hi) {
        int i = (lo + hi) / 2;
        int j = totalLeft - i;

        int nums1Left  = (i == 0) ? -1000000001 : nums1[i - 1];
        int nums1Right = (i == n1) ?  1000000001 : nums1[i];
        int nums2Left  = (j == 0) ? -1000000001 : nums2[j - 1];
        int nums2Right = (j == n2) ?  1000000001 : nums2[j];

        if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
            if ((n1 + n2) % 2 == 1)
                return (double)max(nums1Left, nums2Left);
            else
                return (max(nums1Left, nums2Left) + min(nums1Right, nums2Right)) / 2.0;
        } else if (nums1Left > nums2Right) {
            hi = i - 1;
        } else {
            lo = i + 1;
        }
    }
    return 0.0; // should not reach
}
