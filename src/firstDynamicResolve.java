import java.util.stream.IntStream;

public class firstDynamicResolve {
// задачи на динамическое программирование

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,1,1,5};

        int totalSum = IntStream.of(arr).sum();
        System.out.println(totalSum+"-сумма элементов массива");
        int sum = 0;
       /* System.out.println(solution1(0, sum, totalSum, arr));
        System.out.println(solution2(0, sum, totalSum, arr));*/
        System.out.println(solution3(0,sum,5,    arr));

    }


    //1
    public static int solution1(int i, int sum, int totalSum, int[] arr){
        if (i == arr.length - 1) {
            return Math.abs(totalSum - 2 * sum);
        }

        return Math.min(solution1(i + 1, sum, totalSum, arr), solution1(i + 1, (sum + arr[i]), totalSum, arr));
    }

    //2
    public static boolean solution2(int i, int sum, int totalSum, int[] arr){
        if (i == arr.length - 1) {
            return ((Math.abs(totalSum - 2 * sum)) == 0);
        }

        return ((solution2(i + 1, sum, totalSum, arr)) || (solution2(i + 1, (sum + arr[i]), totalSum, arr)));
    }

    //3 num-число с которым сравнивается сумма
    public static boolean solution3(int i, int sum, int num, int[] arr){
        if (sum == num)
            return true;
        if (i == arr.length - 1) {
            return false;
        }
        return ((solution3(i + 1, sum, num, arr)) || (solution3(i + 1, (sum + arr[i]), num, arr)));
    }



}
