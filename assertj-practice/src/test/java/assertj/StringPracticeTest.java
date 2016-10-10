package assertj;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPracticeTest {

    @Test
    public void 文字列が等しい() {

        String hoge = "hoge";

        assertThat(hoge).isEqualTo("hoge");
    }

    /**
     * 実行したい場合はIgnoreを外して実行
     */
    @Test
    @Ignore
    public void テスト異常メッセージ確認用() {

        String hoge = "hoge";

        assertThat(hoge).isEqualTo("Hoge");
    }

}
