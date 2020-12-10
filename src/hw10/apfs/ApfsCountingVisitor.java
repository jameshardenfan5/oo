package hw10.apfs;

import hw10.fs.*;

public class ApfsCountingVisitor implements ApfsVisitor{

    private int dirs=0;
    private int files=0;
    private int links=0;

    public void visit(ApfsDirectory dir){

        dirs++;
    }

    public void visit(ApfsFile file){

        files++;
    }

    public void visit(ApfsLink link){

        links++;
    }

    public int dircount(){

        return dirs;
    }

    public int filecount(){

        return files;
    }

    public int linkcount(){

        return links;
    }
}