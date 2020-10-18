package hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentFactoryTest {

	private final String name = "Tyler Browbay";
	private final String usAddr = "11 America st";
	private final int i20num = 49;
	private final int yrsInState = 2;
	private final String foreignAddr = "12 somethibg St";
	StudentFactory factory=new StudentFactory();

	@Test
	public void testCreateInStateStudent() {

		StudentFactory.Student student = factory.createInStateStudent(name,usAddr);
		assertNotNull(student);
		assertEquals(student.getName(),name);
		assertEquals(student.getUsAddr(),usAddr);
		assertNull(student.getForeignAddr());
		assertEquals(student.getStatus(), StudentStatus.INSTATE);
	}

	@Test
	public void testCreateOutStateStudent() {

		StudentFactory.Student student = factory.createOutStateStudent(name,usAddr,yrsInState);
		assertNotNull(student);
		assertEquals(student.getName(),name);
		assertEquals(student.getUsAddr(),usAddr);
		assertEquals(student.getYrsInState(),yrsInState);
		assertNull(student.getForeignAddr());
		assertEquals(student.getStatus(),StudentStatus.OUTSTATE);
	}

	@Test
	public void testCreateIntlStudent() {

		StudentFactory.Student student = factory.createIntlStudent(name,usAddr, i20num,foreignAddr);
		assertNotNull(student);
		assertEquals(student.getName(),name);
		assertEquals(student.getUsAddr(),usAddr);
		assertEquals(student.geti20num(),i20num);
		assertEquals(student.getForeignAddr(),foreignAddr);		
		assertEquals(student.getStatus(),StudentStatus.INTL);
	}
}
