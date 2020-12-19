package hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hw09.fs.*;

public class APFSTest{

    private String[] dirToStringArray(ApfsDirectory dir){

        String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

        return dirarray;
    }

    @Test
    public void DefaultRoot(){

        String[] expected = {"true", "root", "0",  "0", "0"};

        assertArrayEquals(dirToStringArray(APFS.getInstance().getRootDir()), expected);
    }
}
