package Pr5.Task13;

import java.util.ArrayList;
import java.util.List;

public class CensorshipObserver implements StringBuilderObserver {
    private List<String> forbiddenWords;

    public CensorshipObserver() {
        this.forbiddenWords = new ArrayList<>();
    }

    public CensorshipObserver(List<String> forbiddenWords) {
        this.forbiddenWords = new ArrayList<>(forbiddenWords);
    }

    public void addForbiddenWord(String word) {
        if (!forbiddenWords.contains(word.toLowerCase())) {
            forbiddenWords.add(word.toLowerCase());
        }
    }

    @Override
    public void update(ObservableStringBuilder stringBuilder, String operation, String oldValue, String newValue) {
        for (String word : forbiddenWords) {
            if (newValue.toLowerCase().contains(word)) {
                System.out.println("⚠️  ЦЕНЗУРА: Обнаружено запрещенное слово: '" + word + "'");
                System.out.println("   Контекст: ..." +
                        newValue.toLowerCase().substring(
                                Math.max(0, newValue.toLowerCase().indexOf(word) - 10),
                                Math.min(newValue.length(), newValue.toLowerCase().indexOf(word) + word.length() + 10)
                        ) + "...");
            }
        }
    }
}