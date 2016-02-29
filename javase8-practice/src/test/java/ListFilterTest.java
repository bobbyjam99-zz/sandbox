import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListFilterTest {

    @Test
    public void filterByLength7() {
        List<String> list = Arrays.asList("abc", "abcd", "abcde", "abcdefg", "abcdef");

        assertThat(ListFilter.filterByLength7(list, 5), is(Arrays.asList("abcde", "abcdefg", "abcdef")));
    }

    @Test
    public void filterByLength8() {
        List<String> list = Arrays.asList("abc", "abcd", "abcde", "abcdefg", "abcdef");

        assertThat(ListFilter.filterByLength8(list, 5), is(Arrays.asList("abcde", "abcdefg", "abcdef")));
    }

}
