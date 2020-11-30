package hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;

public class Directory extends FSElement{

    public Directory(Directory parent,String name,int size,LocalDateTime creationTime){

        super(parent,name,size,creationTime);
    }

    private LinkedList<FSElement> children=new LinkedList<FSElement>();

    public LinkedList<FSElement> getChildren(){

        return this.children;
    }

    public void appendChild(FSElement child){

        this.children.add(child);
    }

    public int countChildren(){

        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories(){

        Iterator<FSElement> childs=children.iterator();
        LinkedList<Directory> dirs=new LinkedList<Directory>();

        while(childs.hasNext()){

            FSElement child=childs.next();

            if(child.isDirectory()==true){
                dirs.add((Directory)child);
            }
        }
        return dirs;
    }

    public LinkedList<File> getFiles(){

        Iterator<FSElement> childs=children.iterator();
        LinkedList<File> files=new LinkedList<File>();

        while(childs.hasNext()){

            FSElement child=childs.next();

            if(child.isFile()==true){
                files.add((File)child);
            }
        }
        return files;
    }

    public int getTotalSize(){

         int size=0;
         Iterator<File> files=getFiles().iterator();
         Iterator<Directory> dirs=getSubDirectories().iterator();

         while(files.hasNext()){

            File file=files.next();

            size=size+file.getSize();
         }

         while(dirs.hasNext()){

            Directory dir=dirs.next();

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
