import java.util.*;

public class MeanMedianMode {
    // https://www.hackerrank.com/challenges/s10-basic-statistics/
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner scan = new Scanner(System.in);
//        Integer N = Integer.valueOf(scan.nextLine());
        Integer N = 10;

        List<Integer> numbers = new ArrayList<Integer>();
//        String[] sNumbers = scan.nextLine().trim().split(" ");
        String s = "64630 11735 14216 99233 14470 4978 73429 38120 51135 67060";
        String[] sNumbers = s.trim().split(" ");
        for(String i: sNumbers)
            numbers.add(Integer.valueOf(i));

        float sum = 0, median = 0, mode = 0;



        // FINDING MEAN
        for (float i: numbers)
            sum += i;
        float mean = sum / N;



        // FINDING MEDIAN
        numbers.sort(Comparator.naturalOrder());
        int middle = (int) Math.ceil(N / 2);
        if (numbers.size() > 1)
            median = (float) (numbers.get(middle) + numbers.get(middle - 1)) / 2;
        else
            median = numbers.get(middle);


        // FINDING MODE
        Map<Float, Integer> counter = new HashMap<>();
        for(float i: numbers)
            counter.put(i, counter.getOrDefault(i, 0) + 1);

        Map.Entry<Float, Integer> modeElement = null;
        for (Map.Entry<Float, Integer> i: counter.entrySet())
            if (modeElement == null || i.getValue() > modeElement.getValue() || (
                    i.getValue().equals(modeElement.getValue()) && i.getKey() < modeElement.getKey()))
                modeElement = i;
        mode = modeElement.getKey();


        System.out.printf("%.1f\n", mean);
        System.out.printf("%.1f\n", median);
        System.out.printf("%.0f\n", mode);
    }
}