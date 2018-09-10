package my.project.automation.wolfram_alpha;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Prop {

	private static java.util.Properties usrProps;
	
	private Prop() {
		}
	
	static {
		FileInputStream in = null;
		usrProps = new java.util.Properties();
		try {
			final File propertiesFile = new File("./src/test/resources/user.properties");
			if (propertiesFile.exists()) {
				in = new FileInputStream(propertiesFile);
				usrProps.load(in);
			} else {
				System.out.println("Faild reading application.properties");
				System.exit(1);
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage()+"Something wrong happend here");
		}

	}
	
	public static String getUserProperty(String key) {
		return usrProps.getProperty(key);
	}

}
