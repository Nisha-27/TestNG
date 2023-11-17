package annotationDemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigExample {

	public static void main(String[] args) throws IOException {

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		
		FileReader fr = new FileReader(file);
		
		Properties prop = new Properties();
		
		prop.load(fr);
		
		System.out.println(prop.getProperty("browser"));
		
		System.out.println(prop.getProperty("URL"));
	
	}
}
