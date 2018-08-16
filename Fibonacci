import java.util.HashMap;

public class Fibonacci {

    private static HashMap<Integer,Long> Fib = new HashMap<>();

    public static long F(int N){
        if(Fib.get(N) != null)
            return Fib.get(N);
        else{
            long f = N == 0 ? 0 : (N == 1 ? 1 : F(N - 1) + F(N - 2));
            Fib.put(N,f);
            return f;
        }

    }

    public static long F_iter(int N){
        if(Fib.get(N) != null){
            return Fib.get(N);
        }
        else {
            long a = 0, b = 1, n = N, temp;
            if (N == 0) return a;
            else if (N == 1) return b;
            else {
                while (n > 1) {
                    temp = a;
                    a = b;
                    b += temp;
                    n--;
                }
            }
            Fib.put(N,b);
            return b;
        }
    }

    private static long F_Ologn_iter(long a,long b,long p,long q,int count){
        if(count == 0) return b;
        else if(count % 2 == 0) return F_Ologn_iter(
                a,
                b,
                p*p + q*q,
                2*p*q + q*q,
                count / 2);
        else return F_Ologn_iter(
                    b*q + a*q + a*p,
                    b*p + a*q,
                    p,
                    q,
                    count-1);
    }

    public static long F_Ologn(int N){
        if(Fib.get(N) != null){
            return Fib.get(N);
        }
        else {
            Long f = F_Ologn_iter(1, 0, 0,1, N);
            Fib.put(N,f);
            return f;
        }

    }



    public static void main(String[] args){
//        long[] a = new long[10];
//        for(int i = 0;i < a.length;i++){
//            a[i] = F(i);
//            StdOut.println(a[i]);
//        }

        F(100);

        for(int i = 0;i < 100;i++){
            System.out.println(Fib.get(i));
        }
    }
}
