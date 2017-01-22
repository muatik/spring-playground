import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by muatik on 1/22/17.
 */
public class WeightedMean {


    public static void main(String[] args) {
//        Input (stdin)
//        5
//        10 40 30 50 20
//        1 2 3 4 5
//        Expected Output
//        32.0

        Scanner scan = new Scanner(System.in);

        int N = Integer.valueOf(scan.nextLine());

        String[] sNumbers = scan.nextLine().trim().split(" ");
        List<Float> numbers = new ArrayList<>();
        for (String i: sNumbers)
            numbers.add(Float.valueOf(i));

        String[] sCounts = scan.nextLine().trim().split(" ");
        List<Float> counts = new ArrayList<>();
        for (String i: sCounts)
            counts.add(Float.valueOf(i));

        float sum = 0, countSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i) * counts.get(i);
            countSum += counts.get(i);
        }

        System.out.printf("%.1f\n", sum / countSum);


    }
}
