package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Trie {

    private TrieNode rootNode = new TrieNode();

    public void insert(String word) {
        TrieNode currentNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            currentNode = currentNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        currentNode.setTerminal(true);
    }

    public boolean find(String word) {
        TrieNode currentNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            TrieNode node = currentNode.getChildNodes().get(character);
            if (node == null) {
                return false;
            }
            currentNode = node;
        }
        return currentNode.isTerminal();
    }

    public void delete(String word) {
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode currentNode, String word, int index) {
        char character = word.charAt(index);

        if (!currentNode.getChildNodes().containsKey(character)) {
            throw new NoSuchElementException("No element");
        }

        TrieNode childNode = currentNode.getChildNodes().get(character);
        index++;
        if (index == word.length()) {
            if (!childNode.isTerminal()) {
                throw new NoSuchElementException("No element");
            }
            childNode.setTerminal(false);

            if (childNode.getChildNodes().isEmpty())
                currentNode.getChildNodes().remove(character);
        } else {
            delete(childNode, word, index);
            if (!childNode.isTerminal() && childNode.getChildNodes().isEmpty()) {
                currentNode.getChildNodes().remove(character);
            }
        }
    }


    private static class TrieNode {

        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean terminal;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        boolean isTerminal() {
            return this.terminal;
        }

        void setTerminal(boolean terminal) {
            this.terminal = terminal;
        }
    }
}

