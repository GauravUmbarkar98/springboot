This example will help us in understanding the improvement in Autowiring from Spring 4.0.

In Autowiring, Spring does the hard work of locating a Candidate 
for resolving the dependency. For example, if we see this code:

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private PayrollService payrollService; 
	
	...
}

So in the above example, Spring will search for an Object of type PayrollService
and inject the reference of the same dynamically. The assumption of this example
is that PayrollService is an interface. But Autowiring will fail if there are
more than one implementation of the above interface. Keep this point in mind
because this is where Spring 4 improves upon.

Have a look at this interface:

public interface Dao<T> {

	public void add(T t);
	public void remove(T t);
}

Suppose we have couple of implementations of this interface:

@Repository
public class EmployeeDao implements Dao<Employee> {

	...
}

@Repository
public class ProductDao implements Dao<Product> {

	...
}

Now we need to inject one of the above Dao in a service class like this:

@Service
public class ProductInventoryService {

	@Autowired
	public Dao<Product> productDao;

	...	

}

Now what will happen if we run this example in Spring 3.x is that, it will
search for an Object of type Dao but will ignore the presence of Generics.
Spring will get confused because he will find EmployeeDao and ProductDao, 
both implementing the Dao interface. So the above code will result in an
error in Spring 3.x but will execute successfully when using Spring 4.0

From Spring 4.0 onwards, Spring support for Generic based dependencies
has improved. So that means in the above example, now Spring will search
for an Object of type Dao<Product> rather than searching an Object of type
Dao when compared to the old version.

Do go through with the example that i prepared to present the above discussion.
There is a usual test class to confirm the working.

 