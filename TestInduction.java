public class TestInduction {
    int count;

    public static void main(String[] args) {
        new TestInduction();
    }

    public TestInduction() {
        /*for (double x = 0; x < 10; x += 0.1) {
            for (int n = 0; n < 10; n++) {
                System.out.format("%f^%d=%f\n", x, n, expIterativ(x, n));
            }
            System.out.println();
        }*/
        for(int n = 0; n < 1000000; n+=5) {
            count = 0;
            //System.out.format("2^%d = %f\n",n,expRekursiv(2,n));
            expRekursiv(2,n);
            System.out.format("%d, %d\n",n,count);
        }
    }

    double expIterativ(double x, int n) {
        double res = 1.0;

        for (int i = 0; i < n; i++) {
            res *= x;
        }
        count += 1;
        return res;
    }

    double expRekursiv(double x, int n) {
        if (n <= 4) {
            double res = expIterativ(x, n);
            //System.out.format("%f^%d=%f\n", x, n, res);
            return res;
        }
        
        double res = expRekursiv(x, n / 2) * expRekursiv(x, (n + 1) / 2);
        count+= 1;
        return res;
    }
}