package com.programmer.cracking.coding.answer.chapter1;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 20:10
 * @Description
 */
public class Reverse {

    /*
    请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
    给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。

    测试样例：
    "This is nowcoder"
    返回："redocwon si sihT"
     */

    /**
     * @param iniString
     * @return
     */
    public static String reverseString(String iniString) {
        String[] strings = iniString.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length; i > 0; i--) {
            stringBuilder.append(strings[i - 1]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String iniString = "abc";
        String reverseString = Reverse.reverseString(iniString);
        System.out.println(reverseString);
    }

}
