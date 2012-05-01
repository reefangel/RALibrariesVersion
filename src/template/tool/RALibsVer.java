/**
 * you can put a one sentence description of your tool here.
 *
 * ##copyright##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author		##author##
 * @modified	##date##
 * @version		##version##
 */

 package template.tool;
 
 import processing.app.*;
 import processing.app.tools.*;
import java.io.*;
 
 
 public class RALibsVer implements Tool {
	 Editor editor;
 
 // when creating a tool, the name of the main class which implements Tool
 // must be the same as the value defined for project.name in your build.properties
 
 
	public String getMenuTitle() {
		return "Reef Angel Libraries Version";
	}
 
	public void init(Editor theEditor) {
		this.editor = theEditor;
	}
 
	public void run() {

		try
		{
			editor.getBase();
			String libfile=Base.getSketchbookFolder().getPath() + "/libraries/ReefAngel/ReefAngel.h";
//			if (isWindows()) {
//				//System.out.println("This is Windows");
//				libfile=System.getProperty("user.home") + "/Documents/Arduino/libraries/ReefAngel/ReefAngel.h";
//			} else if (isMac()) {
//				//System.out.println("This is Mac");
//				libfile=System.getProperty("user.home") + "/Documents/Arduino/libraries/ReefAngel/ReefAngel.h";
//			} else if (isUnix()) {
//				//System.out.println("This is Unix or Linux");
//				libfile=System.getProperty("user.home") + "/Documents/Arduino/libraries/ReefAngel/ReefAngel.h";
//			} else {
//				System.out.println("Your OS is not supported!!");
//			}

			if (libfile!="")
			{
				// Open the file that is the first 
				// command line parameter
				FileInputStream fstream = new FileInputStream(libfile);
				// Get the object of DataInputStream
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				String strversion="";
				//Read File Line By Line
				while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
					//System.out.println (strLine);
					if (strLine.indexOf("ReefAngel_Version ")>0)
					{
						strversion=strLine.substring(strLine.indexOf("ReefAngel_Version ")+19);
						strversion=strversion.replace("\"", "");
					}
				}
				//Close the input stream
				in.close();
				//System.out.println(System.getProperty("os.name"));
				//System.out.println("Opening File: "+libfile);
				if (strversion!="")
				{
					System.out.println("Reef Angel Libraries Found: Development");
					System.out.println("Reef Angel Libraries Version: "+strversion);
				}
				else
				{
					System.out.println("Reef Angel Libraries Found: none");
				}
					
			}
		}
		catch (Exception e) //Catch exception if any
		{	
		   System.err.println("Error: " + e.getMessage());
		}
	}

	public static boolean isWindows() {
		 
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Mac
		return (os.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
 
	}
 
	public static boolean isSolaris() {
 
		String os = System.getProperty("os.name").toLowerCase();
		// Solaris
		return (os.indexOf("sunos") >= 0);
 
	}

 }



