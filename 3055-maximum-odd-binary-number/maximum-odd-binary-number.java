class Solution {
    public String maximumOddBinaryNumber(String binaryString) {
        int countOnes = 0;
        StringBuilder resultBuilder = new StringBuilder();
        
        for (char ch : binaryString.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }
        
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (countOnes > 1) {
                countOnes--;
                resultBuilder.append('1');
            } else {
                resultBuilder.append('0');
            }
        }
        
        resultBuilder.append('1');
        return resultBuilder.toString();
    }
}


// import java.util.Arrays;

// class Solution {
//     public String maximumOddBinaryNumber(String s) {
//         char[] chars = s.toCharArray();
//         Arrays.sort(chars);
//         for (int i = chars.length - 1; i >= 0; i--) {
//             if (chars[i] == '1') {
//                 char temp = chars[i];
//                 chars[i] = chars[chars.length - 1];
//                 chars[chars.length - 1] = temp;
//                 break;
//             }
//         }
//         return new String(chars);
//     }
// }
