package optitex.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	public String readFileData(String key) throws IOException {
		String value = null;
		FileInputStream input = new FileInputStream("./src/optitex.data/configuration.properties");
		Properties prop = new Properties();
		prop.load(input);
		value = prop.getProperty(key);
		return value;
		
		
	
	}
}
