package hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import java.util.Iterator;
import java.util.LinkedList;

class DirectoryTest{

    private String[] dirToStringArray(Directory dir){

        if(dir.getName().equals("root")){

            String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),dir.getCreationTime().toString(),null,Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

            return dirarray;
        }
        else{

            String[] dirarray={String.valueOf(dir.isDirectory()),dir.getName(),Integer.toString(dir.getSize()),dir.getCreationTime().toString(),dir.getParent().getName(),Integer.toString(dir.countChildren()),Integer.toString(dir.getTotalSize())};

            return dirarray;
        }
    }

    private static Directory root;
    private static Directory home;
    private static Directory applications;
    private static Directory code;
    private static File a;
    private static File b;
    private static File c;
    private static File d;
    private static File e;
    private static File f;
    private static LocalDateTime time;

    @BeforeAll
    public static void fixture(){

        time=LocalDateTime.now();
        root=new Directory(null,"root",0,time);
        home=new Directory(root,"home",0,time);
        applications=new Directory(root,"applications",0,time);
        code=new Directory(home,"code",0,time);
        a=new File(applications,"a",1,time);
        b=new File(applications,"b",1,time);
        c=new File(home,"c",1,time);
        d=new File(home,"d",1,time);
        e=new File(code,"e",1,time);
        f=new File(code,"f",1,time);
        root.appendChild(home);
        root.appendChild(applications);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(code);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void verifyDirectoryEqualityRoot(){

        String[] expected={"true","root","0",String.valueOf(time),null,"2","6"};
        Directory dir=root;
        String[] actual=dirToStringArray(dir);

        assertArrayEquals(expected, actual);

        String[] expected_subs={"home","applications"};
        LinkedList<Directory> subs_list;

        subs_list=dir.getSubDirectories();

        Iterator<Directory> subs_it=subs_list.iterator();
        String[] actual_subs=new String[2];
        int i=0;

        while(subs_it.hasNext()){

            Directory sub=subs_it.next();

            actual_subs[i]=sub.getName();
            i++;
        }
        assertArrayEquals(expected_subs,actual_subs);

        String[] expected_files={};
        LinkedList<File> files_list;

        files_list=dir.getFiles();

        Iterator<File> files_it=files_list.iterator();
        String[] actual_files=new String[0];
        int j=0;

        while(files_it.hasNext()){

            File file=files_it.next();

            actual_files[j]=file.getName();
            j++;
        }
        assertArrayEquals(expected_files,actual_files);

    }

    @Test
    public void verifyDirectoryEqualityHome(){

        String[] expected={"true","home","0",String.valueOf(time),"root","3","4"};
        Directory dir=home;
        String[] actual=dirToStringArray(dir);

        assertArrayEquals(expected, actual);

        String[] expected_subs={"code"};
        LinkedList<Directory> subs_list;

        subs_list=dir.getSubDirectories();

        Iterator<Directory> subs_it=subs_list.iterator();
        String[] actual_subs=new String[1];
        int i=0;

        while(subs_it.hasNext()){

            Directory sub=subs_it.next();

            actual_subs[i]=sub.getName();
            i++;
        }
        assertArrayEquals(expected_subs,actual_subs);

        String[] expected_files={"c","d"};
        LinkedList<File> files_list;

        files_list=dir.getFiles();

        Iterator<File> files_it=files_list.iterator();
        String[] actual_files=new String[2];
        int j=0;

        while(files_it.hasNext()){

            File file=files_it.next();

            actual_files[j]=file.getName();
            j++;
        }
        assertArrayEquals(expected_files,actual_files);
    }

    @Test
    public void verifyDirectoryEqualityApplications(){

        String[] expected={"true","applications","0",String.valueOf(time),"root","2","2"};
        Directory dir=applications;
        String[] actual=dirToStringArray(dir);

        assertArrayEquals(expected, actual);

        String[] expected_subs={};
        LinkedList<Directory> subs_list;

        subs_list=dir.getSubDirectories();

        Iterator<Directory> subs_it=subs_list.iterator();
        String[] actual_subs=new String[0];
        int i=0;

        while(subs_it.hasNext()){

            Directory sub=subs_it.next();

            actual_subs[i]=sub.getName();
            i++;
        }
        assertArrayEquals(expected_subs,actual_subs);

        String[] expected_files={"a","b"};
        LinkedList<File> files_list;

        files_list=dir.getFiles();

        Iterator<File> files_it=files_list.iterator();
        String[] actual_files=new String[2];
        int j=0;

        while(files_it.hasNext()){

            File file=files_it.next();

            actual_files[j]=file.getName();
            j++;
        }
        assertArrayEquals(expected_files,actual_files);
    }

    @Test
    public void verifyDirectoryEqualityCode(){

        String[] expected={"true","code","0",String.valueOf(time),"home","2","2"};
        Directory dir=code;
        String[] actual=dirToStringArray(dir);

        assertArrayEquals(expected, actual);

        String[] expected_subs={};
        LinkedList<Directory> subs_list;

        subs_list=dir.getSubDirectories();

        Iterator<Directory> subs_it=subs_list.iterator();
        String[] actual_subs=new String[0];
        int i=0;

        while(subs_it.hasNext()){

            Directory sub=subs_it.next();

            actual_subs[i]=sub.getName();
            i++;
        }
        assertArrayEquals(expected_subs,actual_subs);

        String[] expected_files={"e","f"};
        LinkedList<File> files_list;

        files_list=dir.getFiles();

        Iterator<File> files_it=files_list.iterator();
        String[] actual_files=new String[2];
        int j=0;

        while(files_it.hasNext()){

            File file=files_it.next();

            actual_files[j]=file.getName();
            j++;
        }
        assertArrayEquals(expected_files,actual_files);
    }
}