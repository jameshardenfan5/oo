package hw10.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import hw10.fs.*;

public class ApfsDirectory extends ApfsElement{

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
        super(parent, name, size, creationTime, owner,lastModified,sum);
    }



    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();

    public void accept(ApfsVisitor visitor) {

        visitor.visit(this);

        for(ApfsElement e : children){

            e.accept(visitor);
        }
    }

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
        LinkedList<ApfsDirectory> dirs=new LinkedList<ApfsDirectory>();
		for(int i=0;i<children.size();i++){

            if(children.get(i).isDirectory()==true){
                dirs.add((ApfsDirectory)children.get(i));
            }
        }
        return dirs;
    }

    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> files=new LinkedList<ApfsFile>();
		for(int j=0;j<children.size();j++){

            if(children.get(j).isFile()==true){
                files.add((ApfsFile)children.get(j));
            }
        }
        return files;
    }

    public int getTotalSize(){

        LinkedList<ApfsDirectory> dirs=getSubDirectories();
        LinkedList<ApfsFile> files=getFiles();
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
