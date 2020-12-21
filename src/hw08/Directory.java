package hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

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
        LinkedList<Directory> dirs=new LinkedList<Directory>();
		for(int i=0;i<children.size();i++){

            if(children.get(i).isDirectory()==true){
                dirs.add((Directory)children.get(i));
            }
        }
        return dirs;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> files=new LinkedList<File>();
		for(int j=0;j<children.size();j++){

            if(children.get(j).isFile()==true){
                files.add((File)children.get(j));
            }
        }
        return files;
    }

    public int getTotalSize(){

        LinkedList<Directory> dirs=getSubDirectories();
        LinkedList<File> files=getFiles();
		int totalsize=0;
		int dirsize=0;
        int filesize=0;
		for(int k=0;k<dirs.size();k++){

			dirsize=dirsize+dirs.get(k).getTotalSize();
        }
		for(int m=0;m<files.size();m++){

			filesize=filesize+files.get(m).getSize();
        }
		totalsize=filesize+dirsize;

        return totalsize;
    }

    public boolean isDirectory(){

        return true;
    }

    public boolean isFile(){

        return false;
    }
}
