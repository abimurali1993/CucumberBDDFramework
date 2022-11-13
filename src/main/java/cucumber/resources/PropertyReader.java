package cucumber.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Property Reader class
 * @author abimu
 *
 */
public class PropertyReader {
	
	/**
	 * Method to read values from the property file
	 * @param file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readPropertyValue(String file, String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis = null;
		if (file.contains("global"))
		{
			fis= new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\GlobalParameters.properties"));
		}
		
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}

}
