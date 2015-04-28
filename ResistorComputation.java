import java.util.*;

public final class ResistorComputation
{
    private ResistorComputation() {
        throw new AssertionError();
    }
    
    public static String[] compute(final Scanner in, final int env, final double ambTemp) {
        int numRes = 1;
        final String[] results = { "\r\n\r\nRESISTORS COMPUTATION", null };
        System.out.println("\r\nRESISTORS COMPUTATION");
        final double lambda_b = compute_lambda_b(in, ambTemp, results);
        final double pi_R = compute_pi_R(in, results);
        final double pi_Q = compute_pi_Q(in, results);
        final double pi_E = compute_pi_E(in, env, results);
        System.out.print("Enter number of resistors:\t");
        try {
            numRes = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numRes <= 0) {
            ErrHandler.errMethod(in);
        }
        final double lambda_p = numRes * lambda_b * pi_R * pi_Q * pi_E;
        final String temp = "\r\n-------------------------\r\nResults:\r\nlambda_b = " + lambda_b + "\r\n" + "pi_R = " + pi_R + "\r\n" + "pi_Q = " + pi_Q + "\r\n" + "pi_E = " + pi_E + "\r\n" + "n = " + numRes + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p + " failures per million hours\r\n" + "**********";
        System.out.println(temp);
        final String[] array = results;
        final int n = 0;
        array[n] = String.valueOf(array[n]) + temp;
        results[1] = new StringBuilder().append(lambda_p).toString();
        return results;
    }
    
    private static double compute_lambda_b(final Scanner in, final double ambTemp, final String[] results) {
        double S = 0.0;
        System.out.println("-------------------------");
        System.out.println("Lambda_b Calculation:\r\n");
        System.out.print("\tEnter the stress (Ratio of operating power to rated power): \t");
        try {
            S = in.nextDouble();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (S <= 0.0 || S > 1.0) {
            ErrHandler.errMethod(in);
        }
        final double lambda_b = 0.00148 * Math.exp(Math.pow((ambTemp + 273.0) / 298.0, 2.0)) * Math.exp(S / 0.5 * (ambTemp + 273.0) / 273.0);
        System.out.println("lambda_b = " + lambda_b);
        String outString = "\r\nLambda_b Calculation:";
        outString = String.valueOf(outString) + "\r\nAmbient Temperature: \t" + ambTemp;
        outString = String.valueOf(outString) + "\r\nStress Ratio: \t" + S;
        outString = String.valueOf(outString) + "\r\nLambda_b =\t" + lambda_b;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        return lambda_b;
    }
    
    private static double compute_pi_R(final Scanner in, final String[] results) {
        double pi_R = 0.0;
        int rwr_type = 0;
        int res_range = 0;
        String outString = "\r\n\r\nPi_R Calculation:";
        System.out.println("-------------------------");
        System.out.println("\r\nPi_R Calculation:\r\n");
        System.out.println("\r\n\tResistor types:");
        System.out.println("\t\t1......RWR80");
        System.out.println("\t\t2......RWR81");
        System.out.print("\tEnter resitor type (1 or 2):\t");
        try {
            rwr_type = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (rwr_type < 1 || rwr_type > 2) {
            ErrHandler.errMethod(in);
        }
        if (rwr_type == 1) {
            outString = String.valueOf(outString) + "\r\nResistor Type: \tRWR80";
            System.out.println("\r\n\tResistance ranges for RWR80:");
            System.out.println("\t\t1......<500 Ohms");
            System.out.println("\t\t2......>500 Ohms to 1K Ohms");
            System.out.println("\t\t3......>1K Ohms to 7.5K Ohms");
            System.out.print("\tEnter resistance choice (1, 2, or 3):\t");
            try {
                res_range = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (res_range == 1) {
                outString = String.valueOf(outString) + "\r\nResistance Range: \t<500 Ohms";
                pi_R = 1.0;
            }
            else if (res_range == 2) {
                outString = String.valueOf(outString) + "\r\nResistance Range: \t>500 Ohms to 1K Ohms";
                pi_R = 1.2;
            }
            else if (res_range == 3) {
                outString = String.valueOf(outString) + "\r\nResistance Range: \t>1K Ohms to 7.5K Ohms";
                pi_R = 1.6;
            }
            else {
                ErrHandler.errMethod(in);
            }
        }
        else if (rwr_type == 2) {
            outString = String.valueOf(outString) + "\r\nResistor Type: \tRWR81";
            System.out.println("\r\n\tResistance ranges for RWR81:");
            System.out.println("\t\t1......<500 Ohms");
            System.out.println("\t\t2......>500 Ohms to 1K Ohms");
            System.out.print("\tEnter resistance choice (1 or 2):\t");
            try {
                res_range = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (res_range == 1) {
                outString = String.valueOf(outString) + "\r\nResistance Range: \t<500 Ohms";
                pi_R = 1.0;
            }
            else if (res_range == 2) {
                outString = String.valueOf(outString) + "\r\nResistance Range: \t>500 Ohms to 1K Ohms";
                pi_R = 1.6;
            }
            else {
                ErrHandler.errMethod(in);
            }
        }
        System.out.println("pi_R = " + pi_R);
        outString = String.valueOf(outString) + "\r\npi_R = \t" + pi_R;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        return pi_R;
    }
    
    private static double compute_pi_Q(final Scanner in, final String[] results) {
        double pi_Q = 0.0;
        String outString = "\r\n\r\nPi_Q Calculation:";
        int quality = -1;
        System.out.println("-------------------------");
        System.out.println("\r\nPi_Q Calculation\r\n");
        System.out.println("\r\n\tQuality types:");
        System.out.println("\t\t1......S");
        System.out.println("\t\t2......R");
        System.out.println("\t\t3......P");
        System.out.println("\t\t4......M");
        System.out.println("\t\t5......MIL-R-26");
        System.out.println("\t\t6......Lower");
        System.out.print("\tEnter quality choice (1-6):\t");
        try {
            quality = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (quality == 1) {
            pi_Q = 0.03;
            outString = String.valueOf(outString) + "\r\nQuality: \tS";
        }
        else if (quality == 2) {
            pi_Q = 0.1;
            outString = String.valueOf(outString) + "\r\nQuality: \tR";
        }
        else if (quality == 3) {
            pi_Q = 0.3;
            outString = String.valueOf(outString) + "\r\nQuality: \tP";
        }
        else if (quality == 4) {
            pi_Q = 1.0;
            outString = String.valueOf(outString) + "\r\nQuality: \tM";
        }
        else if (quality == 5) {
            pi_Q = 5.0;
            outString = String.valueOf(outString) + "\r\nQuality: \tMIL-R-26";
        }
        else if (quality == 6) {
            pi_Q = 15.0;
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
        }
        else {
            ErrHandler.errMethod(in);
        }
        System.out.println("pi_Q = " + pi_Q);
        outString = String.valueOf(outString) + "\r\npi_Q = \t" + pi_Q;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        return pi_Q;
    }
    
    private static double compute_pi_E(final Scanner in, final int env, final String[] results) {
        String outString = "\r\n\r\npi_E Calculation:";
        double pi_E = 0.0;
        if (env == 1) {
            pi_E = 1.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
        }
        else if (env == 2) {
            pi_E = 2.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_F";
        }
        else if (env == 3) {
            pi_E = 10.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
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
            pi_E = 4.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IC";
        }
        else if (env == 7) {
            pi_E = 8.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
        }
        else if (env == 8) {
            pi_E = 9.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
        }
        else if (env == 9) {
            pi_E = 18.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
        }
        else if (env == 10) {
            pi_E = 23.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tA_RW";
        }
        else if (env == 11) {
            pi_E = 0.3;
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
        else if (env == 14) {
            pi_E = 610.0;
            outString = String.valueOf(outString) + "\r\nEnvironment: \tC_L";
        }
        else {
            ErrHandler.errMethod(in);
        }
        System.out.println("pi_E = " + pi_E);
        outString = String.valueOf(outString) + "\r\npi_E = \t" + pi_E;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        return pi_E;
    }
}
