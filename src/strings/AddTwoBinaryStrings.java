package strings;

public class AddTwoBinaryStrings {

    public static void main(String[] args) {
        System.out.println(addBinaryStrings("11", "10111"));
    }
    
    private static String addBinaryStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i  = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while( i >= 0 && j >= 0){
            if (carry == 1) {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    sb.append('1');
                } else if (a.charAt(i) == '1' || b.charAt(j) == '1'){
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = 0;
                }
            } else {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    sb.append('0');
                    carry = 1;
                } else if (a.charAt(i) == '1' || b.charAt(j) == '1'){
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            i--;
            j--;
        }
        
        while( i >= 0){
            if (carry == 1) {
                if (a.charAt(i) == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = 0;
                }
            } else {
                if (a.charAt(i) == '1') {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append('0');
                    carry = 0;
                }
            }
            i--;
        }
        
        while( j >= 0){
            if (carry == 1) {
                if (b.charAt(j) == '1') {
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = 0;
                }
            } else {
                if (b.charAt(j) == '1') {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append('0');
                    carry = 0;
                }
            }
            j--;
        }
        
        if (carry == 1) {
            sb.append("1");
        }
        
        return sb.reverse().toString();
    }
}
