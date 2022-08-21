import java.util.ArrayList;
import java.util.List;

public class combinations {
    public static void main(String[] args) {
        List<Integer> combo1 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> res1 = new ArrayList<>();
        res1 = res_list(0, 0, 5, 3, combo1, res);
        System.out.println(res1);
    }
    public static List<List<Integer>> res_list(int pos, int number_pos, int n, int k, List<Integer> list_buf, List<List<Integer>> result) {
        if(pos == k){
            if(list_buf.size()>k){
                for (int i = list_buf.size()-1; i >= k; i--) {
                    list_buf.remove(i);
                }
                result.add(new ArrayList<>(list_buf));
            }
            else{
                result.add(new ArrayList<>(list_buf));
            }
        }
        else{
            for (int i = number_pos +1 ; i <= n; i++) {
                list_buf.add(pos, i);
                res_list(pos+1, i, n, k, list_buf, result);
            }
        }
        return result;
    }
}
