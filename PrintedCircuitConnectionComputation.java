import java.util.*;

public final class PrintedCircuitConnectionComputation
{
    private PrintedCircuitConnectionComputation() {
        throw new AssertionError();
    }
    
    public static String[] compute(final Scanner in, final int env) {
        double pi_E;
        double pi_Q;
        double pi_C;
        double lambda_p;
        double lambda_b = lambda_p = (pi_C = (pi_Q = (pi_E = 0.0)));
        int numConnections = 1;
        int N2 = 0;
        final String[] results = { "\r\n\r\nPRINTED CIRCUIT CONNECTIONS COMPUTATION", null };
        System.out.println("\r\nPRINTED CIRCUIT CONNECTIONS COMPUTATION");
        System.out.print("Enter number of Plated Through Holes:\t");
        try {
            numConnections = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numConnections < 0) {
            ErrHandler.errMethod(in);
        }
        if (numConnections > 0) {
            lambda_b = 4.1E-5;
            System.out.print("Enter number of hand soldered PTHs:\t");
            try {
                N2 = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (N2 < 0) {
                ErrHandler.errMethod(in);
            }
            pi_C = 1.0;
            pi_Q = compute_pi_Q(in, results);
            pi_E = compute_pi_E(in, env, results);
            lambda_p = numConnections * lambda_b * N2 * (13.0 + pi_C) * pi_Q * pi_E;
            final String temp = "\r\n-------------------------\r\nResults:\r\nlambda_b = " + lambda_b + "\r\n" + "pi_C = " + pi_C + "\r\n" + "pi_Q = " + pi_Q + "\r\n" + "pi_E = " + pi_E + "\r\n" + "number of hand soldered PTHs = " + N2 + "\r\n" + "n = " + numConnections + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p + " failures per million hours" + "\r\n" + "**********";
            System.out.println(temp);
            final String[] array = results;
            final int n = 0;
            array[n] = String.valueOf(array[n]) + temp;
            results[1] = new StringBuilder().append(lambda_p).toString();
            return results;
        }
        results[0] = "";
        results[1] = "0";
        return results;
    }
    
    private static double compute_pi_Q(final Scanner in, final String[] results) {
        double pi_Q = 0.0;
        int quality = -1;
        String outString = "\r\nPi_Q Calculation:";
        System.out.println("-------------------------");
        System.out.println("\r\nPi_Q Calculation\r\n");
        System.out.println("\r\n\tQuality types:");
        System.out.println("\t\t1......MIL-SPEC");
        System.out.println("\t\t2......Lower");
        System.out.print("\tEnter quality type choice (1 or 2):\t");
        try {
            quality = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (quality == 1) {
            outString = String.valueOf(outString) + "\r\nQuality: \tMIL-SPEC";
            pi_Q = 1.0;
        }
        else if (quality == 2) {
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
            pi_Q = 2.0;
        }
        else {
            ErrHandler.errMethod(in);
        }
        outString = String.valueOf(outString) + "\r\npi_Q = \t" + pi_Q;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("pi_Q = " + pi_Q);
        return pi_Q;
    }
    
    private static double compute_pi_E(final Scanner in, final int env, final String[] results) {
        double pi_E = 0.0;
        String outString = "\r\n\r\npi_E Calculation: ";
        if (env == 1) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
            pi_E = 1.0;
        }
        else if (env == 2) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_F";
            pi_E = 2.0;
        }
        else if (env == 3) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_M";
            pi_E = 7.0;
        }
        else if (env == 4) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tN_S";
            pi_E = 5.0;
        }
        else if (env == 5) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tN_U";
            pi_E = 13.0;
        }
        else if (env == 6) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IC";
            pi_E = 5.0;
        }
        else if (env == 7) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
            pi_E = 8.0;
        }
        else if (env == 8) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
            pi_E = 16.0;
        }
        else if (env == 9) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
            pi_E = 28.0;
        }
        else if (env == 10) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_RW";
            pi_E = 19.0;
        }
        else if (env == 11) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tS_F";
            pi_E = 0.5;
        }
        else if (env == 12) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_F";
            pi_E = 10.0;
        }
        else if (env == 13) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_L";
            pi_E = 27.0;
        }
        else if (env == 14) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tC_L";
            pi_E = 500.0;
        }
        else {
            ErrHandler.errMethod(in);
        }
        outString = String.valueOf(outString) + "\r\npi_E = \t" + pi_E;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("pi_E = " + pi_E);
        return pi_E;
    }
}
