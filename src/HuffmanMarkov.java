/**
 * Huffman encoding for a Markov process, generated by by <code>generateeHufmanMarkov</code>.
 *
 * To store a Morkov process we need a Huffman encoding for the steady state distribution, and a Huffman encoding for
 * each symbol in the alphabet (i.e. each state in the Markov process)
 */
public class HuffmanMarkov {

    Huffman		steady;			// huffman for steady state distribution
    Huffman[]	state;			// huffman given that system is in state[k]
    Markov		markov;

    public HuffmanMarkov(Markov markov) {
        state = new Huffman[Distribution.RANGE];
        this.markov = markov;
    }

    public static HuffmanMarkov generate(Markov markov) {

        HuffmanMarkov result = new HuffmanMarkov(markov);

        // Generate Huffman encoding for steady state distribution (same as random variable distribution)
        // TODO

        // For each state, k, generate the Huffman encoding using the (kth) distribution in the Markov process
        // TODO

        return result;
    }


    /**
     * Calculate the average codeword length, L(C), in a Huffman encoding.
     *
     * @return L(C)
     */
    public double codewordLength() {
        double sum = 0;

        // TODO

        return sum;
    }

    /**
     * Encode a message using Huffamn encoding.
     *
     * @param source
     *            Original message to be encoded
     *
     * @return Message encoded using Huffman encoding.
     */
    public String encode(String source) {

        StringBuilder result = new StringBuilder();

        // encode the first symbol using steady state distribution
        // TODO

        // encode the subsequent symbols using state dependent distribution
        // TODO

        return result.toString();
    }

    /**
     * Decode a message using Huffamn encoding.
     *
     * @param encoded
     *            Encoded message to be decoded
     *
     * @return Message decoded using Huffman encoding.
     */
    public String decode(String encoded) {

        StringBuilder result = new StringBuilder();

        // Decode first symbol using the steady state encoding tree
        // TODO

        // decode the encoded message bit by bit
        // TODO

        return result.toString();
    }

}