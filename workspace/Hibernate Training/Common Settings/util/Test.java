package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
class Zoo
{
	static Animal getAnimal(String hint) {
		Animal a = new Mammal().getAnimal(hint).walk();
		return a;
	}
	static Animal getAnimal() {
		Animal a = new Mammal().getAnimal("calm").walk();
		return a;
	}
}
public class Test {
	public static void main(String[] args) {
		
		
		//SessionFactory sessionFactory = new Configuration().
		//		configure().buildSessionFactory(); // hibernate.cfg.xml
		
		//Animal a = new Mammal().getAnimal("domestic").walk();
		
			Animal a = Zoo.getAnimal();

		
	}
}

abstract class Animal
{
	abstract Animal walk(); //IMPLEMENTATION : walk() its mandatorily defined by the nonabstract child
	
	Animal getAnimal(String animalType) { //DERIVATION : derived by the child, and teh child may override
		Animal a = null;
		if(animalType.equalsIgnoreCase("domestic"))
			a = new Cow();
		else if(animalType.equalsIgnoreCase("wild"))
			a = new Tiger();
		else if(animalType.equalsIgnoreCase("calm"))
			a = new Goat();
		
		return a;
	}
}

class Mammal extends Animal
{
	public Animal walk() {
		System.out.println("walking...mammal");
		return this;
	}

}
class Cow extends Mammal
{
	public Animal walk() {
		System.out.println("walking...cow ");
		return this;
	}

	void eatingGrass() {
		System.out.println("Cow eating grass");
	}
}

class Tiger extends Mammal
{
	public Animal walk() {
		System.out.println("walking...tiger");
		return this;
	}

	void eatingFlesh() {
		System.out.println("Tiger eating flesh");
	}
}
class Goat extends Mammal
{
	public Animal walk() {
		System.out.println("walking...Goat");
		return this;
	}

	void eatingLeaves() {
		System.out.println("Goat eating leaves");
	}
}

/*
class FarmHouse
{
	Animal grow()
	{
		System.out.println("growing....");
	}
}*/
