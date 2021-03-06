package hw09.fat;

import java.time.LocalDateTime;
import hw09.fs.*;

public class fatElement extends FSElement{

	private String owner,sum;
    private LocalDateTime lastModified;

    public fatElement(fatDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum){
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
	
    public boolean isDirectory(){

        return true;
    }

    public boolean isFile(){

        return false;
    }
}
