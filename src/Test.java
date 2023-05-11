import java.io.*;

public class Test {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\Public\\Documents");

        String[] fileList = f.list();

        for(String str : fileList){
            if(str.endsWith(".txt")){
                try {
                    FileReader reader = new FileReader("C:\\Users\\Public\\Documents\\" + str);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        System.out.println(line);
                    }
                    reader.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

