package dbfit.util.sql;

import static dbfit.util.LangUtils.join;
import static dbfit.util.LangUtils.repeat;

public class PreparedStatements {
    public static String buildStoredProcedureCall(String procName, int numberOfInputParameters) {
        String inputs = join(repeat("?", numberOfInputParameters), ",");
        String[] newProcName = procName.split("-");
        return "{ call " + newProcName[0] + "(" + inputs + ")}";
    }

    public static String buildFunctionCall(String procName, int numberOfInputParameters) {
        String inputs = join(repeat("?", numberOfInputParameters), ",");
        return "{ ? =call " + procName + "(" + inputs + ")}";
    }
}
