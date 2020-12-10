package hw10.apfs;

import hw10.fs.*;
import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsVisitor{

    private LinkedList<ApfsFile> quarantine=new LinkedList<ApfsFile>();

    public void visit(ApfsLink link){

        return;
    }

    public void visit(ApfsDirectory dir){

        return;
    }

    public void visit(ApfsFile file){

        quarantine.add(file);
    }

    public LinkedList<ApfsFile> getlist(){

        return quarantine;
    }
}
