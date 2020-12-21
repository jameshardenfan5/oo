package hw09.fat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.LinkedList;
import hw09.fs.*;

public class FatDirectoryTest {

    private String[] dirToStringArray(fatDirectory dir){

        String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),dir.getCreationTime().toString(),dir.getParent().getName(),Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

        return dirarray;
    }

	private static fat inst = fat.getInstance();
    private static fatDirectory root;
    private static fatDirectory home;
    private static fatDirectory applications;
    private static fatDirectory code;
    private static fatFile a;
    private static fatFile b;
    private static fatFile c;
    private static fatFile d;
    private static fatFile e;
    private static fatFile f;
    private static LocalDateTime time;

    @BeforeAll
    public static void fixture(){

        time=LocalDateTime.now();
		root=inst.getRootDir();
        home = new fatDirectory(root, "home", 0, time,  "Suzuki" ,time,"1234abcd");
        applications= new fatDirectory(root, "applications", 0, time,  "Suzuki" ,time,"1234abcd");
        code=new fatDirectory(home, "code", 0, time,  "Suzuki" ,time,"1234abcd");
        a=new fatFile(applications, "a", 1, time,  "Suzuki" ,time,"1234abcd");
        b=new fatFile(applications, "b", 1, time,  "Suzuki" ,time,"1234abcd");
        c=new fatFile(home, "c", 1, time,  "Suzuki" ,time,"1234abcd");
        d=new fatFile(home, "d", 1, time,  "Suzuki" ,time,"1234abcd");
        e=new fatFile(code, "e", 1, time,  "Suzuki" ,time,"1234abcd");
        f=new fatFile(code, "f", 1, time,  "Suzuki" ,time,"1234abcd");
		if(root.getChildren().size()==0){
			root.appendChild(home);
			root.appendChild(applications);
		}
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(code);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void verifyDirectoryEqualityHome(){

        String[] expected = {"true", "home", "0", String.valueOf(time), "root", "3", "4"};

        assertArrayEquals(expected,dirToStringArray(home));
    }

    @Test
    public void verifyDirectoryEqualityCode(){

        String[] expected = {"true", "code", "0", String.valueOf(time), "home", "2", "2"};

        assertArrayEquals(expected,dirToStringArray(code));
    }

    @Test
    public void verifyDirectoryEqualityApplications(){

        String[] expected = {"true", "applications", "0", String.valueOf(time), "root", "2", "2"};

        assertArrayEquals(expected,dirToStringArray(applications));
    }
}