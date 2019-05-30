package test.file;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    File file;

    FileOutputStream outputStream;
    FileInputStream inputStream;
    String path="D:\\SW-VishalPandya-DATA\\JavaProgram\\Property";
    String fileName = "config.properties";
    Properties properties = new Properties();

    public static void main(String[] args) throws Exception {


        PropertiesFile propertiesFile = new PropertiesFile();
        propertiesFile.createPropertyFile();
        propertiesFile.readPropertyFile();

    }

    private void createPropertyFile() throws IOException {
        file = new File(path + "\\" + fileName);

        file.createNewFile();

        properties.setProperty("UserName", "Vishal Pandya");
        properties.setProperty("Emp Id", "123");
        properties.setProperty("Phone", "1234567890");

        outputStream = new FileOutputStream(file);
        properties.store(outputStream, "User information");
        outputStream.close();
        System.out.println("After saving properties: " + properties);
    }

    private void readPropertyFile() throws Exception{

        inputStream=new FileInputStream(file);
        properties.load(inputStream);

        System.out.println("User name is: "+properties.getProperty("UserName"));
        System.out.println("Emp id is: "+properties.getProperty("Emp Id"));
        System.out.println("Phone is: "+properties.getProperty("Phone"));

        inputStream.close();

    }

}

