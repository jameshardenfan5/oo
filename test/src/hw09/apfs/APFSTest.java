package hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hw09.fs.*;

public class APFSTest{

    @Test
    public void initDefaultRoot(){

        String[] expected = {"true","root","0", "0","0"};
        String[] actual={String.valueOf(APFS.getInstance().getRootDir().isDirectory()),APFS.getInstance().getRootDir().getName(),Integer.toString(APFS.getInstance().getRootDir().getSize()),Integer.toString(APFS.getInstance().getRootDir().countChildren()),Integer.toString(APFS.getInstance().getRootDir().getTotalSize())};

        assertArrayEquals(expected,actual);
    }
}