package Pr5;

public class DeleteCommand implements Command {
    private UndoableStringBuilder receiver;
    private int start;
    private int end;
    private String deletedText;
    private String previousState;

    public DeleteCommand(UndoableStringBuilder receiver, int start, int end) {
        this.receiver = receiver;
        this.start = start;
        this.end = end;
        this.previousState = receiver.toString();
        this.deletedText = receiver.toString().substring(start, end);
    }

    @Override
    public void execute() {
        receiver.getStringBuilder().delete(start, end);
    }

    @Override
    public void undo() {
        receiver.getStringBuilder().setLength(0);
        receiver.getStringBuilder().append(previousState);
    }
}
