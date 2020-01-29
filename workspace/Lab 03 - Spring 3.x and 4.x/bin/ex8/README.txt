This example will help us in understanding lazy dependency injection feature of Spring 4.0

The concept of loading a bean lazily has been there since the early days of Spring.
By default, when a bean get's loaded, all the other beans that it depends upon also
gets loaded even though we have set them to be lazily loaded. This problem can be
resolved using the support for @Lazy at the injection point. So for example, now we
can say like this:

@Component
public class ClassA {

	@Autowired
	@Lazy
	private ClassB classB;
	
	...
	
So now what will happen is that even though object of Class A will get created
on startup, Spring will not create an object of Class B because of the presence
of @Lazy annotation. 

Do test the above code, with and without @Lazy so that the difference is clear.

Hope that you enjoyed exploring the new features of Spring 4 we discussed.
Good bye for now!