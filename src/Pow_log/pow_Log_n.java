package Pow_log;

public class pow_Log_n {

    static int pow_log ( int a , int b , int ans ) {

        if ( b == 0 ) return ans;

        if ( b % 2 == 1 )
            ans *=a;

        b/=2;
        a*=a;
        return pow_log(a,b,ans);

    }

    public static void main(String[] args) {

        System.out.println(pow_log(7,11,1));


    }

    }
