package hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.time.LocalDateTime;

public class FileSystemTest {

    private Directory[] listtoarray(LinkedList<Directory> list) {

        Directory[] array = list.toArray(new Directory[list.size()]);

        return array;
    }

    @Test
    public void SingletonTest(){

        FileSystem instance1=FileSystem.getFileSystem();
        FileSystem instance2=FileSystem.getFileSystem();

        assertSame(instance1,instance2);
    }

    @Test
    public void append2rootdirs(){

        FileSystem sys = FileSystem.getFileSystem();
        LocalDateTime d1 = LocalDateTime.now();
        LocalDateTime d2 = LocalDateTime.now();
        Directory dir1 = new Directory(null,"name1",0,d1);
        Directory dir2 = new Directory(null,"name2",0,d2);

        sys.appendRootDir(dir1);
        sys.appendRootDir(dir2);

        Directory[] expected={dir1,dir2};
        Directory[] actual=listtoarray(sys.getRootDirs());

        assertArrayEquals(expected, actual);
    }
}