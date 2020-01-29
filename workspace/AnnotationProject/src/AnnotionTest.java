import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//every object of an "Object class"
//got a method called as getClass()
//that returns an object of "class Class"

/*class Object
{
	Class getClass()
	{
		
	}
}
class Savings
{
	
}
class Player
{
	String playerName;
}
Player p = new Player("sachin tendulkar");
*/

public class AnnotionTest {
	public static void main(String[] args) {
		Book b = new Book(123);
		
		Class classDetails = b.getClass();
		Constructor ctr[] = classDetails.getConstructors();
		
		for(int i=0;i<ctr.length;i++) {
			System.out.println("Constructor is : "+ctr[i].getName());
		}
		
		Method meth[] = classDetails.getMethods();
		
		for(int i=0;i<meth.length;i++) {
			System.out.println("Method is : "+meth[i].getName());
		}
		
		Annotation anno[] = classDetails.getAnnotations();
		for(int i=0;i<anno.length;i++) {
			System.out.println("Annotation is : "+anno[i]);
			
			if(anno[i] instanceof DevelopedBy )
			{
				System.out.println("Found the required annotation...");
				DevelopedBy db = (DevelopedBy) anno[i];
				System.out.println("name    is "+db.name());
				System.out.println("version is "+db.version());
				
				if(db.name().equalsIgnoreCase("Rupesh") && db.version().equals("3.0")) {
					System.out.println("Granting...something...");
				}else {
					System.out.println("Revoking......something...");
				}
			}
		}
				
	}
}



/*		Annotation = extended version of comments
 * 
 * 
 * comments 
 * 
 * 		-  limited to the source code
 * 		-  comments are NOT structured, they can be put anywhere
 * 
 * Annotations
 * 
 * 		- not limited to the source code
 * 		- structured
 * 
 * 
 */ 

/*dsfas*/
/*dsfas*/class A  /*dsfas*/
/*dsfas*/{/*dsfas*/
	
	/*dsfas*/}/*dsfas*/
 


