package hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentFactoryTest {

    private String[] studentToStringArray(StudentFactory.Student s){

            String[] studentarray={s.getName(),s.getUsAddr(),s.getStatus().name()};

            return studentarray;
	}

    private String[] foreignstudentToStringArray(StudentFactory.Student s){

            String[] studentarray={s.getName(),Integer.toString(s.geti20num()),s.getForeignAddr(),s.getStatus().name()};

            return studentarray;
	}

	private String name = "Tyler Browbay";
	private String usAddr = "11 America st";
	private int i20num = 49;
	private int yrsInState = 2;
	private String foreignAddr = "12 somethibg St";
	StudentFactory factory=new StudentFactory();

	@Test
	public void CreateInStateStudentwithNameAddress() {

		String[] expected={"Tyler Browbay","11 America st","INSTATE"};
		assertArrayEquals(expected,studentToStringArray(factory.createInStateStudent(name,usAddr)));
	}

	@Test
	public void CreateOutStateStudentwithNameAddrYearsinState() {

		String[] expected={"Tyler Browbay","11 America st","OUTSTATE"};
		assertArrayEquals(expected,studentToStringArray(factory.createOutStateStudent(name,usAddr,yrsInState)));
	}

	@Test
	public void CreateIntlStudentNameAddri20foreignAddr() {

		String[] expected={"Tyler Browbay","49","12 somethibg St","INTL"};
		assertArrayEquals(expected,foreignstudentToStringArray(factory.createIntlStudent(name,usAddr,i20num,foreignAddr)));
	}
}
