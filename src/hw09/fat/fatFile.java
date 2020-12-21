package hw09.fat;

import java.time.LocalDateTime;
import hw09.fs.*;

public class fatFile extends fatElement {

    public fatFile(fatDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){

        super(parent, name, size, creationTime, owner,lastModified,sum);
    }

    public boolean isDirectory(){

        return false;
    }

    public boolean isFile(){

        return true;
    }
}
