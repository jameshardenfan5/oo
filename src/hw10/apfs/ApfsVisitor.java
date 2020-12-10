package hw10.apfs;
import hw10.fs.*;

public interface ApfsVisitor {

    public void visit(ApfsLink apfslink);
    public void visit(ApfsDirectory apfsdirectory);
    public void visit(ApfsFile apfsfile);
}
