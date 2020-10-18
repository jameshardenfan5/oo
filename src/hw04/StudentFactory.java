package hw04;

public class StudentFactory {

	public StudentFactory() {

	}

	public Student createInStateStudent(String name, String usAddr) {
		return new Student(name,usAddr, -1, -1,null, StudentStatus.INSTATE);
	}

	public Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, yrsInState, -1,null, StudentStatus.OUTSTATE);
	}

	public Student createIntlStudent(String name, String usAddr,int i20num,String foreignAddr) {
		return new Student(name, usAddr, -1,i20num, foreignAddr, StudentStatus.INTL);
	}

	protected class Student {

		float tuition;
		String name;
		int i20num;
		String usAddr;
		int yrsInState;
		String foreignAddr;
		StudentStatus status;

		protected Student(String name, String usAddr, int yrsInState, int i20num,  String foreignAddr, StudentStatus status){

			this.name = name;
			this.usAddr = usAddr;
			if (yrsInState != -1) {
				this.yrsInState = yrsInState;
			}
			if (i20num != -1) {
				this.i20num = i20num;
			}
			this.foreignAddr = foreignAddr;
			this.status = status;
		}

		public String getName() {

			return name;
		}

		public String getUsAddr() {


			return usAddr;
		}

		public int getYrsInState() {

			return yrsInState;
		}

		public int geti20num() {

			return i20num;
		}

		public String getForeignAddr() {


			return foreignAddr;
		}

		public StudentStatus getStatus() {

			return status;
		}
	}
}
