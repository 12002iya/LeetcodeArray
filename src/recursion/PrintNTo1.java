package recursion;

public class PrintNTo1 {

    public static void main(String[] args) {


        int n = 5;
        int i=1;

        fun(i, n);

    }

    private static void fun(int i, int n) {

        if(i>n){
            return;
        }
        fun(i+1,n);
        System.out.println(i);

    }
}
