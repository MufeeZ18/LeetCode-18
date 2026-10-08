import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int letters = 0;

            // Pack as many words as fit, allowing one space between them.
            while (j < words.length &&
                   letters + words[j].length() + (j - i) <= maxWidth) {
                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            if (j == words.length || gaps == 0) {
                // Left-justify the last line or a single-word line.
                for (int k = i; k < j; k++) {
                    if (k > i) line.append(' ');
                    line.append(words[k]);
                }
                while (line.length() < maxWidth) line.append(' ');
            } else {
                // Spread spaces evenly, with extras on the left.
                int spaces = maxWidth - letters;
                int even = spaces / gaps;
                int extra = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int count = even + (k - i < extra ? 1 : 0);
                        for (int s = 0; s < count; s++) line.append(' ');
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
