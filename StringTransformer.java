package vn.edu.rikkei.session16.ex02;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// bộ biến đổi chuỗi, tách logic chuyển đổi khỏi logic xử lý danh sách
public class StringTransformer {

    // duyệt danh sách gốc, áp func cho từng phần tử rồi gom kết quả vào danh sách mới
    public static <R> List<R> transform(List<String> list, Function<String, R> func) {
        List<R> result = new ArrayList<>();

        for (String str : list) {
            result.add(func.apply(str));
        }

        return result;
    }
}