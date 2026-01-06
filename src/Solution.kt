import kotlin.math.abs

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for (i in nums.indices) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1
            }
        }
        for (i in nums.indices) {
            val num = abs(nums[i])
            if (num <= n) {
                nums[num - 1] = -abs(nums[num - 1])
            }
        }
        for (i in nums.indices) {
            if (nums[i] > 0) {
                return i + 1
            }
        }
        return n + 1
    }
}

fun main() {
    val sl = Solution()
    //test: 3,4,-1,1
    // 1, 2, 0
    // 7,8,9,11,12
    val array = intArrayOf(1, 2, 0)

    print(sl.firstMissingPositive(array))

}