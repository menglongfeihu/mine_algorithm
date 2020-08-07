package com.menglong.feihu.algorithm;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianzeng
 * @version 1.0
 * @date 2020-06-22 : 15:27
 */
public class Solution_6_StrToZ {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     */
    public String convetToZ(String s, int numRows) {
        if (s==null || s.length()< 0 || numRows < 2) {
            return s;
        }
        List<StringBuilder> rowResults = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rowResults.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rowResults.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rowResults){
            res.append(row);
        }

        return res.toString();
    }
}
