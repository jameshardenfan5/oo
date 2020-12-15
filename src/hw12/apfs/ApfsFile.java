package hw12.apfs;

import java.time.LocalDateTime;
import hw12.fs.*;

public class ApfsFile extends ApfsElement {

    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){

        super(parent, name, size, creationTime, owner,lastModified,sum);
    }

    public boolean isDirectory(){

        return false;
    }

    public boolean isFile(){

        return true;
    }
}
