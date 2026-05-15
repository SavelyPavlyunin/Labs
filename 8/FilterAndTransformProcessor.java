import java.util.List;
import java.util.stream.Collectors;

public class FilterAndTransformProcessor {


    @DataProcessor(name = "FilterShortAndUpper")
    public List<String> filterAndConvert(List<String> input) {
        return input.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
