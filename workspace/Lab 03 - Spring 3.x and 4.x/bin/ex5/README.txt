This example will help us in understand the new Condition API introduced in Spring 4.0.

With the help of this feature one can now define conditions based on which
beans will be loaded into the context. Prior to Spring 4, the only way to achieve this 
was through EL or Bean Profiles. When compared to EL and Bean Profiles,
the difference is that it's far more dynamic because of the presence of proper Java code
to decide the condition. Finally, which option to use will depend upon the project
specific needs. When compared, EL and Bean Profiles can simply be modified by changing the 
configuration, but changing the condition written using this new API will require proper
Java code modification.

Inside this package, you will find 2 classes implementing the Condition interface, i have
named it as Condition1 and Condition1 for ease of understanding. The intention of this example
is to conditionally load a particular properties file. I am sure you will find the code easy to
understand. This example using the Spring 3 based Configuration annotation approach, which means
there is no xml to load any of the beans. The main class is the AppConfig class to load the required
beans whenever the context will be created. Inside the AppConfig class, you will notice, we are
trying to load the same bean twice but because of the presence of the @Condition, only
the one that satisfies the condition will get loaded right now. There is a simple message in the 
properties file that will get loaded. I am trying to read the same in ExampleBean class. 
So when you run the TestClass, we will be able to confirm the working of the example.