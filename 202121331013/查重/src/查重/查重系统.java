package 查重;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class 查重系统 {
    public static void main(String[] args) {
    	String filePath1 = "C:\\Users\\72411\\Desktop\\工程概论第二次作业\\orig.txt";
    	String filePath2 = "C:\\Users\\72411\\Desktop\\工程概论第二次作业\\orig_add.txt";

    	 String text1 = readFile(filePath1);
         String text2 = readFile(filePath2);

         double similarity = calculateSimilarity(text1, text2);
         String formattedSimilarity = String.format("%.2f%%", similarity*100);
         System.out.println("文本相似度：" + formattedSimilarity);

     }

     public static String readFile(String filePath) {
         StringBuilder sb = new StringBuilder();
         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 sb.append(line);
                 sb.append(System.lineSeparator());
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
         return sb.toString();
     }

     public static double calculateSimilarity(String text1, String text2) {
         int matchingCount = findMatchingCount(text1, text2);
         int totalLength = Math.max(text1.length(), text2.length());
         return (double) matchingCount / totalLength * 100;
     }

     public static int findMatchingCount(String text1, String text2) {
         int count = 0;
         int text1Length = text1.length();
         int text2Length = text2.length();
         int minLen = Math.min(text1Length, text2Length);

         for (int i = 0; i < minLen; i++) {
             if (text1.charAt(i) == text2.charAt(i)) {
                 count++;
             }
         }

         return count;
     }
 }