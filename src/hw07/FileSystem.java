package hw07;

import java.util.LinkedList;

public class FileSystem{

    private static FileSystem instance=null;
    private LinkedList<Directory> dirs=new LinkedList<Directory>();

    private FileSystem(){

    }

    public static FileSystem getFileSystem(){

        if(instance==null){
            instance=new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs(){

        return dirs;
    }

    public void appendRootDir(Directory dir){

        this.dirs.add(dir);
    }
}