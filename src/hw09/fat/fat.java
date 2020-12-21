package hw09.fat;

import java.time.LocalDateTime;
import hw09.fs.*;

public class fat extends FileSystem{

    protected static fat inst = null;
    protected fatDirectory root;

    public static fat getInstance(){

        if(inst == null){
            inst = new fat();
			inst.initFileSystem("fat",999);
        }
        return inst;
    }

    protected fatDirectory createDefaultRoot() {

        root = new fatDirectory(null, "root", 0,LocalDateTime.now(), "Suzuki", LocalDateTime.now(),"1234abcd");

        return root;
    }

    public fatDirectory getRootDir(){

        return root;
    }
}
