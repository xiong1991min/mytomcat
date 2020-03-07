package com.xm.test3;

public class ThreadLocalTest extends Thread {
	
	private final ThreadLocal<Student> mythreadLocal = new ThreadLocal<Student>();

	private int age;

	public ThreadLocalTest(String name) {
		super(name);
	}

	public ThreadLocalTest(String name, int age) {
		super(name);
		this.age = age;
	}

	public static void main(String[] args) {
		ThreadLocalTest student1 = new ThreadLocalTest("thread-first", 23);
		ThreadLocalTest student2 = new ThreadLocalTest("thread-second", 30);

		student1.start();
		student2.start();
	}

	public void run() {
		testInfo();
	}

	public void testInfo() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " is running!");

		Student stud1 = this.getLocalVariable();
		System.out.println("Student " + stud1.name + " is in age " + stud1.age
				+ " in " + currentThreadName);
	}

	public Student getLocalVariable() {
		if (mythreadLocal.get() == null) {
			Student student = new Student(Thread.currentThread().getName()
					+ "-student", this.age);
			mythreadLocal.set(student);
		}
		return mythreadLocal.get();
	}

	public class Student {
		private String name;
		private int age;

		public Student() {
		}

		public Student(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
