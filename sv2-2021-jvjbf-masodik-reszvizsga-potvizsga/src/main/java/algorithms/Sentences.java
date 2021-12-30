package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sentences {
    private List<String> listOfSentences = new ArrayList<>();

    public void addSentence(String sentence) {
        validateSentence(sentence);
        listOfSentences.add(sentence);
    }

    public String findLongestSentence() {
        checkList();
        String tmp = listOfSentences.get(0);
        for (String s : listOfSentences) {
            if (s.length() > tmp.length()) {
                tmp = s;
            }
        }
        return tmp;
    }

    public List<String> getSentences() {
        return new ArrayList<>(listOfSentences);
    }

    private void validateSentence(String sentence) {
        if (Character.isLowerCase(sentence.charAt(0)))  {
            throw new IllegalArgumentException("Sentence must start with capital!");
        }
        if (!isPunctuationMark(sentence.charAt(sentence.length() - 1))) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        }
    }

    private boolean isPunctuationMark(char c) {
        if (c == '.' || c == '!' || c == '?') {
            return true;
        }
        return false;
    }

    private void checkList() {
        if (listOfSentences.isEmpty()) {
            throw new IllegalStateException("There is no such sentences.");
        }
    }
}
