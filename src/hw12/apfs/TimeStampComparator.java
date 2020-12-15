package hw12.apfs;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement>{
    public int compare(ApfsElement element1, ApfsElement element2){

        return element1.getCreationTime().compareTo(element2.getCreationTime());
    }
}