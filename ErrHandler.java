import java.util.*;

public final class ErrHandler
{
    public static void errMethod(final Scanner in) {
        System.out.println("Invalid input");
        System.out.println("Press enter to close");
        in.nextLine();
        in.nextLine();
        System.exit(-1);
    }
}
