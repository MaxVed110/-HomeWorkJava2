import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int[] res = new int[] {1, 31, 8, 1, 3};
        SortMerge(res, 0, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static void SortMerge(int[] array, int begin_index, int end_index) {
        if (end_index <= begin_index) {
            return;
        }
        int middle = begin_index + (end_index - begin_index) / 2;
        SortMerge(array, begin_index, middle);
        SortMerge(array, middle + 1, end_index);

        int[] buf = Arrays.copyOf(array, array.length);

        for (int k = begin_index; k <= end_index; k++) {
            buf[k] = array[k];
        }
        int i = begin_index, j = middle+ 1;
        for (int k = begin_index; k <=end_index; k++) {
            if(i>middle){
                array[k]=buf[j];
                j++;
            } else if (j>end_index) {
                array[k] = buf[i];
                i++;
            } else if (buf[j]<buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
    }
}
