package meituan.t5;

public class Test {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if((c >= 'a' && c <= 'z')){
                sb.append(c);
            }
            else if((c >= 'A' && c <= 'Z')){
                sb.append((char)(c - 'A' + 'a'));
            }
        }
        int i = 0;
        int j = sb.length() - 1;
        while(i < j){
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }
}
