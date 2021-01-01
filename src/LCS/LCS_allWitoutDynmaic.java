package LCS;

public class LCS_allWitoutDynmaic {


    public static String Greedy(String x, String y) {
        String ans = "";

        int start = 0;

        for (int i = 0; i < x.length(); i++) {
            int index = y.indexOf(x.charAt(i), start);
            if (index != -1) {
                ans += x.charAt(i);
                start = index + 1;
            }
        }
        String ans1 = "";
        start = 0;
        for (int i = 0; i < y.length(); i++) {
            int index = x.indexOf(y.charAt(i), start);
            if (index != -1) {
                ans1 += y.charAt(i);
                start = index + 1;
            }
        }

        System.out.println("ans is :" + ans);
        System.out.println("ans1 is :" + ans1);

        if (ans.length() > ans1.length()) {
            return ans;
        }
        return ans1;
    }


    public static String Greedey_m_n(String x, String y) {

        //helper array a,b...
        int[] help = new int[26];
        for (int i = 0; i < y.length(); i++) {
            int place = (y.charAt(i) - 'a');
            help[place]++;
        }

        String ans = "";
        int start = 0;
        for (int i = 0; i < x.length(); i++) {
            int place = (x.charAt(i) - 'a');
            if (help[place] > 0) {
                int index = y.indexOf(x.charAt(i), start);
                if (index != -1) {
                    ans += x.charAt(i);
                    start = index + 1;
                    help[place]--;
                }
            }
        }
        return ans;
    }


    public static void plus1(int bin[]) {
        int size = bin.length - 1;
        while (size >= 0 && bin[size] == 1) bin[size--] = 0;
        if (size >= 0) bin[size] = 1;
    }

    public static String[] allSubstring(String x) {// O(2^M)
        int m = x.length(), count = ((int) (Math.pow(2, m))) - 1;
        String[] list = new String[count];
        int[] bin = new int[m];
        for (int i = 0; i < count; i++) {
            plus1(bin);
            String t = "";
            for (int j = 0; j < m; j++) {
                if (bin[j] == 1)
                    t += x.charAt(j);
            }
            list[i] = t;
        }
        return list;
    }

    public static String exhaustiveSearch(String X, String Y) {
        int m = X.length(), n = Y.length();
        String ans = "";
        int maxLen = 0;
        String sShort = X, sLong = Y;
        if (m > n) {
            sShort = Y;
            sLong = X;
        }
        String tshort[] = allSubstring(sShort);
        String tlong[] = allSubstring(sLong);

        for (int i = 0; i < tshort.length; i++) {//O(2^m)
            for (int j = 0; j < tlong.length; j++) {//O(2^n)
                int len = tshort[i].length();
                if (tshort[i].equals(tlong[j]) && len > maxLen) {//O(m)
                    maxLen = len;
                    ans = tshort[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(Greedy("abcbdab", "bdcaba"));
     //System.out.println(Greedey_m_n("bdfe", "abcabbde"));
      System.out.println(exhaustiveSearch("abcbdab", "bdcaba"));
    }


}
