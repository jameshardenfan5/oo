package hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hw10.fs.*;

public class APFSTest{

    private String[] dirToStringArray(ApfsDirectory dir){

        String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

        return dirarray;
    }

    @Test
    public void ApfsSingletonEquality(){

        APFS apfs = APFS.getInstance();
        APFS apfs1 = APFS.getInstance();

        assertSame(apfs1,apfs);
    }

    @Test
    public void DefaultRoot(){

        APFS apfs = APFS.getInstance();
        ApfsDirectory root = apfs.getRootDir();
        String[] expected = {"true", "root", "0",  "0", "0"};

        assertArrayEquals(dirToStringArray(root), expected);
    }
}