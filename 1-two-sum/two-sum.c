// Adjust capacity if needed (should be >= 2 * numsSize)
typedef struct {
    int key;
    int val;
    int used;
} Pair;

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int capacity = numsSize * 2 + 1;
    Pair* map = (Pair*)calloc(capacity, sizeof(Pair));

    for (int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];
        int h = (complement % capacity + capacity) % capacity;

        // Find complement
        while (map[h].used) {
            if (map[h].key == complement) {
                int* res = (int*)malloc(2 * sizeof(int));
                res[0] = map[h].val;
                res[1] = i;
                *returnSize = 2;
                free(map);
                return res;
            }
            h = (h + 1) % capacity;
        }

        // Insert current
        int h2 = (nums[i] % capacity + capacity) % capacity;
        while (map[h2].used) h2 = (h2 + 1) % capacity;
        map[h2].used = 1;
        map[h2].key = nums[i];
        map[h2].val = i;
    }

    *returnSize = 0;
    free(map);
    return NULL;
}

