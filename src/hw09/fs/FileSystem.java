package hw09.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FileSystem {

    protected String name;
    protected int capacity;
	protected int id;
    protected LinkedList<FSElement> dirs = new LinkedList<FSElement>();

    protected abstract FSElement createDefaultRoot();



    protected void setRoot(FSElement root){

        dirs.add(root);
    }

    protected int getCapacity(){
        return capacity;
    }

    public String getName(){
        return name;
    }

    public FSElement initFileSystem(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity>=root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }else {
            return null;
        }
    }



}
