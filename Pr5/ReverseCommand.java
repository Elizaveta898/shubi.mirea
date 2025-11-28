package Pr5;

public class ReverseCommand implements Command {
    private UndoableStringBuilder receiver;
    private String previousState;

    public ReverseCommand(UndoableStringBuilder receiver) {
        this.receiver = receiver;
        this.previousState = receiver.toString();
    }

    @Override
    public void execute() {
        receiver.getStringBuilder().reverse();
    }

    @Override
    public void undo() {
        receiver.getStringBuilder().setLength(0);
        receiver.getStringBuilder().append(previousState);
    }
}
