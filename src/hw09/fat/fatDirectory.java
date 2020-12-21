package hw09.fat;

import java.time.LocalDateTime;
import java.util.LinkedList;
import hw09.fs.*;

public class fatDirectory extends fatElement{

    public fatDirectory(fatDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
        super(parent, name, size, creationTime, owner,lastModified,sum);
    }

    private LinkedList<fatElement> children = new LinkedList<fatElement>();

    public LinkedList<fatElement> getChildren(){
        return this.children;
    }

    public void appendChild(fatElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<fatDirectory> getSubDirectories(){
        LinkedList<fatDirectory> dirs=new LinkedList<fatDirectory>();
		for(int i=0;i<children.size();i++){

            if(children.get(i).isDirectory()==true){
                dirs.add((fatDirectory)children.get(i));
            }
        }
        return dirs;
    }

    public LinkedList<fatFile> getFiles(){
        LinkedList<fatFile> files=new LinkedList<fatFile>();
		for(int j=0;j<children.size();j++){

            if(children.get(j).isFile()==true){
                files.add((fatFile)children.get(j));
            }
        }
        return files;
    }

    public int getTotalSize(){

        LinkedList<fatDirectory> dirs=getSubDirectories();
        LinkedList<fatFile> files=getFiles();
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
