package hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;

public class FileTest{

    private String[] fileToStringArray(File f){

        String[] filearray={String.valueOf(f.isDirectory()),f.getName(),Integer.toString(f.getSize()),f.getCreationTime().toString(),f.getParent().getName()};

        return filearray;
    }

    private static Directory root;
    private static Directory home;
    private static Directory applications;
    private static Directory code;
    private static File a;
    private static File b;
    private static File c;
    private static File d;
    private static File e;
    private static File f;
    private static LocalDateTime time;
    private static Link x;
    private static Link y;

    @BeforeAll
    public static void fixture(){

        time=LocalDateTime.now();
        root=new Directory(null,"root",0,time);
        home=new Directory(root,"home",0,time);
        applications=new Directory(root,"applications",0,time);
        code=new Directory(home,"code",0,time);
        a=new File(applications,"a",1,time);
        b=new File(applications,"b",1,time);
        c=new File(home,"c",1,time);
        d=new File(home,"d",1,time);
        e=new File(code,"e",1,time);
        f=new File(code,"f",1,time);
		x=new Link(home,"x",0,time,applications);
		y=new Link(code,"y",0,time,b);
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
    public void verifyFileEqualityA(){

        String[] expected={"false","a","1",String.valueOf(time),"applications"};

        assertArrayEquals(expected,fileToStringArray(a));
    }

    @Test
    public void verifyFileEqualityB(){

        String[] expected={"false","b","1",String.valueOf(time),"applications"};

        assertArrayEquals(expected,fileToStringArray(b));
    }

    @Test
    public void verifyFileEqualityC(){

        String[] expected={"false","c","1",String.valueOf(time),"home"};

        assertArrayEquals(expected,fileToStringArray(c));
    }

    @Test
    public void verifyFileEqualityD(){

        String[] expected={"false","d","1",String.valueOf(time),"home"};

        assertArrayEquals(expected,fileToStringArray(d));
    }

    @Test
    public void verifyFileEqualityE(){

        String[] expected={"false","e","1",String.valueOf(time),"code"};

        assertArrayEquals(expected, fileToStringArray(e));
    }

    @Test
    public void verifyFileEqualityF(){

        String[] expected={"false","f","1",String.valueOf(time),"code"};

        assertArrayEquals(expected, fileToStringArray(f));
    }
}
