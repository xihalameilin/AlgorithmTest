package summer2019;

public class Special {
    int res = 0;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("helo");
        sb.append(1);
        System.out.println(sb.delete(1,sb.length()));
    }

    public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                dp[i+1]=0;
            else
                dp[i+1]=dp[i];
            if(i>0 && (s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<'7')))
                dp[i+1] += dp[i-1];
        }
        return dp[dp.length-1];
    }

    private void help91(String s,int index){
        if(index == s.length()-1){
            res++;
            return;
        }
        else if(index == s.length()-2){
            char c1 = s.charAt(index);
            char c2 = s.charAt(index+1);
            if(c1 > '2'){
                res++;
                return;
            }
            else {
                if(c1 == '2' && c2 > '6'){
                    res++;
                    return;
                }
                else{
                    res = res + 2;
                    return;
                }
            }
        }

        char c = s.charAt(index);
        if(c > '2'){
            help91(s,index+1);
        }
        else {
            char c2 = s.charAt(index+1);
            if(c == '2' && c2 > '6'){
                help91(s,index+1);
            }
            else {
                help91(s,index+1);
                help91(s,index+2);
            }
        }
    }
}
