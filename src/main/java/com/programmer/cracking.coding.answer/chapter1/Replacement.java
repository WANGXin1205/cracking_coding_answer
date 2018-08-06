package com.programmer.cracking.coding.answer.chapter1;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 21:01
 * @Description
 */
public class Replacement {

    /*
    请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
    并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
    给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。

    测试样例：
    "Mr John Smith”,13
     返回："Mr%20John%20Smith"
     ”Hello  World”,12
     返回：”Hello%20%20World”
     */

    /**
     * @param iniString
     * @param length
     * @return
     */
    public static String replaceSpace(String iniString, int length) {
        String joinString = "%20";
        return iniString.replace(" ", joinString);
    }

    public static void main(String[] args) {
        String string = "Mr John Smith";
        String replaceString = Replacement.replaceSpace(string,13);
        System.out.println(replaceString);
        string = "Hello  World";
        replaceString = Replacement.replaceSpace(string,12);
        System.out.println(replaceString);
    }

}
