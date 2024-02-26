package PojoClassImplemantation;

public class Employee {
	//create a empty constructor
	public Employee() {
		
	}
	//Step 1 : declare all the variables globally
	
		String createdBy;
		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public int[] getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(int[] phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		int[] phoneNumber;
		int age;
	
		//Step 2 : create a constructor
		public Employee(String createdBy, int[] phoneNumber, int age) {
		super();
		this.createdBy = createdBy;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
		
		
		
}
