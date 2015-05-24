import java.io.*;
import java.util.*;
public class Main
{
	static String defualtDir="";
	public static void main(String[] args)
	{
		defualtDir+="C:\\Users\\Anoos\\Desktop";
		 String userCommand="";
		 CommandsImplementation.clear();
		while(true)
		{
			 System.out.print("->");
		     userCommand=new Scanner(System.in).nextLine();
		     //userCommand=userCommand.toLowerCase();
		     if(userCommand.equals("exit"))
		    	 break;
		     String[] commands={""};
		     if(userCommand.contains(";"))
		     {
		    	 commands=getCommands(userCommand);
		     }
		     else
		    	 commands[0]=userCommand;
		     for (String string : commands) {
		    	 byte state=0;
		    	 if(string.contains(">"))
		    		 state=1;
		    	 else
		    		 if(string.contains(">>"))
		    			 state=2;
				if(!excute(string,state))
				{
					System.out.println("-> "+string+" is not a command");
					break;
				}
			}
		}
	}
	static public String[] getCommands(String userCommand)
	{
		String[] commands={""};
		int i=0;
		while(userCommand.contains(";"))
		{
			commands[i]=userCommand.substring(0, userCommand.charAt(';'));
			userCommand=userCommand.substring(userCommand.charAt(';')+1, userCommand.length());
			i++;
		}
		return commands;
	}
    static boolean excute(String command,byte state)
    {
    	if(command.equals("clear"))//Clear method
    		CommandsImplementation.clear();
    	else
    		if(command.indexOf("cd")==0)//cd method
    		{
    			if(command.equals("cd"))
    				CommandsImplementation.cd();
    			else
    			{
    				String[] tempdir=command.split(" ");
    				if(new File(tempdir[1]).isDirectory())
    				{
    					CommandsImplementation.cd(tempdir[1]);
    					System.out.println("->"+tempdir[1]);
    				}
    				else
    				{
    					System.out.println("->"+tempdir+" is not such a directory");
    				}
    			}
    		}
    		else
    			if(command.equals("pwd"))//pwd method
                    System.out.println("->"+CommandsImplementation.pwd());
    			else
    				if(command.indexOf("ls")==0)//ls method
    	    		{
    	    			if(command.equals("ls"))
    	    			{
    	    				String[] fileList=CommandsImplementation.ls(defualtDir);
    	    				System.out.println("->");
    	    				for (String string : fileList) {
    	    					System.out.print(string+"     ");
							}
    	    				System.out.println();
    	    			}
    	    			else
    	    			{
    	    				String[] tempdir=command.split(" ");
    	    				if(new File(tempdir[1]).isDirectory())
    	    				{
    	    					String[] fileList=CommandsImplementation.ls(tempdir[1]);
        	    				System.out.println("->");
        	    				for (String string : fileList) {
        	    					System.out.print(string+"     ");
    							}
        	    				System.out.println();
    	    				}
    	    				else
    	    				{
    	    					System.out.println("->"+tempdir[1]+" is not such a directory");
    	    				}
    	    			}
    	    		}
    				else
    				{
    					if(command.indexOf("mkdir")==0)//mkdire method
    					{
    						String[] tempdir=command.split(" ");
    	    				if(new File(tempdir[1].substring(0, tempdir[1].lastIndexOf("\\"))).isDirectory())
    	    				{
    	    					if(CommandsImplementation.mkdir(tempdir[1]))
    	    						System.out.println("->"+tempdir[1]+" has been Created\n");
    	    					else
    	    						System.out.println("->"+tempdir[1]+" has been NOT Created");
    	    				}
    	    				else
    	    				{
    	    					System.out.println("->"+tempdir[1]+" is not such a directory\n");
    	    				}
    					}
    					else
    					{
    						if(command.indexOf("rmdir")==0)//rmdire method
        					{
        						String[] tempdir=command.split(" ");
        	    				if(new File(tempdir[1]).isDirectory())
        	    				{
        	    					if(CommandsImplementation.rmdir(tempdir[1]))
        	    						System.out.println("->"+tempdir[1]+" has been deleted\n");
        	    					else
        	    						System.out.println("->"+tempdir[1]+" has been NOT deleted");
        	    				}
        	    				else
        	    				{
        	    					System.out.println("->"+tempdir[1]+" is not such a directory\n");
        	    				}
        					}
    						else
    						{
    							if(command.indexOf("cp")==0)//cp method
            					{
            						String[] tempdir=command.split(" ");
            	    				if(((new File(tempdir[1]).isDirectory())||(new File(tempdir[1]).isFile()))&&(new File(tempdir[2].substring(0, tempdir[2].lastIndexOf("\\"))).isDirectory()))
            	    				{
            	    					try {
											CommandsImplementation.cp(new File(tempdir[1]),new File(tempdir[2]));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											System.out.println("->Not processed \n");
										}
            	    				}
            	    				else
            	    				{
            	    					System.out.println("->"+tempdir[1]+" is not such a directory\n");
            	    				}
            					}
    							else
    							{
    								if(command.indexOf("mv")==0)//mv method
                					{
                						String[] tempdir=command.split(" ");
                	    				if(((new File(tempdir[1]).isDirectory())||(new File(tempdir[1]).isFile()))&&(new File(tempdir[2].substring(0, tempdir[2].lastIndexOf("\\"))).isDirectory()))
                	    				{
                	    					try {
    											CommandsImplementation.mv(new File(tempdir[1]),new File(tempdir[2]));
    										} catch (IOException e) {
    											// TODO Auto-generated catch block
    											System.out.println("->Not processed \n");
    										}
                	    				}
                	    				else
                	    				{
                	    					System.out.println("->"+tempdir[1]+" is not such a directory\n");
                	    				}
                					}
    								else
    								{
    									if(command.indexOf("rm")==0)//rm method
                    					{
                    						String[] tempdir=command.split(" ");
                    	    				if((new File(tempdir[1]).isDirectory())||(new File(tempdir[1]).isFile()))
                    	    				{
                    	    					try {
        											CommandsImplementation.rm(new File(tempdir[1]));
        										} catch (IOException e) {
        											// TODO Auto-generated catch block
        											System.out.println("->Not processed \n");
        										}
                    	    				}
                    	    				else
                    	    				{
                    	    					System.out.println("->"+tempdir[1]+" is not such a directory\n");
                    	    				}
                    					}
    									else
    									{
    										if(command.indexOf("date")==0)
    										{
    											Date det=new Date();
    											System.out.println("->"+det.toString());
    										}
    										else
    										{
    											if(command.indexOf("cat")==0)//cat method
    	                    					{
    												String[] tempdir=command.split(" ");
    												if(tempdir.length==3)
    												{
    													try 
        												{
        	                    	    				    if((new File(tempdir[1]).isFile())&&(new File(tempdir[2]).isFile()))
        	                    	    				    {
        	        											  CommandsImplementation.cat(tempdir[1],tempdir[2]);
        	        									    }
        												}
        												catch (IOException e) {
    	        											// TODO Auto-generated catch block
    	        											System.out.println("->Not processed \n");
        	                    	    				}
    												}
    												else
    												try 
    												{
    	                    	    				    if((new File(tempdir[1]).isFile()))
    	                    	    				    {
    	        											  CommandsImplementation.cat(tempdir[1]);
    	        									    }
    												}
    												catch (IOException e) {
	        											// TODO Auto-generated catch block
	        											System.out.println("->Not processed \n");
    	                    	    				}
    	                    					}
    											else
    											{
    												if(command.indexOf("args")==0)//args method
    		                    					{
    		                    						String[] tempdir=command.split(" ");
    		                    	    				if((tempdir.length==2)&&(!CommandsImplementation.args(tempdir[1])))
    		                    	    				{
    		                    	    					System.out.println("It's Not such a command!");
    		                    	    				}
    		                    					}
    											}
    										}
    									}
    								}
    							}
    						}
    					}
    				}
    	return true;
    }
    static public String[]splitCommand(String command)
    {
    	String[] tempdir=command.split(" "),temp=new String[10];
    	int j=0;
    	for (int i = 0; i < tempdir.length; i++) {
			if(!tempdir[i].equals(" "))
			{
				temp[j]+=tempdir[i];
				j++;
			}
		}
        return temp;
    }
}
