package Setting;

import java.util.HashMap;
import java.util.Map;

public class Setting {
    protected Map<Object, Object> variable = new HashMap<>();
    protected String startVar = null;
    protected String endVar = null;
    /**
     * mode = true 일때 양 끝이 조건에 일치해야함.
     * mode = false 일때 위치 상관 없음
     */
    protected boolean mode = true;
}
