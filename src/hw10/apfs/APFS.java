package hw10.apfs;

import java.time.LocalDateTime;
import hw10.fs.*;

public class APFS extends FileSystem{

    private LocalDateTime creationTime=LocalDateTime.now();
    private LocalDateTime lastModified=LocalDateTime.now();
    protected static APFS inst = null;
    private String name;
    protected ApfsDirectory root;

    public static APFS getInstance(){

        if(inst == null){
            inst = new APFS();
			inst.initFileSystem("apfs",999);
        }
        return inst;
    }

    protected ApfsDirectory createDefaultRoot() {

        root = new ApfsDirectory(null, "root", 0, creationTime, "Suzuki", lastModified,"1234abcd");

        return root;
    }

    public ApfsDirectory getRootDir(){

        return root;
    }
}
