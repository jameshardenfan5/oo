package hw09.fat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import hw09.fs.*;

public class FatFileTest{

    private String[] fileToStringArray(fatFile f){

        String[] filearray={String.valueOf(f.isDirectory()),f.getName(),Integer.toString(f.getSize()),f.getCreationTime().toString(),f.getParent().getName(),f.getowner(),f.getsum()};

        return filearray;
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
    public void verifyFileEqualityA(){

        String[] expected={"false","a","1",String.valueOf(time),"applications","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(a));
    }

	@Test
    public void verifyFileEqualityB(){

        String[] expected={"false","b","1",String.valueOf(time),"applications","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(b));
    }

	@Test
    public void verifyFileEqualityC(){

        String[] expected={"false","c","1",String.valueOf(time),"home","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(c));
    }

	@Test
    public void verifyFileEqualityD(){

        String[] expected={"false","d","1",String.valueOf(time),"home","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(d));
    }
 
    @Test
    public void verifyFileEqualityE(){

        String[] expected={"false","e","1",String.valueOf(time),"code","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(e));
    }

    @Test
    public void verifyFileEqualityF(){

        String[] expected={"false","f","1",String.valueOf(time),"code","Suzuki","1234abcd"};

        assertArrayEquals(expected,fileToStringArray(f));
    }
}