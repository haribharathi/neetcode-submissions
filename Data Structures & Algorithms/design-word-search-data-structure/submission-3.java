class WordDictionary {

    Trie root = null;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (Character c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Trie());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(Trie node, String word, Integer index) {
        //System.out.println(word.length() + " " + index);
        if (word.length() == index) {
            return node.isEnd;
        }
        if (word.charAt(index) == '.') {
            for (Map.Entry<Character, Trie> entry : node.children.entrySet()) {
                boolean val = search(entry.getValue(), word, index + 1);
                if (val ==true) {
                    return true;
                }
            }
        } else {
            if (node.children.containsKey(word.charAt(index))) {
                boolean val = search(node.children.get(word.charAt(index)), word, index + 1);
                if (val ==true) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {
    public HashMap<Character, Trie> children = new HashMap<>();
    public boolean isEnd = false;
}
