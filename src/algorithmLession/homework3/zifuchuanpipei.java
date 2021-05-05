package algorithmLession.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zifuchuanpipei {
  private static final int NOT_FOUND_NUM = -1;

  private static final int HAYSTACK_INDEX = 0;
  private static final int NEEDLE_INDEX = 1;


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < t; i++) {
      String line = scanner.nextLine();
      String[] strings = line.split(",");
      String haystack = strings[HAYSTACK_INDEX];
      String needle = strings[NEEDLE_INDEX];
      List<Integer> list = Sunday(haystack, needle);
      print(list);
    }
  }

  public static void print(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (int integer : list) {
      sb.append(integer);
      sb.append(" ");
    }
    if (sb.length() == 0) {
      System.out.println();
      return;
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());
  }

  public static List<Integer> Sunday(String haystack, String needle) {
    List<Integer> list = new ArrayList<>();
    int res = Sunday(haystack, needle, 0);
    while (res != NOT_FOUND_NUM) {
      list.add(res);
      res = Sunday(haystack, needle, res + 1);
    }
    return list;
  }

  public static int Sunday(String haystack, String needle, int begin) {
    int hayLen = haystack.length();
    int nLen = needle.length();

    //haystack串的游标索引
    int i = begin;
    // needle串的游标索引
    int j = 0;

    // haystack剩余字符少于needle串时跳过比较
    while (i <= hayLen - nLen) {
      // 将needle串与haystack串中参与比较的子串进行逐个字符比对
      while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
        j++;
      }

      // 如果j等于needle串的长度说明此时匹配成功，可以直接返回此时主串的游标索引
      if (j == nLen) {
        return i;
      }

      // 不匹配时计算需要跳过的字符数，移动主串游标i
      if (i < hayLen - nLen) {
        // 对照字符在needle串存在，则需要跳过的字符数为从对照字符在needle串中最后出现的位置起剩余的字符个数
        // 不存在则跳过的字符数为needle串长度+1，也就是代码nLen-(-1)的情况
        i += (nLen - lastIndex(needle, haystack.charAt(i + nLen)));
      } else {
        return NOT_FOUND_NUM;
      }
      // 每次比较之后将needle游标置为0
      j = 0;
    }

    return NOT_FOUND_NUM;
  }

  public static int lastIndex(String str, char ch) {
    // 从后往前检索
    for (int j = str.length() - 1; j >= 0; j--) {
      if (str.charAt(j) == ch) {
        return j;
      }
    }
    return -1;
  }
}
