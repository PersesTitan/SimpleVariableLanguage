import Variable.Variable;
import Variable.VariableType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Variable variable = new Variable("ㅇㅅㅇ", ":");
        VariableType variableTypeOne = new VariableType("ㅇㅅㅇ", ";", true);
        String line1 = "ㅇㅅㅇ안녕하세요.;";
        String line2 = "      ㅇㅅㅇ안녕하세요.;    ";
        String line3 = "  ㅇㅅㅇ  안녕하세요.   ;  ";

        Object g = variable.getVarValue("dd");
        System.out.println(variableTypeOne.getValue(line1));
        System.out.println(variableTypeOne.getValue(line2));
        System.out.println(variableTypeOne.getValue(line3));
    }
}
