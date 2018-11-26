import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class resolve {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводим кол-во элементов от 1 до 20");
        int n = Integer.parseInt(reader.readLine());
        int[] w = new int[n];
        int[] reverse = new int[n];
        ArrayList<Integer> heap1 = new ArrayList<Integer>();
        ArrayList<Integer> heap2 = new ArrayList<Integer>();
        System.out.println("Вводим веса, каждый с новой строки");
        for (int k=0; k< w.length; k++){
            w[k] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(w);
        for (int m = 0; m < w.length; m++ ){
            reverse[m] = w[w.length-m-1];
        }
        System.out.println(Arrays.toString(reverse) + "-наш отсортированный массив");
        w = reverse;
        int sum1 = 0;
        int sum2 = 0;
        for (int i=0; i< w.length; i++){
            if (sum1 == sum2) {
                heap1.add(i);
                sum1 = sum1 + w[i];
            }
            else if(sum1 > sum2){
                heap2.add(i);
                sum2 = sum2 + w[i];
                }
            else if(sum2 > sum1){
                heap1.add(i);
                sum1 = sum1 + w[i];
            }
        }
        System.out.println(heap1+"-индексы");
        System.out.println(sum1+" сумма весов 1 кучи");
        System.out.println(heap2+"-индексы");
        System.out.println(sum2+" сумма весов 2 кучи");
    }
}
