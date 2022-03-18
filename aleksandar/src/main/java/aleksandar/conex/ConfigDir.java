package aleksandar.conex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigDir {
	private Properties props;
	private static ConfigDir conf;
	
	public ConfigDir() throws IOException {
		props = new Properties();
		InputStream is = getClass().getResourceAsStream("properties/conex.properties");
//		System.out.println(is.read());
		props.load(is);
	}
	
	public static ConfigDir getInstance() throws IOException {
		if (conf == null) {
			conf = new ConfigDir();
		}
		return conf;
	}
	
	public String getProperty(String propiedad) {
		return props.getProperty(propiedad);
	}
}
