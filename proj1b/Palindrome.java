public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }

        return d;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        } else {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            return (first == last)
                    && isPalindrome(word.substring(1, word.length() -1 ));
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        } else {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            return cc.equalChars(first, last)
                    && isPalindrome(word.substring(1, word.length() -1 ), cc);
        }
    }
}
