package hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;
import hw09.fs.*;

public class ApfsDirectory extends ApfsElement{

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
        super(parent, name, size, creationTime, owner,lastModified,sum);
    }

    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();

    public LinkedList<ApfsElement> getChildren(){
        return this.children;
    }

    public void appendChild(ApfsElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirectories(){

        Iterator<ApfsElement> childs=children.iterator();
        LinkedList<ApfsDirectory> dirs=new LinkedList<ApfsDirectory>();

        while(childs.hasNext()){

            ApfsElement child=childs.next();

            if(child.isDirectory()==true){
                dirs.add((ApfsDirectory)child);
            }
        }
        return dirs;
    }
    public LinkedList<ApfsFile> getFiles(){

        Iterator<ApfsElement> childs=children.iterator();
        LinkedList<ApfsFile> files=new LinkedList<ApfsFile>();

        while(childs.hasNext()){

            ApfsElement child=childs.next();

            if(child.isFile()==true){
                files.add((ApfsFile)child);
            }
        }
        return files;
    }

    public int getTotalSize(){

         int size=0;
         Iterator<ApfsFile> files=getFiles().iterator();
         Iterator<ApfsDirectory> dirs=getSubDirectories().iterator();

         while(files.hasNext()){

            ApfsFile file=files.next();

            size=size+file.getSize();
         }

         while(dirs.hasNext()){

            ApfsDirectory dir=dirs.next();

            size=size+dir.getTotalSize();
         }
         return size;
    }

    public boolean isDirectory(){
        return true;
    }

    public boolean isFile(){
        return false;
    }


}
