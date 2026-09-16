class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the string into individual words
        String[] words = s.split(" ");
        
        // If counts do not match, pattern cannot be followed
        if (words.length != pattern.length()) {
            return false;
        }

        // Map from pattern character to word
        HashMap<Character, String> charToWord = new HashMap<>();
        
        // Map from word to pattern character
        HashMap<String, Character> wordToChar = new HashMap<>();

        // Traverse pattern and words together
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);   // Current pattern character
            String word = words[i];        // Current word

            // If character is already mapped, it must map to same word
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                // Otherwise, create the mapping
                charToWord.put(ch, word);
            }

            // If word is already mapped, it must map to same character
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                // Otherwise, create the reverse mapping
                wordToChar.put(word, ch);
            }
        }

        // All mappings were consistent
        return true;
    }
}
