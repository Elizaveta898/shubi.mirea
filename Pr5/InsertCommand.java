package Pr5;

public class InsertCommand implements Command {
    private UndoableStringBuilder receiver;
    private int offset;
    private String text;
    private String previousState;

    public InsertCommand(UndoableStringBuilder receiver, int offset, String text) {
        this.receiver = receiver;
        this.offset = offset;
        this.text = text;
        this.previousState = receiver.toString();
    }

    @Override
    public void execute() {
        receiver.getStringBuilder().insert(offset, text);
    }

    @Override
    public void undo() {
        receiver.getStringBuilder().setLength(0);
        receiver.getStringBuilder().append(previousState);
    }
}