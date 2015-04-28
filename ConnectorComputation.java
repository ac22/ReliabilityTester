import java.util.*;

public final class ConnectorComputation
{
    private ConnectorComputation() {
        throw new AssertionError();
    }
    
    public static String[] compute(final Scanner in, final int env, final double ambTemp) {
        double pi_E;
        double pi_P;
        double pi_K;
        double lambda_b_type2;
        double lambda_b_type1;
        double lambda_p2 = lambda_p2 = (lambda_b_type1 = (lambda_b_type2 = (pi_K = (pi_P = (pi_E = 0.0)))));
        int numType1 = 0;
        int numType2 = 0;
        int gaugeSelect = 0;
        int numContacts = 0;
        final String[] results = { "\r\n\r\nCONNECTORS COMPUTATION", "0.0" };
        System.out.println("\r\nCONNECTORS COMPUTATION");
        System.out.print("Enter number of MIL-C-38999 connectors:\t");
        try {
            numType1 = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numType1 < 0) {
            ErrHandler.errMethod(in);
        }
        if (numType1 > 0) {
            System.out.println("\r\n\tContact Gauge Sizes");
            System.out.println("\t\t1......20");
            System.out.println("\t\t2......22");
            System.out.print("\tEnter contact gauge size selection (1 or 2):\t");
            try {
                gaugeSelect = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (gaugeSelect != 1 && gaugeSelect != 2) {
                ErrHandler.errMethod(in);
            }
            lambda_b_type1 = compute_lambda_b(in, 1, gaugeSelect, ambTemp, results);
            pi_K = 2.0;
            System.out.print("\r\n\tEnter number of active contacts per connector:\t");
            try {
                numContacts = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (numContacts < 0) {
                ErrHandler.errMethod(in);
            }
            pi_P = Math.exp(Math.pow((numContacts - 1) / 10.0, 0.51064));
            System.out.println("pi_P = " + pi_P);
            final String[] array = results;
            final int n = 0;
            array[n] = String.valueOf(array[n]) + "\r\n\r\npi_P Calculation:";
            final String[] array2 = results;
            final int n2 = 0;
            array2[n2] = String.valueOf(array2[n2]) + "\r\n# Active Contacts: \t" + numContacts;
            final String[] array3 = results;
            final int n3 = 0;
            array3[n3] = String.valueOf(array3[n3]) + "\r\npi_P = \t" + pi_P;
            pi_E = compute_pi_E(in, env, results);
            lambda_p2 = numType1 * lambda_b_type1 * pi_K * pi_P * pi_E;
            final String temp = "\r\n-------------------------\r\nResults:\r\nMIL-C-38999 lambda_b = " + lambda_b_type1 + "\r\n" + "pi_K = " + pi_K + "\r\n" + "pi_P = " + pi_P + "\r\n" + "pi_E = " + pi_E + "\r\n" + "# of Connectors = " + numType1 + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p2 + " failures per million hours" + "\r\n" + "**********";
            System.out.println(temp);
            final String[] array4 = results;
            final int n4 = 0;
            array4[n4] = String.valueOf(array4[n4]) + temp;
        }
        System.out.println("\r\nCONNECTORS COMPUTATION");
        final String[] array5 = results;
        final int n5 = 0;
        array5[n5] = String.valueOf(array5[n5]) + "\r\n\r\nCONNECTORS COMPUTATION";
        System.out.print("Enter number of MIL-C-39012 connectors:\t");
        try {
            numType2 = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (numType2 < 0) {
            ErrHandler.errMethod(in);
        }
        if (numType2 > 0) {
            System.out.println("\r\n\tContact Gauge Sizes");
            System.out.println("\t\t1......20");
            System.out.println("\t\t2......22");
            System.out.print("\tEnter contact gauge size selection (1 or 2):\t");
            try {
                gaugeSelect = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (gaugeSelect != 1 && gaugeSelect != 2) {
                ErrHandler.errMethod(in);
            }
            lambda_b_type2 = compute_lambda_b(in, 2, gaugeSelect, ambTemp, results);
            pi_K = 2.0;
            System.out.print("\r\n\tEnter number of active contacts per connector:\t");
            try {
                numContacts = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (numContacts < 0) {
                ErrHandler.errMethod(in);
            }
            pi_P = Math.exp(Math.pow((numContacts - 1) / 10.0, 0.51064));
            System.out.println("pi_P = " + pi_P);
            final String[] array6 = results;
            final int n6 = 0;
            array6[n6] = String.valueOf(array6[n6]) + "\r\n\r\npi_P Calculation:";
            final String[] array7 = results;
            final int n7 = 0;
            array7[n7] = String.valueOf(array7[n7]) + "\r\n# Active Contacts: \t" + numContacts;
            final String[] array8 = results;
            final int n8 = 0;
            array8[n8] = String.valueOf(array8[n8]) + "\r\npi_P = \t" + pi_P;
            pi_E = compute_pi_E(in, env, results);
            lambda_p2 = numType2 * lambda_b_type2 * pi_K * pi_P * pi_E;
            final String temp2 = "\r\n-------------------------\r\nResults:\r\nMIL-C-39012 lambda_b = " + lambda_b_type2 + "\r\n" + "pi_K = " + pi_K + "\r\n" + "pi_P = " + pi_P + "\r\n" + "pi_E = " + pi_E + "\r\n" + "# of Connectors = " + numType2 + "\r\n" + "**********" + "\r\n" + "Lambda_p = " + lambda_p2 + " failures per million hours" + "\r\n" + "**********";
            System.out.println(temp2);
            final String[] array9 = results;
            final int n9 = 0;
            array9[n9] = String.valueOf(array9[n9]) + temp2;
        }
        results[1] = new StringBuilder().append(lambda_p2 + lambda_p2).toString();
        return results;
    }
    
    private static double compute_lambda_b(final Scanner in, final int type, final int gaugeSelect, final double ambTemp, final String[] results) {
        double lambda_b = 0.0;
        String outString = "\r\nlambda_b Computation:";
        double insertRiseTemp = 0.0;
        if (gaugeSelect == 1) {
            outString = String.valueOf(outString) + "\r\nGauge Size: \t20";
            insertRiseTemp = 0.64 * Math.pow(2.0, 1.85);
        }
        else if (gaugeSelect == 2) {
            outString = String.valueOf(outString) + "\r\nGauge Size: \t22";
            insertRiseTemp = 0.989 * Math.pow(2.0, 1.85);
        }
        else {
            ErrHandler.errMethod(in);
        }
        final double T = ambTemp + insertRiseTemp;
        outString = String.valueOf(outString) + "\r\nAmbient Temperature: \t" + ambTemp;
        outString = String.valueOf(outString) + "\r\nInsert Rise Temperature: \t" + insertRiseTemp;
        outString = String.valueOf(outString) + "\r\nTotal Temperature: \t" + T;
        if (type == 1) {
            lambda_b = 0.431 * Math.exp(-2073.6 / (T + 273.0) + Math.pow((T + 273.0) / 423.0, 4.66));
            outString = String.valueOf(outString) + "\r\nConnector Type: \tMIL-C-38999";
        }
        else if (type == 2) {
            lambda_b = 0.19 * Math.exp(-1298.0 / (T + 273.0) + Math.pow((T + 273.0) / 373.0, 4.25));
            outString = String.valueOf(outString) + "\r\nConnector Type: \tMIL-C-39012";
        }
        else {
            ErrHandler.errMethod(in);
        }
        outString = String.valueOf(outString) + "\r\nlambda_b = \t" + lambda_b;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("lambda_b = " + lambda_b);
        return lambda_b;
    }
    
    private static double compute_pi_E(final Scanner in, final int env, final String[] results) {
        double pi_E = 0.0;
        int quality = -1;
        String outString = "\r\n\r\npi_E Computation";
        System.out.println("\r\nQuality");
        System.out.println("\t\t1......MIL-SPEC");
        System.out.println("\t\t2......Lower");
        System.out.print("\tEnter quality choice (1 or 2): \t");
        try {
            quality = in.nextInt();
        }
        catch (Exception e) {
            ErrHandler.errMethod(in);
        }
        if (quality < 1 || quality > 2 || env < 1 || env > 14) {
            ErrHandler.errMethod(in);
        }
        if (quality == 1) {
            outString = String.valueOf(outString) + "\r\nQuality: \tMIL-SPEC";
            if (env == 1) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
                pi_E = 1.0;
            }
            else if (env == 2) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_F";
                pi_E = 1.0;
            }
            else if (env == 3) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_M";
                pi_E = 8.0;
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
                pi_E = 3.0;
            }
            else if (env == 7) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
                pi_E = 5.0;
            }
            else if (env == 8) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
                pi_E = 8.0;
            }
            else if (env == 9) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
                pi_E = 12.0;
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
                pi_E = 490.0;
            }
        }
        else if (quality == 2) {
            outString = String.valueOf(outString) + "\r\nQuality: \tLower";
            if (env == 1) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_B";
                pi_E = 2.0;
            }
            else if (env == 2) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_F";
                pi_E = 5.0;
            }
            else if (env == 3) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tG_M";
                pi_E = 21.0;
            }
            else if (env == 4) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tN_S";
                pi_E = 10.0;
            }
            else if (env == 5) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tN_U";
                pi_E = 27.0;
            }
            else if (env == 6) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IC";
                pi_E = 12.0;
            }
            else if (env == 7) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_IF";
                pi_E = 18.0;
            }
            else if (env == 8) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UC";
                pi_E = 17.0;
            }
            else if (env == 9) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_UF";
                pi_E = 25.0;
            }
            else if (env == 10) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tA_RW";
                pi_E = 37.0;
            }
            else if (env == 11) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tS_F";
                pi_E = 0.8;
            }
            else if (env == 12) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tM_F";
                pi_E = 20.0;
            }
            else if (env == 13) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tM_L";
                pi_E = 54.0;
            }
            else if (env == 14) {
                outString = String.valueOf(outString) + "\r\nEnvironment: \tC_L";
                pi_E = 970.0;
            }
        }
        outString = String.valueOf(outString) + "\r\npi_E = \t" + pi_E;
        final int n = 0;
        results[n] = String.valueOf(results[n]) + outString;
        System.out.println("pi_E = " + pi_E);
        return pi_E;
    }
}
