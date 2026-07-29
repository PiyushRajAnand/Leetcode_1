class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int complement = k - num;
            if (seen.containsKey(complement) && seen.get(complement) > 0) {
                count++;
                seen.put(complement, seen.get(complement) - 1);
            } else {
                seen.put(num, seen.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
}