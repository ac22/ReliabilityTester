import java.util.*;

public final class TransformerComputation
{
    private TransformerComputation() {
        throw new AssertionError();
    }
    
    public static String[] compute(final Scanner in, final int env) {
        int numTrans = 1;
        final String[] results = { "\r\n\r\nTRANSFORMERS COMPUTATION", null };
        System.out.println("\r\nTRANSFORMERS COMPUTATION");
        final double lambda_b = compute_lambda_b(in, results);
        final double pi_Q = compute_pi_Q(in, results);
        final double pi_E = compute_pi_E(in, env, results);
        System.out.println(results[0]);
        System.out.print("Enter number of transformers:\t");
        numTrans = in.nextInt();
        final double lambda_p = numTrans * lambda_b * pi_Q * pi_E;
        final String temp = "\r\n-------------------------\r\nResults:\r\nlambda_b = " + lambda_b + "\r\n" + "pi_Q = " + pi_Q + "\r\n" + "pi_E = " + pi_E + "\r\n" + "n = " + numTrans + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p + " failures per million hours" + "\r\n" + "**********";
        System.out.println(temp);
        final String[] array = results;
        final int n = 0;
        array[n] = String.valueOf(array[n]) + temp;
        results[1] = new StringBuilder().append(lambda_p).toString();
        return results;
    }
    
    private static double compute_lambda_b(final Scanner in, final String[] results) {
        String outString = "\r\nLambda_b Calculation:";
        System.out.println("-------------------------");
        System.out.println("\r\nLambda_b Calculation:\r\n");
        System.out.println("\r\n\tMaximum Operating Temperature:");
        System.out.println("\t\t1......130C");
        System.out.println("\t\t2......155C");
        System.out.print("\tEnter maximum temperature designation (1 or 2):\t");
        final int tempDes = in.nextInt();
        System.out.print("\tEnter the hotspot temperature in Celsius: \t");
        final double T = in.nextDouble();
        double lambda_b;
        if (tempDes == 1) {
            outString = String.valueOf(outString) + "\r\nMaximum Operating Temperature: \t130C";
            lambda_b = 0.0018 * Math.exp(Math.pow((T + 273.0) / 364.0, 8.7));
        }
        else {
            if (tempDes != 2) {
                throw new IllegalArgumentException("Invalid selection");
            }
            outString = String.valueOf(outString) + "\r\nMaximum Operating Temperature: \t155C";
            lambda_b = 0.002 * Math.exp(Math.pow((T + 273.0) / 400.0, 10.0));
        }
        outString = String.valueOf(outString) + "\r\nHotspot Temperature: \t" + T + "C";
        outString = String.valueOf(outString) + "\r\nlambda_b = \t" + lambda_b;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("lambda_b = " + lambda_b);
        return lambda_b;
    }
    
    private static double compute_pi_Q(final Scanner in, final String[] results) {
        double pi_Q = 0.0;
        int family = -1;
        int quality = -1;
        String outString = "\r\n\r\npi_Q Calculation:";
        System.out.println("-------------------------");
        System.out.println("\r\nPi_Q Calculation\r\n");
        System.out.println("\r\n\tFamily types:");
        System.out.println("\t\t1......Pulse Transformer");
        System.out.println("\t\t2......RF Transformer");
        System.out.print("\tEnter family type choice (1 or 2):\t");
        family = in.nextInt();
        System.out.println("\r\n\tQuality types:");
        System.out.println("\t\t1......MIL-SPEC");
        System.out.println("\t\t2......Lower");
        System.out.print("\tEnter quality type choice (1 or 2):\t");
        quality = in.nextInt();
        if (family == 1 && quality == 1) {
            outString = String.valueOf(outString) + "\r\nFamily: \tPulse Transformer";
            outString = String.valueOf(outString) + "\r\nQuality: \tMIL-SPEC";
            pi_Q = 1.5;
        }
        else if (family == 1 && quality == 2) {
            outString = String.valueOf(outString) + "\r\nFamily: \tPulse Transformer";
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
            pi_Q = 5.0;
        }
        else if (family == 2 && quality == 1) {
            outString = String.valueOf(outString) + "\r\nFamily: \tRF Transformer";
            outString = String.valueOf(outString) + "\r\nQuality: \tMIL-SPEC";
            pi_Q = 12.0;
        }
        else {
            if (family != 2 || quality != 2) {
                throw new IllegalArgumentException("Invalid selection");
            }
            outString = String.valueOf(outString) + "\r\nFamily: \tRF Transformer";
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
            pi_Q = 30.0;
        }
        outString = String.valueOf(outString) + "\r\npi_Q = \t" + pi_Q;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("pi_Q = " + pi_Q);
        return pi_Q;
    }
    
    private static double compute_pi_E(final Scanner in, final int env, final String[] results) {
        double pi_E = 0.0;
        String outString = "\r\n\r\npi_E Calculation:";
        if (env == 1) {
            pi_E = 1.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
        }
        else if (env == 2) {
            pi_E = 6.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_F";
        }
        else if (env == 3) {
            pi_E = 12.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_M";
        }
        else if (env == 4) {
            pi_E = 5.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tN_S";
        }
        else if (env == 5) {
            pi_E = 16.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tN_U";
        }
        else if (env == 6) {
            pi_E = 6.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IC";
        }
        else if (env == 7) {
            pi_E = 8.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
        }
        else if (env == 8) {
            pi_E = 7.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
        }
        else if (env == 9) {
            pi_E = 9.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
        }
        else if (env == 10) {
            pi_E = 24.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_RW";
        }
        else if (env == 11) {
            pi_E = 0.5;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tS_F";
        }
        else if (env == 12) {
            pi_E = 13.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_F";
        }
        else if (env == 13) {
            pi_E = 34.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_L";
        }
        else {
            if (env != 14) {
                throw new IllegalArgumentException("Invalid selection");
            }
            pi_E = 610.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tC_L";
        }
        outString = String.valueOf(outString) + "\r\npi_E = \t" + pi_E;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("pi_E = " + pi_E);
        return pi_E;
    }
}
