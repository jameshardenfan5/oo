package hw10.apfs;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import hw10.fs.*;

public class ApfsFileTest{

    private String[] fileToStringArray(ApfsFile f){

        String[] filearray={String.valueOf(f.isDirectory()),f.getName(),Integer.toString(f.getSize()),f.getCreationTime().toString(),f.getParent().getName(),f.getowner(),f.getsum()};

        return filearray;
    }

	private static APFS apfs = APFS.getInstance();
    private static ApfsDirectory root;
    private static ApfsDirectory home;
    private static ApfsDirectory applications;
    private static ApfsDirectory code;
    private static ApfsFile a;
    private static ApfsFile b;
    private static ApfsFile c;
    private static ApfsFile d;
    private static ApfsFile e;
    private static ApfsFile f;
    private static LocalDateTime time;
    private static ApfsLink x;
    private static ApfsLink y;

    @BeforeAll
    public static void fixture(){

        time=LocalDateTime.now();
		root=apfs.getRootDir();
        home = new ApfsDirectory(root, "home", 0, time,  "Suzuki" ,time,"1234abcd");
        applications= new ApfsDirectory(root, "applications", 0, time,  "Suzuki" ,time,"1234abcd");
        code=new ApfsDirectory(home, "code", 0, time,  "Suzuki" ,time,"1234abcd");
        a=new ApfsFile(applications, "a", 1, time,  "Suzuki" ,time,"1234abcd");
        b=new ApfsFile(applications, "b", 1, time,  "Suzuki" ,time,"1234abcd");
        c=new ApfsFile(home, "c", 1, time,  "Suzuki" ,time,"1234abcd");
        d=new ApfsFile(home, "d", 1, time,  "Suzuki" ,time,"1234abcd");
        e=new ApfsFile(code, "e", 1, time,  "Suzuki" ,time,"1234abcd");
        f=new ApfsFile(code, "f", 1, time,  "Suzuki" ,time,"1234abcd");
		x=new ApfsLink(home, "x", 0, time, "Suzuki", time,"1234abcd", applications);
		y = new ApfsLink(code, "y", 0, time,"Suzuki", time,"1234abcd", b);
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
        home.appendChild(x);
        code.appendChild(y);
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