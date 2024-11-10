package commands;

public abstract class Command{
	private final String name;
	private final String description;
	private int commandId;
	protected static int idCounter = 1;

	public Command(String description, String name){
		this.name = name;
		this.description = description;
		this.commandId = idCounter++;
	}

	public abstract void execute();

	public String getName(){ return name; }

	public String getDescription() { return description; }

	public int getCommandId(){ return commandId; }
}
