public class Student{
	private String name;
	private int present;
	private int classNum;
	
	public Student(String n, int p, int c){
		name = n;
		present = p;
		classNum = c;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public void setPresent(int i){
		present = i;
	}
	
	public void setClassNum(int i){
		classNum = i;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPresent(){
		return present;
	}
	
	public int getClassNum(){
		return classNum;
	}
}