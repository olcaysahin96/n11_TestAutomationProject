import java.util.logging.Logger;

public class Log4j
{

    private static Logger Log = Logger.getLogger(Log4j.class.getName());

    public static void startLog (String testClassName){
        Log.info("Test is Starting!");
    }

    public static void endLog (String testClassName){
        Log.info("Test is Ending!");
    }

    public static void info (String message) {
        Log.info(message);
    }

    public static void warning (String message) {
        Log.warning(message);
    }
}
