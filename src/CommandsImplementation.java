import java.io.*;
import java.util.*;
public class CommandsImplementation 
{
	static public boolean mkdir(String dir)
	{
		return new File(dir).mkdir();
	}
	static public boolean rmdir(String dir)
	{
		return new File(dir).delete();
	}
	static public String[] ls(String dir)
	{
		File file=new File(dir);
		return file.list();
	}
	static public void cp(File sourceLocation , File targetLocation)
    throws IOException 
	{

        if (sourceLocation.isDirectory())
        {
            if (!targetLocation.exists()) 
            {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            String newPath=targetLocation.getPath()+"\\"+sourceLocation.getName();
            new File(newPath).mkdirs();
            for (int i=0; i<children.length; i++) 
            {
                cp(new File(sourceLocation, children[i]),
                        new File(new File(newPath), children[i]));
            }
        } 
        else 
        {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) 
            {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
	static public void mv(File sourceLocation , File targetLocation)
		    throws IOException 
			{

		        if (sourceLocation.isDirectory())
		        {
		            if (!targetLocation.exists()) 
		            {
		                targetLocation.mkdir();
		            }

		            String[] children = sourceLocation.list();
		            String newPath=targetLocation.getPath()+"\\"+sourceLocation.getName();
		            new File(newPath).mkdirs();
		            for (int i=0; i<children.length; i++) 
		            {
		                mv(new File(sourceLocation, children[i]),
		                        new File(new File(newPath), children[i]));
		            }
		            sourceLocation.delete();
		        } 
		        else 
		        {

		            InputStream in = new FileInputStream(sourceLocation);
		            OutputStream out = new FileOutputStream(targetLocation);

		            // Copy the bits from instream to outstream
		            byte[] buf = new byte[1024];
		            int len;
		            while ((len = in.read(buf)) > 0) 
		            {
		                out.write(buf, 0, len);
		            }
		            in.close();
		            sourceLocation.delete();
		            out.close();
		        }
		    }
	static public void rm(File sourceLocation)
		    throws IOException 
			{

		        if (sourceLocation.isDirectory())
		        {
		            String[] children = sourceLocation.list();
		            for (int i=0; i<children.length; i++) 
		            {
		                rm(new File(sourceLocation, children[i]));
		            }
		            sourceLocation.delete();
		        } 
		        else 
		        {
		            sourceLocation.delete();
		        }
		    }
    static public void clear()
	{
		for(int i=0;i<6;i++)
		System.out.println();
	}
	static public void cd(String dir)
	{
		if(new File(dir).isDirectory())
		{
			Main.defualtDir=dir;
		}
	}
	static public void cd()
	{
		
			Main.defualtDir="C:\\Users\\Anoos\\Desktop";
	}
	static public String pwd()
	{
		return Main.defualtDir;
	}
    static public void cat(String path)throws IOException
    {
    	FileReader file=new FileReader(path);
    	BufferedReader buffer=new BufferedReader(file);
    	long fileSize=new File(path).length();
		long current=0;
		while(current<fileSize)
		{
			   String text=buffer.readLine();
			   System.out.print(text);
			   if((!text.equals('\n'))||(!text.equals('\r')))
				   System.out.println();
			   current+=text.length()+1;
		}
		buffer.close();
    }
    static public void cat(String firstFile,String secondFile) throws IOException
    {
    	 InputStream in = new FileInputStream(firstFile);
         OutputStream out = new FileOutputStream(secondFile);

         // Copy the bits from instream to outstream
         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) 
         {
             out.write(buf, 0, len);
         }
         in.close();
         out.close();
    }
    static public boolean args(String command)
    {
    	CommandsTable table=new CommandsTable();
    	String temp=table.get(command);
    	if(temp==null)
    		return false;
    	System.out.println("->"+temp);
    	return true;
    }
}
