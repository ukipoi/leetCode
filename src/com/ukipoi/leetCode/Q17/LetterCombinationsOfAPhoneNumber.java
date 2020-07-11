package com.ukipoi.leetCode.Q17;

import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String str = "24794756";
        System.out.println(letterCombinations(str));
    }

    /*
        在递归时，对于临时的字符串
     */

    /**
     * 电话号码的字母组合
     *
     * @param digits 传入的数字字符串
     * @return 所有的字符组合结果
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        List<String> list = new ArrayList<>();
        list.add("!@#");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
        List<String> allGetStr = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(c));
            if (i < 2 || i > 9) {
                return result;
            }
            allGetStr.add(list.get(i - 1));
        }
        a(result, new StringBuffer(), allGetStr);
        return result;
    }

    /**
     * 创建树状结构来得到接过
     *
     * @param list    储存最终结果的数组
     * @param s       需要储存的字符串对象
     * @param strings 剩余的添加字符对象
     */
    public static void a(List<String> list, StringBuffer s, List<String> strings) {
        if (strings.size() > 0) {
            String str = strings.get(0);
            for (char c : str.toCharArray()) {
                StringBuffer s_copy = new StringBuffer();
                //在递归过程中，不需要新建一个字符串对象，只需要在递归后把刚刚添加的字符取消就行了。
                //这样就不用建立很对对象来占用内存空间。因为递归在把一个结果完成之前不会走其他分支。
                s_copy.append(s);
                s_copy.append(c);
                List<String> string_copy = new ArrayList<>(strings);
                //这里可以在递归中额外传递一个参数，来表示当前数字的进度。
                string_copy.remove(0);
                a(list, s_copy, string_copy);
            }
        } else {
            //list可以使用全局变量，不过个人感觉影响不大。
            list.add(s.toString());
        }
    }
}
