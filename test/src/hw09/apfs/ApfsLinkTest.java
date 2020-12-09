package hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import hw09.fs.*;

public class ApfsLinkTest{

    private String[] linkToStringArray(ApfsLink l){

        String[] linkarray={String.valueOf(l.isDirectory()),l.getName(),Integer.toString(l.getSize()),l.getCreationTime().toString(),l.getParent().getName(),l.getowner(),l.getsum()};

        return linkarray;
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
        root.appendChild(home);
        root.appendChild(applications);
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
    public void verifyLinkEqualityX(){

        String[] expected={"false","x","0",String.valueOf(time),"home","Suzuki","1234abcd"};

        assertArrayEquals(expected,linkToStringArray(x));

        ApfsDirectory expected2=applications;
        ApfsElement actual=x.getTarget();

        assertSame(expected2,actual);
    }

    @Test
    public void verifyLinkEqualityY(){

        String[] expected={"false","y","0",String.valueOf(time),"code","Suzuki","1234abcd"};

        assertArrayEquals(expected,linkToStringArray(y));

        ApfsFile expected2=b;
        ApfsElement actual=y.getTarget();

        assertSame(expected2,actual);
    }
}