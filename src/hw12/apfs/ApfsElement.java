package hw12.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import hw12.fs.*;

public class ApfsElement extends FSElement{

	private String owner,sum;
    private LocalDateTime lastModified;
    private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
        super(parent, name, size, creationTime);
		this.owner=owner;
        this.lastModified = lastModified;
		this.sum=sum;
    }

    public LocalDateTime getLastModified(){
        return lastModified;
    }

    public void setLastModified(){
        this.lastModified = lastModified;
    }
    public String getowner(){
        return owner;
    }
    public String getsum(){
        return sum;
    }

	/*
    public int getSize(){ 

		return this.size;

	}



    public LinkedList<ApfsElement> getChildren(){
        return this.ApfsChildren;
    }

    public void appendChild(FSElement child){
        this.ApfsChildren.add((ApfsElement) child);
    }
	*/
    public boolean isDirectory(){

        return true;
    }

    public boolean isFile(){

        return false;
    }
}
