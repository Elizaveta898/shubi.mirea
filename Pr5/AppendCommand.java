package Pr5;

public class AppendCommand implements Command {
    private UndoableStringBuilder receiver;
    private String text;
    private String previousState;

    public AppendCommand(UndoableStringBuilder receiver, String text) {
        this.receiver = receiver;
        this.text = text;
        this.previousState = receiver.toString();
    }

    @Override
    public void execute() {
        receiver.getStringBuilder().append(text);
    }

    @Override
    public void undo() {
        receiver.getStringBuilder().setLength(0);
        receiver.getStringBuilder().append(previousState);
    }
}