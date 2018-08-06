package com.programmer.cracking.coding.answer.chapter1;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 23:22
 * @Description
 */
public class ReverseEqual {

    /*
    假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，
    给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。

    给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。

    测试样例：
    "Hello world","worldhello "
    返回：false
    "waterbottle","erbottlewat"
    返回：true
     */
    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkReverseEqual(String s1, String s2) {
        String string = s1 + s1;
        String anotherString = s2 +s2;
        if (string.contains(s2) && anotherString.contains(s1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "Helloworld";
        String s2 = "worldhello";
        Boolean flag = ReverseEqual.checkReverseEqual(s1,s2);
        System.out.println(flag);
        s1 = "waterbottle";
        s2 = "erbottlewat";
        flag = ReverseEqual.checkReverseEqual(s1,s2);
        System.out.println(flag);
    }

}
