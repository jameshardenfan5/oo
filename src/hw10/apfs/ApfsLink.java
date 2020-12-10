package hw10.apfs;

import java.time.LocalDateTime;
import hw10.fs.*;

public class ApfsLink extends ApfsElement{

    private ApfsElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String owner,LocalDateTime lastModified,String sum,ApfsElement target){

        super(parent, name, size, creationTime,owner, lastModified,sum);
        this.target = target;
    }

    public void accept(ApfsVisitor visitor){

        visitor.visit(this);
    }

    public ApfsElement getTarget(){

        return target;
    }

    public boolean isDirectory(){

        return false;
    }

    public boolean isFile(){

        return false;
    }
}
