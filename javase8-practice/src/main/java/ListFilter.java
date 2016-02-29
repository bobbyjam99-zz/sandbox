import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilter {

    public static List<String> filterByLength7(List<String> list, int length) {
        List<String> result = new ArrayList<>();
        for(String s : list) {
            if(s.length() >= length) {
                result.add(s);
            }
        }
        return result;
    }

    public static List<String> filterByLength8(List<String> list, int length) {
        return list.stream().filter(s -> s.length() >= length).collect(Collectors.toList());
    }
}
