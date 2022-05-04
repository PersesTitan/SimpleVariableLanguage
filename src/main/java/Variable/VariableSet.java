package Variable;

import Setting.Setting;
import Setting.Local;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VariableSet extends Setting {
    private String start = null;
    private String end = null;

    /* 생성자 */

    public VariableSet() {}

    /**
     * @param start 처음 변수 조건
     * @param end 마지막 변수 조건
     */
    public VariableSet(@NotBlank String start, @NotBlank String end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param var start 값 또는 end 값
     * @param local start 인지 end 인지 설정
     * @throws IOException start, end 두게다 조건이 불일치 할 시 에러
     */
    public VariableSet(@NotBlank String var, @NotNull Local local) throws IOException {
        if (local.equals(Local.START)) this.start = var;
        else if (local.equals(Local.END)) this.end = var;
        else throw new IOException("local 값을 정확하게 입력해세주세요");
    }

    /* 메소드 */

    /**
     * 변수 이름을 가져오는 메소드.
     * 처음 변수 사이의 조건이 필요함.
     * start 는 처음 일치하는 위치
     * end 는 마지막에 일치하는 위치
     * @param line 라인 1개 받아오기
     * @return 변수 값 가져오기
     */
    public String getVarName(@NotBlank String line) throws IOException {
        int startPosition = line.indexOf(start) + start.length();
        int endPosition = line.indexOf(end);
        if (startPosition > endPosition) throw new IOException("문법 오류 발생");
        return line.substring(startPosition, endPosition).strip();
    }

    /**
     * 삭제 할 문자 존재 할 시 이 메소드를 이용함
     * @param line 값을 받아오는 변수
     * @param separator 구분자
     * @param local 위치를 구하는 변수
     * @param del 삭제할 문자
     * @return 앞 또는 뒤에서 변수 이름을 가져오게 됨
     * @throws IOException 문제 발생시 throw
     */
    public String getVarName(@NotBlank String line, String separator, @NotNull Local local, String del)
            throws IOException {
        List<String> list = getVar(line, separator);
        if (local.equals(Local.START)) {
            return mode ?
                    list.get(1).replace(del, "") :
                    list.get(0).replace(del, "");
        } else if (local.equals(Local.END)) {
            return mode ?
                    list.get(list.size() - 2).replace(del, "") :
                    list.get(list.size() - 1).replace(del, "");
        } else throw new IOException("Local 값을 재대로 입력해주세요.");
    }

    /**
     * @param line 값을 받아오는 변수
     * @param separator 구분자
     * @param local 위치를 구하는 변수
     * @return 앞 또는 뒤에서 변수 이름을 가져오게 됨
     * @throws IOException 문제 발생시 throw
     */
    public String getVarName(@NotBlank String line, String separator, @NotNull Local local) throws IOException {
        List<String> list = getVar(line, separator);
        if (local.equals(Local.START)) {
            return mode ? list.get(1) : list.get(0);
        } else if (local.equals(Local.END)) {
            return mode ? list.get(list.size() - 2) : list.get(list.size() - 1);
        } else throw new IOException("Local 값을 재대로 입력해주세요.");
    }

    /**
     * @param line 값을 가져옴
     * @param separator 구분자
     * @return 분리 후 list 를 반환
     * @throws IOException 문제 발생시 throw
     */
    private List<String> getVar(@NotBlank String line, String separator) throws IOException {
        if (!line.contains(separator)) throw new IOException("값중에 구분자가 존재하지 않습니다.");
        String[] texts = line.strip().split(separator);
        List<String> list = new ArrayList<>(Arrays.asList(texts));
        list.removeAll(Collections.singletonList(null));
        list.removeAll(Collections.singletonList(""));
        list.removeAll(Collections.singletonList(" "));
        if (list.size() < 2) throw new IOException("line 를 구분자로 분리한 결과 사이즈가 너무 작습니다.");
        return list;
    }

    /**
     * 변수안에 값을 넣는 메소드입니다.
     * @param name 변수 이름
     * @param value 변수 내용
     */
    public void putValue (@NotBlank Object name, @NotBlank Object value) {
        variable.put(name, value);
    }

}
