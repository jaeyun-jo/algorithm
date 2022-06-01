import java.util.*;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        String[] strings = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        solution(strings, course);
    }

    public static String[] solution(String[] orders, int[] courses) {
        extractCourseCandidates(orders, courses);

        List<String> selectedCourses = new ArrayList<>();
        for (int course : courses) {
            courseCandidates.entrySet()
                            .stream()
                            .filter(e -> e.getKey().length() == course)
                            .map(Map.Entry::getValue)
                            .max(Comparator.comparingInt(a -> a))
                            .ifPresent(maxOrderCount -> selectedCourses.addAll(courseCandidates.entrySet()
                                                                                           .stream()
                                                                                           .filter(e -> e.getKey().length() == course && e.getValue().equals(maxOrderCount))
                                                                                           .filter(e -> isOrderedMin(e.getKey(), orders))
                                                                                           .map(Map.Entry::getKey)
                                                                                           .collect(Collectors.toList())));
        }
        return selectedCourses.stream()
                              .sorted(Comparator.naturalOrder())
                              .toArray(String[]::new);
    }

    private static void extractCourseCandidates(String[] orders, int[] courses) {
        for (String order : orders) {
            for (int course : courses) {
                combination(0, 0, course, order.split(""), new String[course]);
            }
        }
    }

    static boolean isOrderedMin(String order, String[] orders) {
        return Arrays.stream(orders)
                     .filter(o -> new HashSet<>(Arrays.asList(o.split(""))).containsAll(Arrays.asList(order.split(""))))
                     .count() >= 2;
    }

    static Map<String, Integer> courseCandidates = new HashMap<>();

    public static void combination(int depth, int startIndex, int r, String[] arr, String[] result) {
        if (depth == r) {
            String course = Arrays.stream(result).sorted().collect(Collectors.joining());
            int count = courseCandidates.getOrDefault(course, 0);
            courseCandidates.put(course, ++count);
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            result[depth] = arr[i];
            combination(depth + 1, i + 1, r, arr, result);
        }
    }
}
