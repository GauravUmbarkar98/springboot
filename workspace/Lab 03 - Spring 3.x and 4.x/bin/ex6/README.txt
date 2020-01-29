This example will help us understand the importance of using @Order annotation 
improvement of Spring 4.0 when injecting the dependencies.

Suppose we have an application in which there are many DAOs, for example:
ProductDao, EmployeeDao, CustomerDao, ShoppingDao, etc... and as usual all 
the Daos implement or extend a common base interface or class by the name Dao

For some reason now we need in some utility class of ours, object of all these daos 
that Spring has created, so this is how the utility class will look like:

public class SomeUtility {

	@Autowired
	private List<Dao> listOfDaos;

	...
	
Till Spring 3.x there is no way to control the order in which the list of all the daos
will get injected, till we don't use xml approach. But when using annotations, what to do?

So the solution is to use @Order annotation in the dao classes so that whenever any situation
similar to the above arises, Spring will inject the same in the order of importance defined.

Inside this package, you will find matching Java classes as discussed above. There is a TestClass
to confirm the working of the example. Do try out the example by removing the @Order annotation
from the dao classes to understand the difference.

