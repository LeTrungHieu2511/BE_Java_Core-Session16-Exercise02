package vn.edu.rikkei.session16.ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int WIDTH = 55;

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Spring", "Docker", "AWS");

        List<Integer> lengths = StringTransformer.transform(words, s -> s.length());
        List<String> upperCases = StringTransformer.transform(words, s -> s.toUpperCase());

        System.out.println("""
                --- CHUYỂN ĐỔI CHUỖI VỚI FUNCTION ---
                Danh sách gốc: ["Java", "Spring", "Docker", "AWS"]
                Biến đổi 1: Lấy độ dài chuỗi (s -> s.length())
                Biến đổi 2: Chuyển chữ hoa (s -> s.toUpperCase())""");
        System.out.println();

        printOutput(null);
        printOutput(centerText(" BỘ BIẾN ĐỔI CHUỖI FUNCTION<T, R> "));
        printOutput(null);

        printOutput(" [Biến đổi 1 - Độ dài chuỗi]:");
        printOutput(" -> " + formatList(lengths));
        printDivider();

        printOutput(" [Biến đổi 2 - Chuẩn hóa chữ hoa]:");
        printOutput(" -> " + formatList(upperCases));

        printOutput(null);
    }

    // content == null thì in đường viền, ngược lại thì in 1 dòng có nội dung
    static void printOutput(String content) {
        if (content == null) {
            System.out.printf("+%s+%n", "-".repeat(WIDTH));
        } else {
            System.out.printf("|%-" + WIDTH + "s|%n", content);
        }
    }

    private static void printDivider() {
        System.out.printf("|%s|%n", "-".repeat(WIDTH));
    }

    private static String centerText(String text) {
        int padding = Math.max((WIDTH - text.length()) / 2, 0);
        return " ".repeat(padding) + text;
    }

    // định dạng danh sách giống mẫu: chuỗi có ngoặc kép, số thì để nguyên
    private static String formatList(List<?> list) {
        List<String> items = new ArrayList<>();

        for (Object item : list) {
            items.add(item instanceof String ? "\"" + item + "\"" : String.valueOf(item));
        }

        return "[" + String.join(", ", items) + "]";
    }
}