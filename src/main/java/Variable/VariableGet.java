package Variable;

import Setting.Checked;
import Setting.Setting;
import jakarta.validation.constraints.NotBlank;

public class VariableGet extends Setting implements Checked {
    /**
     * @param name key 값
     * @return 변수에 값이 존재시 값을 반환함
     * @throws NullPointerException 변수 이름이 존재하지 않을때 throw
     */
    public Object getVarValue(@NotBlank String name) throws NullPointerException {
        try {
            return variable.get(name.strip());
        } catch (Exception e) {
            throw new NullPointerException("값이 존재하지 않습니다.");
        }
    }
    /**
     * existence map 에 변수의 존재 여부를 판단함
     * @param line 값을 가져옵니다.
     * @return 존재하면 true 를 반환함
     */
    @Override
    public boolean checkedVar(String line) {
        return variable.containsKey(line);
    }
}
