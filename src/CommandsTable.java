import java.util.Hashtable;


public class CommandsTable {
	Hashtable<String, String> commandsTable=new Hashtable<>(17);
	
	public CommandsTable() {
		super();
		fillTable();
	}

	private void fillTable()
	{
		commandsTable.put("clear","No Specific parameters");
		commandsTable.put("cd","1-No Parameter to back into root dirctory\n->2-dirctory for destenation");
		commandsTable.put("pwd","No parametars");
		commandsTable.put("ls","1-No Parameter to list current dirction\n->2-dirction for listing");
		commandsTable.put("mkdir","one directary for make it new dirctory");
		commandsTable.put("rmdir","one directary for delete it");
		commandsTable.put("cp","tow parameters for copying file or dirctory from first one to the second");
		commandsTable.put("mv","tow parameters for moving file dirctory from first one to the second");
		commandsTable.put("rm","one parameter dirctory for deleting it");
		commandsTable.put("date","no parameter");
		commandsTable.put("cat","1-one dirctory for display it\n->2-tow parameters files dirctory for moving data from first one to the second");
		commandsTable.put("help","No parameters");
		commandsTable.put("args","one parameter command for display its parameters");
		commandsTable.put("more","file dirctory");
		commandsTable.put("less","file dirctory");
		commandsTable.put("find","tow parameeters <fileName> <directory> for searching");
		commandsTable.put("grep","tow parameeters <text><fileName> for searching text in file");
	}
	static public String get(String command)
	{
		String temp=CommandsTable.get(command);
		 return  temp;
	}
}
