package data.structures;

import java.util.*;

/**
 * Trie (Prefix Tree) Implementation
 *
 * A Trie is a tree-like data structure used to store a dynamic set of strings.
 * It is commonly used for efficient retrieval of strings with common prefixes.
 *
 * Key characteristics:
 * - Efficient for prefix-based operations
 * - Each node represents a character
 * - Root represents empty string
 * - Time Complexity: O(m) where m is string length for insert/search
 * - Space Complexity: O(N*M) where N is number of strings, M is average length
 *
 * Operations:
 * - Insert: Add a word to the trie
 * - Search: Check if a word exists in the trie
 * - StartsWith: Check if any word starts with given prefix
 */
public class Trie {

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie
     *
     * @param word Word to insert
     */
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }

        current.isEndOfWord = true;
    }

    /**
     * Searches for a word in the trie
     *
     * @param word Word to search for
     * @return True if word exists, false otherwise
     */
    public boolean search(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }

        return current.isEndOfWord;
    }

    /**
     * Checks if any word in the trie starts with the given prefix
     *
     * @param prefix Prefix to check
     * @return True if any word starts with prefix, false otherwise
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }

        return true;
    }

    /**
     * Deletes a word from the trie
     *
     * @param word Word to delete
     * @return True if word was deleted, false if word not found
     */
    public boolean delete(String word) {
        return deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Word not found
            }
            current.isEndOfWord = false;
            return current.children.isEmpty(); // Return true if no children
        }

        char ch = word.charAt(index);
        TrieNode child = current.children.get(ch);

        if (child == null) {
            return false; // Word not found
        }

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }

        return false;
    }

    /**
     * Returns all words in the trie
     */
    public List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        getAllWordsHelper(root, new StringBuilder(), words);
        return words;
    }

    private void getAllWordsHelper(TrieNode node, StringBuilder currentWord, List<String> words) {
        if (node.isEndOfWord) {
            words.add(currentWord.toString());
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            currentWord.append(entry.getKey());
            getAllWordsHelper(entry.getValue(), currentWord, words);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }

    /**
     * Main method to demonstrate Trie operations
     */
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("bat");
        trie.insert("ball");

        // Search operations
        System.out.println("Search 'apple': " + trie.search("apple"));
        System.out.println("Search 'app': " + trie.search("app"));
        System.out.println("Search 'appl': " + trie.search("appl"));
        System.out.println("Search 'bat': " + trie.search("bat"));
        System.out.println("Search 'ball': " + trie.search("ball"));
        System.out.println("Search 'cat': " + trie.search("cat"));

        // Prefix operations
        System.out.println("Starts with 'app': " + trie.startsWith("app"));
        System.out.println("Starts with 'ba': " + trie.startsWith("ba"));
        System.out.println("Starts with 'ca': " + trie.startsWith("ca"));

        // Get all words
        System.out.println("All words in trie: " + trie.getAllWords());

        // Delete operation
        System.out.println("Delete 'app': " + trie.delete("app"));
        System.out.println("Search 'app' after delete: " + trie.search("app"));
        System.out.println("Search 'apple' after delete: " + trie.search("apple"));
    }
}
