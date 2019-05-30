package test.file;

import javax.xml.transform.sax.SAXSource;
import java.io.*;

public class FileTest {

    private File file;
    private FileInputStream fileInputStream;
    private String path=System.getProperty("user.dir")+"\\";
    private String fileName="test1.txt";

    private String dirName="Files";



    public static void main(String[] args) throws IOException {

        FileTest test=  new FileTest();
        test.createFile();
        test.writeFile();
        test.readFile();

    }

    private FileTest(){

        file = new File(path+ "\\"+ dirName);
        if(!file.exists()){
            file.mkdir();

            System.out.println("The directory is created");
        }else{
            System.out.println("The directory already exists");
        }

    }

    private void createFile(){
        file = new File(path+ "\\"+ dirName + "\\"+ fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("File is created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File is already exists in the "+file.getParent());
        }
    }

    private void writeFile(){

        try {
            FileWriter writer = new FileWriter(path+ "\\"+ dirName + "\\"+ fileName);
            writer.write("Hi, I am Vishal Pandya");
            System.out.println("Successfully written");
            writer.close();

        } catch (IOException e) {
            System.out.println("Some issue is there");
        }
    }

    private void readFile() throws  IOException {
        try {

            FileReader reader;
            if (file.length() == 0) {
                System.out.println("File is blank");
            } else {
                reader = new FileReader(path + "\\" + dirName + "\\" + fileName);
                int i;
                while ((i = reader.read()) != -1) {
                    System.out.print((char) i);
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
