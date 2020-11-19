package hw07;

import java.time.LocalDateTime;

public abstract class FSElement{

    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    public FSElement(Directory parent,String name,int size,LocalDateTime creationTime){

        this.parent=parent;
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
    }

    public Directory getParent(){

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

}
