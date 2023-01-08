import java.io.File;
import java.util.List;

public class OperationsOnFile extends FileManager{

    public int sumAll(File file){
        List<Integer> arraylist = createIntArrayFromFile(file);
        return arraylist.stream().mapToInt(value -> value).sum();
    }

//    public int sumTwo(int number1,int number2){
//
//    }
}
