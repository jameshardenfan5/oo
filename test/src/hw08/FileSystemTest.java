package hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class FileSystemTest {

    @Test
    public void append2rootdirs(){

        FileSystem sys = FileSystem.getFileSystem();
        Directory dir1 = new Directory(null,"name1",0,LocalDateTime.now());
        Directory dir2 = new Directory(null,"name2",0,LocalDateTime.now());

        sys.appendRootDir(dir1);
        sys.appendRootDir(dir2);

        Directory[] expected={dir1,dir2};
        Directory[] actual=new Directory[2];
		LinkedList<Directory> list=sys.getRootDirs();

		actual[0]=list.get(0);
		actual[1]=list.get(1);

        assertArrayEquals(expected,actual);
    }
}