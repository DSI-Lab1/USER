import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountNegativeOnes {
    public static void main(String[] args) {
        String filePath = "src/dataset/file1.txt"; // 请替换为你的文件路径

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            int n = 1; // 起始行号（从1开始计数）
            int m = 5000; // 结束行号（包含在内）
            int count_sum=0;

            while ((line = br.readLine()) != null) {

                if (lineNumber<n && lineNumber > m) {
                    break; // 超过结束行，提前退出
                }
                if (lineNumber >= n && lineNumber <= m){
                    int count = countNegativeOnesInLine(line);
                    if(count>10) {
                        count_sum++;
                        System.out.println("Line " + lineNumber + ": -1 count = " + count);
                    }
                }
                lineNumber++;
            }
            System.out.println("Count_sum:"+count_sum);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int countNegativeOnesInLine(String line) {
        int count = 0;
        String[] numbers = line.split("\\s+"); // 按空格拆分行

        for (String number : numbers) {
            if (number.equals("-1")) {
                count++;
            }
        }

        return count;
    }
}
