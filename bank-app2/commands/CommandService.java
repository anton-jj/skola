package commands;

public interface CommandService {
    void initializeCommand(Command command);
    void executeCommand(int id);
}
