package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.LinkedList;
import hw10.fs.*;

public class ApfsFileSearchVisitorTest{

	private static APFS apfs=APFS.getInstance();
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
    public void searchforfilef() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("f");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"f"};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void searchforfilee() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("e");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"e"};

        assertArrayEquals(expected,actual);
    }
    @Test
    public void searchforfiled() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("d");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"d"};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void searchforfilec() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("c");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"c"};

        assertArrayEquals(expected,actual);
    }
    @Test
    public void searchforfileb() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"b"};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void searchforfilea() {

        ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");

        root.accept(visitor);

        LinkedList<ApfsFile> files=visitor.filelist();

		String[] actual=new String[1];

		actual[0]=files.get(0).getName();

        String[] expected={"a"};

        assertArrayEquals(expected,actual);
    }
}
