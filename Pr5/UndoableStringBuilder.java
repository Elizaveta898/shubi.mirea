package Pr5;

import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<Command> commandHistory;
    private Stack<Command> redoHistory;

    public UndoableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.commandHistory = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    public UndoableStringBuilder(String str) {
        this.stringBuilder = new StringBuilder(str);
        this.commandHistory = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    // Делегированные методы с сохранением в истории

    public UndoableStringBuilder append(String str) {
        Command command = new AppendCommand(this, str);
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
        return this;
    }

    public UndoableStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public UndoableStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public UndoableStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public UndoableStringBuilder append(boolean b) {
        return append(String.valueOf(b));
    }

    public UndoableStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > length()) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        Command command = new InsertCommand(this, offset, str);
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        if (start < 0 || start > end || end > length()) {
            throw new StringIndexOutOfBoundsException();
        }
        Command command = new DeleteCommand(this, start, end);
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        if (start < 0 || start > end || end > length()) {
            throw new StringIndexOutOfBoundsException();
        }
        Command command = new ReplaceCommand(this, start, end, str);
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
        return this;
    }

    public UndoableStringBuilder reverse() {
        Command command = new ReverseCommand(this);
        command.execute();
        commandHistory.push(command);
        redoHistory.clear();
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        if (index < 0 || index >= length()) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return delete(index, index + 1);
    }

    public UndoableStringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public UndoableStringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public UndoableStringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    public UndoableStringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    // Операции undo/redo

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoHistory.push(command);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            commandHistory.push(command);
        }
    }

    public boolean canUndo() {
        return !commandHistory.isEmpty();
    }

    public boolean canRedo() {
        return !redoHistory.isEmpty();
    }

    public void clearHistory() {
        commandHistory.clear();
        redoHistory.clear();
    }

    // Делегированные методы без изменения истории

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
        stringBuilder.setLength(newLength);
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
        stringBuilder.setCharAt(index, ch);
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

    // Package-private метод для доступа к внутреннему StringBuilder из команд
    StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}