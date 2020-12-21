package hw09.fat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import hw09.fs.*;

public class FatTest{

    @Test
    public void initDefaultRoot(){
        String[] expected = {"true","root","0", "2","6"};
        String[] actual={String.valueOf(fat.getInstance().getRootDir().isDirectory()),fat.getInstance().getRootDir().getName(),Integer.toString(fat.getInstance().getRootDir().getSize()),Integer.toString(fat.getInstance().getRootDir().countChildren()),Integer.toString(fat.getInstance().getRootDir().getTotalSize())};

        assertArrayEquals(expected,actual);
    }
}
