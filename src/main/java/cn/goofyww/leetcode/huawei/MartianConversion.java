package cn.goofyww.leetcode.huawei;

import java.security.InvalidAlgorithmParameterException;
import java.util.*;

/**
 * 火星计算转换
 * x$y = 3 * x + y + 2
 * x#y = 2 * x + 3 * y + 4
 * 根据输入的火星算法，进行计算
 * example:
 * 7#6$5#12 = 226
 */
public class MartianConversion {

    public static void main(String[] args) throws InvalidAlgorithmParameterException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        // 先计算 $
        int size = chars.length;
        for (int i = 0; i < size; i++) {
            if ('$' == chars[i]) {
                if (0 == i) throw new InvalidAlgorithmParameterException();
                int z = 0;
                int k = 0;
                for (int x = i - 1; x >= 0; x--) {
                    if (chars[x] == '$' || chars[x] == '#') {
                        String subStr = str.substring(x + 1, i);
                        if (null == subStr || subStr.length() < 1) {

                        } else {
                            z = Integer.parseInt(subStr);
                        }
                        break;
                    } else {
                        if (0 == x) {
                            z = Integer.parseInt(str.substring(0, i));
                        }
                    }
                }

                for (int y = i + 1; y < size; y++) {
                    if (chars[y] == '$' || chars[y] == '#') {
                        String subStr = str.substring(i + 1, y);
                        if (null == subStr || subStr.length() < 1) {

                        } else {
                            k = Integer.parseInt(subStr);
                        }
                        break;
                    } else {
                        if (size - 1 == y) {
                            k = Integer.parseInt(str.substring(i + 1, y + 1));
                        }
                    }
                }
                str = str.replace(z + "$" + k, String.valueOf(t1(z, k)));
                chars = str.toCharArray();
                size = chars.length;
            }
        }

        System.out.println(Arrays.toString(chars));

        // 再计算 #
        for (int i = 0; i < size; i++) {
            if ('#' == chars[i]) {
                if (0 == i) throw new InvalidAlgorithmParameterException();

                int z = 0;
                int k = 0;
                for (int x = i - 1; x >= 0; x--) {
                    if (chars[x] == '$' || chars[x] == '#') {
                        String subStr = str.substring(x + 1, i);
                        if (null == subStr || subStr.length() < 1) {

                        } else {
                            z = Integer.parseInt(subStr);
                        }
                        break;
                    } else {
                        if (0 == x) {
                            z = Integer.parseInt(str.substring(0, i));
                        }
                    }
                }

                for (int y = i + 1; y < size; y++) {
                    if (chars[y] == '$' || chars[y] == '#') {
                        String subStr = str.substring(i + 1, y);
                        if (null == subStr || subStr.length() < 1) {

                        } else {
                            k = Integer.parseInt(subStr);
                        }
                        break;
                    } else {
                        if (size - 1 == y) {
                            k = Integer.parseInt(str.substring(i + 1, y + 1));
                        }
                    }
                }
                str = str.replace(z + "#" + k, String.valueOf(t2(z, k)));
                chars = str.toCharArray();
                size = chars.length;
            }
        }

        System.out.println(new String(chars));
    }

    /**
     * x$y = 3 * x + y + 2
     */
    public static int t1(int x, int y) {
        return 3 * x + y + 2;
    }

    /**
     * x#y = 2 * x + 3 * y + 4
     */
    public static int t2(int x, int y) {
        // 7, #, 2, 5, #, 1, 2
        return 2 * x + 3 * y + 4;
    }

}
