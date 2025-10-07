import java.util.*;

class AhoCorasick {

    // Maximum possible states = sum of lengths of all keywords
    static final int MAX_STATES = 500;
    // Number of lowercase letters
    static final int ALPHABET_SIZE = 26;

    // Output mask: bit i is 1 if word[i] ends at this state
    static int[] output = new int[MAX_STATES];
    // Failure links
    static int[] failure = new int[MAX_STATES];
    // Transition table (trie)
    static int[][] transition = new int[MAX_STATES][ALPHABET_SIZE];

    // Build the automaton from the given keywords
    static int buildMachine(String[] words, int wordCount) {
        Arrays.fill(output, 0);
        for (int[] row : transition)
            Arrays.fill(row, -1);

        int stateCount = 1; // root = 0

        // Build trie
        for (int i = 0; i < wordCount; i++) {
            String word = words[i];
            int state = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (transition[state][idx] == -1)
                    transition[state][idx] = stateCount++;
                state = transition[state][idx];
            }
            output[state] |= (1 << i);
        }

        // Fill missing transitions from root to itself
        for (int c = 0; c < ALPHABET_SIZE; c++)
            if (transition[0][c] == -1)
                transition[0][c] = 0;

        Arrays.fill(failure, -1);
        Queue<Integer> queue = new LinkedList<>();

        // Initialize failure links for depth-1 states
        for (int c = 0; c < ALPHABET_SIZE; c++) {
            if (transition[0][c] != 0) {
                failure[transition[0][c]] = 0;
                queue.add(transition[0][c]);
            }
        }

        // BFS to build failure links
        while (!queue.isEmpty()) {
            int state = queue.remove();
            for (int c = 0; c < ALPHABET_SIZE; c++) {
                int next = transition[state][c];
                if (next != -1) {
                    int f = failure[state];
                    while (transition[f][c] == -1)
                        f = failure[f];
                    f = transition[f][c];
                    failure[next] = f;
                    output[next] |= output[f];
                    queue.add(next);
                }
            }
        }
        return stateCount;
    }

    // Get next state for a given input character
    static int nextState(int current, char input) {
        int idx = input - 'a';
        while (transition[current][idx] == -1)
            current = failure[current];
        return transition[current][idx];
    }

    // Search all occurrences of patterns in text
    static void search(String[] words, int wordCount, String text) {
        buildMachine(words, wordCount);
        int state = 0;

        for (int i = 0; i < text.length(); i++) {
            state = nextState(state, text.charAt(i));
            if (output[state] == 0) continue;

            for (int j = 0; j < wordCount; j++) {
                if ((output[state] & (1 << j)) > 0) {
                    System.out.println("Word \"" + words[j] + "\" found at [" +
                            (i - words[j].length() + 1) + ", " + i + "]");
                }
            }
        }
    }

    // Driver
    public static void main(String[] args) {
        String[] patterns = { "he", "she", "hers", "his" };
        String text = "ahishers";
        search(patterns, patterns.length, text);
    }
}