package hw10.apfs;

import java.util.LinkedList;
import hw10.fs.*;

public class ApfsFileSearchVisitor implements ApfsVisitor {

    private String name;
    private LinkedList<ApfsFile> list=new LinkedList<ApfsFile>();

    public ApfsFileSearchVisitor(String name){

        this.name=name;
    }

    public void visit(ApfsDirectory dir){

        return;
    }

    public void visit(ApfsFile file){

        if(file.getName()==name){
            list.add(file);
        }
    }
    public void visit(ApfsLink link){

        return;
    }
    
    public LinkedList<ApfsFile> filelist(){

        return list;
    }
}
