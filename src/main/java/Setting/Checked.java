package Setting;

import javax.validation.constraints.NotBlank;

public interface Checked {
    boolean checkedVar(@NotBlank String line);
}