package com.testvagrant.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import com.jayway.jsonpath.JsonPath;

public class Common {
//	public static Properties testproperties ;
//	static String Propertiesfilename = "propertyfiles/testdata.properties";
//	static String JSONfilename="";
//	static String JSONPathExtratorCountry="";
//	static String JSONPathExtratorRole="";
	//readPropertyFile(Propertiesfilename);
	
//	JSONfilename = testproperties.getProperty();
	
	/**This method used to read the property file 
	 * @param propertyfilname
	 * @author LOKESH L R Jan032022
	 * @throws FileNotFoundException 
	 * **/
//	public static void readPropertyFile() throws FileNotFoundException  {
//		FileInputStream fin=new FileInputStream(Propertiesfilename);
//		testproperties =new Properties();
//
//		if(fin != null){
//			try {
//				testproperties.load(fin);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	/**This method will get Data based on jsonPathToExactractor from json String
	 * @param Json file path 
	 * @param Json path extractor value
	 * @author LOKESH L R Jan032022
	 * @return the List of String based on jsonPathToExactractor
	 * @throws IOException 
	 */
	public static ArrayList<String> getData(String jsonFilePath,String jsonPathToExtractor) throws IOException {
		File file = new File(jsonFilePath);
		String json = new String(Files.readAllBytes(file.toPath()));
		ArrayList<String> data = JsonPath.parse(json).read(jsonPathToExtractor);
		return data;
	}

	
}
