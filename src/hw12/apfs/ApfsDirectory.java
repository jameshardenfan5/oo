package hw12.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;
import hw12.fs.*;
import java.util.Comparator;

public class ApfsDirectory extends ApfsElement{

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
        super(parent, name, size, creationTime, owner,lastModified,sum);
    }

    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> c){

        this.children.sort(c);
        return this.children;
    }

    public void appendChild(ApfsElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> c){

        LinkedList<ApfsDirectory> dirs=new LinkedList<ApfsDirectory>();
		LinkedList<ApfsElement> elements=getChildren(c);
		for(int i=0;i<elements.size();i++){

            if(elements.get(i).isDirectory()==true){
                dirs.add((ApfsDirectory)elements.get(i));
            }
        }
        return dirs;
    }
    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> c){

        LinkedList<ApfsFile> files=new LinkedList<ApfsFile>();
		LinkedList<ApfsElement> elements=getChildren(c);

		for(int j=0;j<elements.size();j++){

            if(elements.get(j).isFile()==true){
                files.add((ApfsFile)elements.get(j));
            }
        }
        return files;
    }

    public boolean isDirectory(){
        return true;
    }

    public boolean isFile(){
        return false;
    }

}
