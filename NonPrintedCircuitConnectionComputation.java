import java.util.*;

public final class NonPrintedCircuitConnectionComputation
{
    private NonPrintedCircuitConnectionComputation() {
        throw new AssertionError();
    }
    
    public static String[] compute(final Scanner in, final int env) {
        double pi_E;
        double pi_Q;
        double lambda_b_hand;
        double lambda_p;
        double lambda_b_crimp = lambda_p = (lambda_b_hand = (pi_Q = (pi_E = 0.0)));
        int numCrimped = 0;
        int numHandSoldered = 0;
        final String[] results = { "\r\n\r\nNON-PRINTED CIRCUIT CONNECTIONS COMPUTATION", null };
        System.out.println("\r\nNON-PRINTED CIRCUIT CONNECTIONS COMPUTATION");
        System.out.print("Enter number of hand-soldered connections:\t");
        try {
            numHandSoldered = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numHandSoldered < 0) {
            ErrHandler.errMethod(in);
        }
        System.out.print("Enter number of crimped connections:\t");
        try {
            numCrimped = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numCrimped < 0) {
            ErrHandler.errMethod(in);
        }
        if (numHandSoldered + numCrimped != 0) {
            lambda_b_hand = 1.4E-4;
            lambda_b_crimp = 2.6E-4;
            pi_Q = compute_pi_Q(in, results);
            pi_E = compute_pi_E(in, env, results);
            lambda_p = numCrimped * lambda_b_crimp * pi_Q * pi_E + numHandSoldered * lambda_b_hand * pi_Q * pi_E;
            final String temp = "\r\n-------------------------\r\nResults:\r\nHand Soldered lambda_b = " + lambda_b_hand + "\r\n" + "Crimped lambda_b = " + lambda_b_crimp + "\r\n" + "pi_Q = " + pi_Q + "\r\n" + "pi_E = " + pi_E + "\r\n" + "# of Hand Soldred Connections = " + numHandSoldered + "\r\n" + "# of Crimped Connections = " + numCrimped + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p + " failures per million hours" + "\r\n" + "**********";
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
        System.out.println("\r\n\tManual Crimp Quality:");
        System.out.println("\t\t1......Upper");
        System.out.println("\t\t2......Standard");
        System.out.println("\t\t3......Lower");
        System.out.print("\tEnter quality type choice (1, 2, or 3):\t");
        try {
            quality = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (quality == 1) {
            outString = String.valueOf(outString) + "\r\nQuality: \tUpper";
            pi_Q = 1.0;
        }
        else if (quality == 2) {
            outString = String.valueOf(outString) + "\r\nQuality: \tStandrard";
            pi_Q = 2.0;
        }
        else if (quality == 3) {
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
            pi_Q = 20.0;
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
        String outString = "\r\n\r\npi_E Calculation:";
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
            pi_E = 4.0;
        }
        else if (env == 5) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tN_U";
            pi_E = 11.0;
        }
        else if (env == 6) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IC";
            pi_E = 4.0;
        }
        else if (env == 7) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
            pi_E = 6.0;
        }
        else if (env == 8) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
            pi_E = 6.0;
        }
        else if (env == 9) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
            pi_E = 8.0;
        }
        else if (env == 10) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_RW";
            pi_E = 16.0;
        }
        else if (env == 11) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tS_F";
            pi_E = 0.5;
        }
        else if (env == 12) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_F";
            pi_E = 9.0;
        }
        else if (env == 13) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tM_L";
            pi_E = 24.0;
        }
        else if (env == 14) {
            outString = String.valueOf(outString) + "\r\nEnvironment: \tC_L";
            pi_E = 420.0;
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
