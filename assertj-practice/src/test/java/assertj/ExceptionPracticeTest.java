package assertj;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionPracticeTest {

    @Test
    public void 例外() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }

    @Test
    public void 例外メッセージ() {
        assertThatExceptionOfType(IOException.class).isThrownBy(() -> {
            throw new IOException("boom!");
        })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }
}
