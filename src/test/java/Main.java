import Variable.VariableGet;
import Variable.VariableType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String str = "엄 ...; 어엄";
        VariableType variableType = new VariableType("엄", "어엄", true);
        VariableGet variableGet = new VariableGet();

        if (variableType.checkedVar(str)) System.out.println(variableType.getValue(str));

    }
}
