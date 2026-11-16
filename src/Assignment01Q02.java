public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        String input = args[0];
        int n = Integer.parseInt(input);
        if (n == 0) {
            System.out.println(0.0 + " " + actualPi);
            return;
        } 
        int numSummands = n - 1;
        double sum = 1;
        int sign = 0;
        double start_val = 3;
        for (int i = 0; i < numSummands; i++) {
            if (sign == 0) {
                sum = sum - (1.0 / (start_val + 2.0 * i));
                sign = 1;
            } else {
                sum = sum + (1.0 / (start_val + 2.0 * i));
                sign = 0;
            }
        }
        approxPi = 4 * sum;
        System.out.println(approxPi + " " + actualPi);
    }
}
