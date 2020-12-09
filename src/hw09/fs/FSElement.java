package hw09.fs;

import java.time.LocalDateTime;

public abstract class FSElement{

    protected FSElement parent;
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;

    public FSElement(FSElement parent,String name,int size,LocalDateTime creationTime){

        this.parent=parent;
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
    }

    public FSElement getParent(){

        return this.parent;
    }

    public void setName(String name){

        this.name = name;
    }


    public String getName(){

        return name;
    }

    public void setSize(int size){

        this.size = size;
    }

    public int getSize(){

        return this.size;
    }

    public void setCreationTime(LocalDateTime creationTime){

        this.creationTime = creationTime;
    }

    public LocalDateTime getCreationTime(){

        return this.creationTime;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();

}
