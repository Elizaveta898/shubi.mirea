package Pr5;

public class ReplaceCommand implements Command {
    private UndoableStringBuilder receiver;
    private int start;
    private int end;
    private String newText;
    private String replacedText;
    private String previousState;

    public ReplaceCommand(UndoableStringBuilder receiver, int start, int end, String newText) {
        this.receiver = receiver;
        this.start = start;
        this.end = end;
        this.newText = newText;
        this.previousState = receiver.toString();
        this.replacedText = receiver.toString().substring(start, end);
    }

    @Override
    public void execute() {
        receiver.getStringBuilder().replace(start, end, newText);
    }

    @Override
    public void undo() {
        receiver.getStringBuilder().setLength(0);
        receiver.getStringBuilder().append(previousState);
    }
}