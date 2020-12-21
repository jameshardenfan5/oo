package hw09.fat;

import java.time.LocalDateTime;
import hw09.fs.*;

public class fat extends FileSystem{

    private LocalDateTime creationTime=LocalDateTime.now();
    private LocalDateTime lastModified=LocalDateTime.now();
    protected static fat inst = null;
    private String name;
    protected fatDirectory root;

    public static fat getInstance(){

        if(inst == null){
            inst = new fat();
			inst.initFileSystem("fat",999);
        }
        return inst;
    }

    protected fatDirectory createDefaultRoot() {

        root = new fatDirectory(null, "root", 0, creationTime, "Suzuki", lastModified,"1234abcd");

        return root;
    }

    public fatDirectory getRootDir(){

        return root;
    }
}
