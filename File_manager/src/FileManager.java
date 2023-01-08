import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.readAllLines;

public class FileManager {

    public File createFile(String fileName){
        File file = new File(fileName);
        try {
            if (file.createNewFile()){
                System.out.println("File created");
            }
            else{
                System.out.println("File with that name exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public void writeToFile(File file, int number){
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            fileWriter.write(number + ",");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected ArrayList<Integer> createIntArrayFromFile(File file) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            for (String line : readAllLines(Paths.get(file.getName()))) {
                for (String word : line.split(","))
                    if (isNumeric(word)){
                        arrayList.add(Integer.valueOf(word));
                    }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }


}
