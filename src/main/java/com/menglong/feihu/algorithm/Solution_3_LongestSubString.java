package com.menglong.feihu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-22 : 16:05
 */
public class Solution_3_LongestSubString {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) {
            return 0;
        }
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int start =0,end =0;end < n;end++) {
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
