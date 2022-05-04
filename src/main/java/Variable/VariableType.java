package Variable;

import Setting.Checked;
import Setting.Setting;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;

public class VariableType extends Setting implements Checked {
    /**
     * @param startVar 시작하는 변수 값
     * @param endVar 마지막 변수 값
     * @param mode 모드 지정
     */
    public VariableType(@NotBlank String startVar, @NotBlank String endVar, @NotNull boolean mode) {
        this.startVar = startVar;
        this.endVar = endVar;
        this.mode = mode;
    }

    /**
     * @param var startVar 또는 endVar
     * @param bool true 일때 startVar , false 일때 endVar
     * @param mode 모드 지정
     */
    public VariableType(@NotBlank String var, @NotNull boolean bool, @NotNull boolean mode) {
        this.mode = mode;
        if (bool) this.startVar = var;
        else this.endVar = var;
    }

    /**
     * 변수안에 값을 넣는 메소드입니다.
     * @param name 변수 이름
     * @param value 변수 내용
     */
    public void putValue (@NotBlank Object name,@NotBlank Object value) {
        variable.put(name, value);
    }

    /**
     * @param line 라인의 값을 받는 것
     * @return 변수 조건이 일치하면 ture, 아니면 false
     */
    @Override
    public boolean checkedVar(@NotBlank String line) {
        if (mode) {
            if (startVar!=null && endVar!=null) return line.strip().startsWith(startVar) && line.strip().endsWith(endVar);
            else if (startVar != null) return line.strip().startsWith(startVar);
            else if (endVar != null) return line.strip().endsWith(endVar);
            else return false;
        } else {
            if (startVar!=null && endVar!=null) return line.strip().contains(startVar) && line.strip().contains(endVar);
            else if (startVar != null) return line.strip().contains(startVar);
            else if (endVar != null) return line.strip().contains(endVar);
            else return false;
        }
    }

    /**
     * start 만 값이 주어졌을 때는 start 부터 끝까지,
     * end 만 값이 주어졌을 시 0부터 end 까지,
     * start, end 가 주어졌을 시 start 부터 end 까지의 값을 반환함
     *
     * @param line 라인에 있는 값을 가져옴니다.
     * @return start, end 두개다 null 일때 null 를 반환
     */
    public String getValue(@NotBlank String line) throws IOException {
        line = line.strip();
        int startPosition, endPosition;
        String total;
        if (startVar!=null && endVar!=null) {
            startPosition = line.indexOf(startVar)+startVar.length();
            endPosition = line.lastIndexOf(endVar);
            if (startPosition > endPosition) throw new IOException("문법 오류 발생");
            total = line.substring(startPosition, endPosition);

        } else if (startVar != null) {
            startPosition = line.indexOf(startVar)+startVar.length();
            if (startPosition < 0) throw new IOException("문법 오류 발생");
            total = line.substring(startPosition);

        } else if (endVar != null) {
            endPosition = line.lastIndexOf(endVar);
            if (endPosition > 0) throw new IOException("문법 오류 발생");
            total = line.substring(0, endPosition);
        } else return null;
        return total;
    }

}
