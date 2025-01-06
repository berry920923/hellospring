package berryspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        System.out.println(this);
    }

    @Test
    void sort() {
        /*
        // 준비 (given)
        Sort sort = new Sort();
        // 실행 (when)
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // 검증 (then)
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
        */
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {
        Sort sort = new Sort();
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        Sort sort = new Sort();
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
