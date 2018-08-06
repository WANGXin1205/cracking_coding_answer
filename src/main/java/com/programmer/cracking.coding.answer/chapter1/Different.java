package com.programmer.cracking.coding.answer.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 19:14
 * @Description
 */
public class Different {

    /*
    请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
    给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
    保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。

     测试样例：
       "aeiou"
       返回：True
       "BarackObama"
       返回：False
     */

    /**
     * @param iniString
     * @return
     */
    public static boolean checkDifferent(String iniString) {
        String[] strings = iniString.split("");
        List<String> stringList = new ArrayList<>();
        for (String x : strings) {
            if (!stringList.contains(x)) {
                stringList.add(x);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String string = "aeiou";
        Boolean flag = Different.checkDifferent(string);
        System.out.println(flag);
        string = "aabbccdd";
        flag = Different.checkDifferent(string);
        System.out.println(flag);
    }

}
