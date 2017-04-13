import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent a (random variable) probability distribution.
 *
 * The alphabet of symbols is not stored, since assuming the alphabet is the 7-bit ASCII characters (i.e. ASCII
 * characters in range 0-127)
 */
public class Distribution {

    final static int	RANGE	= 128;	// /< Only interested in 7-bit ASCII characters

    static double[]			p;				// /< probability distribution
    static char[]       chars;
    public Distribution() {

        p = new double[RANGE];
        chars = new char[RANGE];
    }

    /**
     * Factory method to build a probability distribution from observed frequencies in a string.
     *
     * @param source
     *            String contain text (including line brake, etc)
     *
     * @return Probability distribution.
     */
    public static Distribution fromString(String source) {

        Distribution result = new Distribution();
        // first pass, over string -> get character frequencies

        double count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<source.length(); i++){
            char ch = source.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
            count ++;
        }

        int[] freqs = new int[RANGE];

        int i = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            freqs[i] = m.getValue();
            chars[i] = m.getKey();
            i++;
        }

        // second pass, over frequencies -> scale to get probabilities
        for(int j=0; j < freqs.length; j++)
            result.p[j] = freqs[j] / count;

        return result;
    }

    /**
     * Calculate the entropy of a probability distribution.
     *
     * @return entropy (in bits)
     */
    public static double entropy() {
        //H(X) = sum over all x {-p(x) * log(p(x))}

        double result = 0.0;

        for(int i=0; i<p.length; i++){
            double px = p[i];
            result += -(px * log2(px));
            //result += -(px * (Math.log(px)/Math.log(2)));
            // System.out.println(px);
            //System.out.println(result);
        }
        //System.out.println("entropy = " + result);
        return result;
    }

    static double log2(double x) {
        if(x != 0) {
            return Math.log(x) / Math.log(2);
        }else {
            return 0;
        }
    }

//    public static void main(String[] args){
//        String test = "I am a test string";
//        fromString(test);
//        entropy();
//
//    }
}