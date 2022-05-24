// Grupa D.Rzeźnik, F.Urban, S.Rejmus

class Project_II {

    static final double EPSILON = 0.0001;
    static final double APROX_VAL = 0.35586;

    static double func(double x) {
        return 0.5 * x * x * x - x + (1 / 3.0);
    }

    static double funcIter(double x) {
        return 0.5 * x * x * x + (1 / 3.0);
    }

    static double derivFunc(double x) {
        return 1.5 * x * x - 1;
    }

    static void iterationsMethod(double x) {
        double h = funcIter(x);
        boolean is_divergent = false; //rozbieżność

        for (int i=0; i<100; i++){
//            System.out.println(h);
            h=funcIter(h);
            if (Math.abs(h-APROX_VAL)<0.00001){
                break;
            }
            if(h==Double.NEGATIVE_INFINITY || h == Double.POSITIVE_INFINITY){
                System.out.println("Funckja w podanym punkcie jest rozbieżna dla Iteracji Prostych");
                is_divergent = true;
                break;
            }
        }
        if (!is_divergent) {
            System.out.println("Iteracje proste: " + h);
        }
    }

    // Function to find the root
    static void Newton(double x) {
        double h = func(x) / derivFunc(x);
        while (Math.abs(h) >= EPSILON) {
            h = func(x) / derivFunc(x);
            // x(i+1) = x(i) - f(x) / f'(x)
            x = x - h;
        }
        System.out.println("Metoda Newtona: " + x);
    }

    public static void main(String[] args) {
        for (double i = -5; i <= 5; i += 0.01) {
            System.out.printf("x\u2080 = %.2f\n" ,i );
            Newton(i);
            iterationsMethod(i);
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}
