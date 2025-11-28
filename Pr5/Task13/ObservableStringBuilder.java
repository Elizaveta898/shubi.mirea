package Pr5.Task13;

import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder implements StringBuilderObservable {
    private StringBuilder stringBuilder;
    private List<StringBuilderObserver> observers;

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.observers = new ArrayList<>();
    }

    public ObservableStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
        this.observers = new ArrayList<>();
    }

    public ObservableStringBuilder(CharSequence seq) {
        this.stringBuilder = new StringBuilder(seq);
        this.observers = new ArrayList<>();
    }

    public ObservableStringBuilder(int capacity) {
        this.stringBuilder = new StringBuilder(capacity);
        this.observers = new ArrayList<>();
    }

    // Реализация методов интерфейса Observable

    @Override
    public void addObserver(StringBuilderObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(StringBuilderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String operation, String oldValue, String newValue) {
        for (StringBuilderObserver observer : observers) {
            observer.update(this, operation, oldValue, newValue);
        }
    }

    // Делегированные методы с уведомлением наблюдателей

    public ObservableStringBuilder append(String str) {
        String oldValue = stringBuilder.toString();
        stringBuilder.append(str);
        notifyObservers("append", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public ObservableStringBuilder append(StringBuffer sb) {
        return append(sb.toString());
    }

    public ObservableStringBuilder append(CharSequence s) {
        return append(s.toString());
    }

    public ObservableStringBuilder append(CharSequence s, int start, int end) {
        String str = s.subSequence(start, end).toString();
        return append(str);
    }

    public ObservableStringBuilder append(char[] str) {
        return append(new String(str));
    }

    public ObservableStringBuilder append(char[] str, int offset, int len) {
        return append(new String(str, offset, len));
    }

    public ObservableStringBuilder append(boolean b) {
        return append(String.valueOf(b));
    }

    public ObservableStringBuilder append(char c) {
        return append(String.valueOf(c));
    }

    public ObservableStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public ObservableStringBuilder append(long lng) {
        return append(String.valueOf(lng));
    }

    public ObservableStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public ObservableStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public ObservableStringBuilder appendCodePoint(int codePoint) {
        String oldValue = stringBuilder.toString();
        stringBuilder.appendCodePoint(codePoint);
        notifyObservers("appendCodePoint", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        String oldValue = stringBuilder.toString();
        stringBuilder.delete(start, end);
        notifyObservers("delete", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder deleteCharAt(int index) {
        String oldValue = stringBuilder.toString();
        stringBuilder.deleteCharAt(index);
        notifyObservers("deleteCharAt", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String str) {
        String oldValue = stringBuilder.toString();
        stringBuilder.replace(start, end, str);
        notifyObservers("replace", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder insert(int index, char[] str, int offset, int len) {
        String oldValue = stringBuilder.toString();
        stringBuilder.insert(index, str, offset, len);
        notifyObservers("insert", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        String oldValue = stringBuilder.toString();
        stringBuilder.insert(offset, str);
        notifyObservers("insert", oldValue, stringBuilder.toString());
        return this;
    }

    public ObservableStringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public ObservableStringBuilder insert(int offset, StringBuffer sb) {
        return insert(offset, sb.toString());
    }

    public ObservableStringBuilder insert(int offset, CharSequence s) {
        return insert(offset, s.toString());
    }

    public ObservableStringBuilder insert(int offset, CharSequence s, int start, int end) {
        String str = s.subSequence(start, end).toString();
        return insert(offset, str);
    }

    public ObservableStringBuilder insert(int offset, char[] str) {
        return insert(offset, new String(str));
    }

    public ObservableStringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public ObservableStringBuilder insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public ObservableStringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public ObservableStringBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public ObservableStringBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public ObservableStringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    public ObservableStringBuilder reverse() {
        String oldValue = stringBuilder.toString();
        stringBuilder.reverse();
        notifyObservers("reverse", oldValue, stringBuilder.toString());
        return this;
    }

    // Делегированные методы без уведомления (вспомогательные)

    public int length() {
        return stringBuilder.length();
    }

    public int capacity() {
        return stringBuilder.capacity();
    }

    public void ensureCapacity(int minimumCapacity) {
        stringBuilder.ensureCapacity(minimumCapacity);
    }

    public void trimToSize() {
        stringBuilder.trimToSize();
    }

    public void setLength(int newLength) {
        String oldValue = stringBuilder.toString();
        stringBuilder.setLength(newLength);
        if (!oldValue.equals(stringBuilder.toString())) {
            notifyObservers("setLength", oldValue, stringBuilder.toString());
        }
    }

    public char charAt(int index) {
        return stringBuilder.charAt(index);
    }

    public int codePointAt(int index) {
        return stringBuilder.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return stringBuilder.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return stringBuilder.codePointCount(beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return stringBuilder.offsetByCodePoints(index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public void setCharAt(int index, char ch) {
        String oldValue = stringBuilder.toString();
        stringBuilder.setCharAt(index, ch);
        if (!oldValue.equals(stringBuilder.toString())) {
            notifyObservers("setCharAt", oldValue, stringBuilder.toString());
        }
    }

    public String substring(int start) {
        return stringBuilder.substring(start);
    }

    public String substring(int start, int end) {
        return stringBuilder.substring(start, end);
    }

    public CharSequence subSequence(int start, int end) {
        return stringBuilder.subSequence(start, end);
    }

    public int indexOf(String str) {
        return stringBuilder.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        return stringBuilder.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        return stringBuilder.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return stringBuilder.lastIndexOf(str, fromIndex);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    // Дополнительные методы для управления наблюдателями

    public int getObserverCount() {
        return observers.size();
    }

    public void clearObservers() {
        observers.clear();
    }

    public List<StringBuilderObserver> getObservers() {
        return new ArrayList<>(observers);
    }
}
