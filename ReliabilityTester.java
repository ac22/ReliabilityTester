import java.util.*;
import java.io.*;

public class ReliabilityTester
{
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        Boolean stop = false;
        String input = "n";
        double resistorsLambda = 0.0;
        double transformersLambda = 0.0;
        double PCBconnectionsLambda = 0.0;
        double nonPCBconnectionsLambda = 0.0;
        double connectorsLambda = 0.0;
        String[] resLambda = new String[2];
        String[] transLambda = new String[2];
        String[] pcbLambda = new String[2];
        String[] nonpcbLambda = new String[2];
        String[] connectLambda = new String[2];
        final String[] outputData = new String[7];
        double missionHours = 0.0;
        int envNumber = -1;
        double ambientTemp = 0.0;
        String itemDescription = "";
        String partNumber = "";
        do {
            System.out.println("Reliability Tester\r\n");
            System.out.print("\nEnter the part number for the assembly: \t");
            partNumber = in.nextLine();
            System.out.print("\nEnter a short description of the part: \t");
            itemDescription = in.nextLine();
            System.out.println("\r\n\tEnvironment types:");
            System.out.println("\t\t1......G_B (Ground, Benign)");
            System.out.println("\t\t2......G_F (Ground, Fixed)");
            System.out.println("\t\t3......G_M (Ground, Mobile)");
            System.out.println("\t\t4......N_S (Naval, Sheltered)");
            System.out.println("\t\t5......N_U (Naval, Unsheltered)");
            System.out.println("\t\t6......A_IC (Airborne, Inhabited, Cargo)");
            System.out.println("\t\t7......A_IF (Airborne, Inhabited, Fighter)");
            System.out.println("\t\t8......A_UC (Airborne, Uninhabited, Cargo)");
            System.out.println("\t\t9......A_UF (Airborne, Uninhabited, Fighter)");
            System.out.println("\t\t10.....A_RW (Airborne, Rotary Winged)");
            System.out.println("\t\t11.....S_F (Space, Flight)");
            System.out.println("\t\t12.....M_F (Missile, Flight)");
            System.out.println("\t\t13.....M_L (Missile, Launch)");
            System.out.println("\t\t14.....C_L (Cannon, Launch)");
            System.out.print("\tEnter environment choice (1-14): \t");
            try {
                envNumber = in.nextInt();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (envNumber < 1 || envNumber > 14) {
                ErrHandler.errMethod(in);
            }
            System.out.print("\r\nEnter the ambient temperature in degrees Celsius: \t");
            try {
                ambientTemp = in.nextDouble();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            resLambda = ResistorComputation.compute(in, envNumber, ambientTemp);
            transLambda = TransformerComputation.compute(in, envNumber);
            pcbLambda = PrintedCircuitConnectionComputation.compute(in, envNumber);
            nonpcbLambda = NonPrintedCircuitConnectionComputation.compute(in, envNumber);
            connectLambda = ConnectorComputation.compute(in, envNumber, ambientTemp);
            resistorsLambda = Double.parseDouble(resLambda[1]);
            transformersLambda = Double.parseDouble(transLambda[1]);
            PCBconnectionsLambda = Double.parseDouble(pcbLambda[1]);
            nonPCBconnectionsLambda = Double.parseDouble(nonpcbLambda[1]);
            connectorsLambda = Double.parseDouble(connectLambda[1]);
            System.out.print("\r\nEnter total number of mission hours:\t");
            try {
                missionHours = in.nextDouble();
            }
            catch (Exception e) {
                ErrHandler.errMethod(in);
            }
            if (missionHours <= 0.0) {
                ErrHandler.errMethod(in);
            }
            final double totalLambda = resistorsLambda + transformersLambda + PCBconnectionsLambda + nonPCBconnectionsLambda + connectorsLambda;
            final double MTBF = 1.0 / totalLambda * Math.pow(10.0, 6.0);
            final double probSuccess = Math.exp(-1.0 * missionHours / MTBF);
            outputData[0] = "\r\nItem Description: \t" + itemDescription + "\r\n" + "Part Number: \t" + partNumber + "\r\n" + "\r\n\r\nDATA LOG";
            outputData[1] = resLambda[0];
            outputData[2] = transLambda[0];
            outputData[3] = pcbLambda[0];
            outputData[4] = nonpcbLambda[0];
            outputData[5] = connectLambda[0];
            final String tempString = "\r\n-------------------------------\r\n-------------------------------\r\nRESULTS SUMMARY:\r\nResistors Lambda = \t\t" + resistorsLambda + "\r\n" + "Transformers Lambda = \t\t" + transformersLambda + "\r\n" + "Connections Lambda = \t\t" + (PCBconnectionsLambda + nonPCBconnectionsLambda) + "\r\n" + "Connectors Lambda = \t\t" + connectorsLambda + "\r\n" + "-------------------------------" + "\r\n" + "Total Lambda = \t\t" + totalLambda + " failures per million hours" + "\r\n" + "Mean Time Between Failures (MTBF) = \t\t" + MTBF + " hours between failures" + "\r\n" + "Mission Hours = " + missionHours + "\r\n" + "Probability of Success = " + probSuccess + "\r\n" + "-------------------------------" + "\r\n" + "-------------------------------" + "\r\n";
            System.out.println(tempString);
            outputData[6] = tempString;
            System.out.print("\r\nSave data? (y/n): \t");
            if (in.next().equalsIgnoreCase("y")) {
                System.out.print("\r\nData saved to " + partNumber + ".txt   ...");
                writeToFile(partNumber, outputData);
            }
            System.out.print("\nContinue? (y/n):\t");
            input = in.next();
            stop = input.equalsIgnoreCase("n");
        } while (!stop);
        System.out.println("End...");
    }
    
    private static void writeToFile(final String fileName, final String[] output) {
        try {
            final BufferedWriter out = new BufferedWriter(new FileWriter(String.valueOf(fileName) + ".txt"));
            out.write("\r\nRELIABILITY PREDICTION");
            for (int i = 0; i < output.length; ++i) {
                out.write(output[i]);
            }
            out.write("\r\n----END OF FILE----");
            out.close();
        }
        catch (IOException ex) {}
    }
}
