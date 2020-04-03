package manager.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.Logger;

public class Log {

    public static void saveErrorLog(final Logger LOG, Exception e, String path) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        LOG.error("Error in " + path + "\n"
                + "Exception Type: " + e.getClass() + "\n"
                + "Exception Message: " + e.getMessage() + "\n"
                + "Stack Trace:\n" + sw.toString());
    }
}