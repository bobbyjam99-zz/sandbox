package assertj;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListPracticeTest {

    @Test
    public void 要素が順序も含め完全に一致する() {

        List<String> list = Arrays.asList("hoge", "fuga", "piyo");

        assertThat(list).containsExactly("hoge", "fuga", "piyo");
    }

    @Test
    public void 要素の一部が指定した順序で存在する() {

        List<String> list = Arrays.asList("hoge", "fuga", "piyo");

        assertThat(list).containsSequence("hoge", "fuga", "piyo");
        assertThat(list).containsSequence("fuga", "piyo");
    }

}
