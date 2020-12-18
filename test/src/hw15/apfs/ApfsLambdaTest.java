package hw15.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.LinkedList;
import hw15.fs.*;

public class ApfsLambdaTest{
/*
    private String[] dirToStringArray(ApfsDirectory dir){

        String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),dir.getCreationTime().toString(),dir.getParent().getName(),Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

        return dirarray;
    }
*/
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
    public void applicationsFilesReverseAlphabet(){

        String[] expected={"b","a"};
        LinkedList<ApfsFile> files= applications.getFiles((ApfsElement file1, ApfsElement file2)-> file2.getName().compareTo(file1.getName()));
        String[] actual = new String[2];

        actual[0]=files.get(0).getName();
        actual[1]=files.get(1).getName();

        assertArrayEquals(expected,actual);
    }

    @Test
    public void codeChildrenCreationTime() {

        String[] expected={"e","f","y"};
        LinkedList<ApfsElement> childs = code.getChildren((ApfsElement child1, ApfsElement child2)->child1.getCreationTime().compareTo(child2.getCreationTime()));
        String[] actual = new String[3];

        actual[0]=childs.get(0).getName();
        actual[1]=childs.get(1).getName();
        actual[2]=childs.get(2).getName();

        assertArrayEquals(expected,actual);
    }
}