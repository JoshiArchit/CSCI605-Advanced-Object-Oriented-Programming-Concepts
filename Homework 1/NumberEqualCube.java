/**
 * NumberEqualCube.java
 * Version: v1.2
 *
 * Revisions:
 * v1.0 - Initial Logic.
 * v1.1 - Rearranged code to functions.
 * v1.3 - Output format bug fixes.
 */

/**
 * This class calculates the sum of a given number n with length d. Each of the
 * digits in 'n' are raised to the length of the number 'd' and their sum 's'
 * is calculated. Output will be printed only if the sum 's' is equal to the
 * original number 'n'.
 * Example -
 * 1.)  Assume n = 153, then n is a number which meets the property, because
 *      153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27.
 * 2.)  Assume n = 154, then n is a number which does not meet the property,
 *      because 154 ≠ 1^3 + 5^3 + 4^3 = 190.
 *
 * @author      Archit Joshi
 * @author      Cassie Clark
 */

public class NumberEqualCube {
    /**
     * Method to check number for described pattern.
     */
    private static void checkNumberEqualCube() {
        for ( int num = 1; num <= 100000; num++ ) {
            int sum = 0;

            // Convert number to character array
            char[] numAsChar = ( "" + num ).toCharArray();
            int len = numAsChar.length;
            sum = sumOfNum( num, len, sum);

            if(sum == num){
                printFormattedOutput(num, len, numAsChar);
            }
        }
    }

    /**
     * Helper method to print the output in expected format.
     *
     * @param num number to check for pattern
     * @param len length of number in character form
     * @param numAsChar number as a string
     */
    private static void printFormattedOutput( int num, int len, char[] numAsChar ) {
        System.out.print( "\n" + num + " = " );
        for ( int j=0; j < len; j++ ) {
            System.out.print( numAsChar[j] + "^" + len );

            if ( j != len-1 ) {
                System.out.print( " + " );
            }
        }
    }

    /**
     * Helper function to check if a number is the sum of cubes of its individual digits.
     *
     * @param temp temporary variable
     * @param len length of current number
     * @param sum sum of cubes of individual digits
     * @return sum of cubes of individual digits
     */
    private static int sumOfNum(int temp, int len, int sum) {
        while ( temp > 0 ) {
            int rem = temp % 10;
            int temp1 = rem;

            // For loop to calculate the power of the individual digits in the
            // original number. The loop runs for the length of the number
            // which is stored in 'len'

            for( int i = 1; i < len; i++ ) {
                // The last digit stored in temp1 will be multiplied by rem
                temp1 = temp1 * rem;
            }

            // Calculation for final
            sum += temp1;

            // Number is divided by 10 to get the quotient which removes the
            // digit already worked on.
            temp /= 10;
        }

        //Return the value of sum to the main driver program
        return sum;
    }

    public static void main ( String[] args ) {
        checkNumberEqualCube();
    }
}
