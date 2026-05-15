import java.util.List;
import java.util.stream.Collectors;

public class SortAndSortProcessor {

    @DataProcessor(name = "ClearSpacesAndSort")
    public List<String> cleanAndSort(List<String> input) {
        return input.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());
    }
}
