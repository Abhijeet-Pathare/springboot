Loose Coupling with Spring Framework
------------------------------------
#Design game runner to run games:
	* Mario, Super Contra, PacMan etc
# Iteration 1: Tightly Coupled
	* GameRunner class
	* Game classes: Mario, Super Contra, PacMan etc

Tight Coupling Example:
--------------------------------------------	
We created classes MarioGame, GameRunner
in Game runner constructor we passed MarioGame game to run it.
But now we want to run another game i.e SuperContra so here to do so we will have to do code changes,
and change the GameRunner constructors arguments from MarioGame game to SuperContraGame game.
This is tight coupling.
-------------------------------------------

 Loose Coupling:
 We make an interface gaming console and add method signatures to it(up,down,left,right).
 Both the classes implement this interface.
 Now we create class variable in GameRUnner class of GamingConsole and pass it in the GameRunner constructor.
 We only have to create object of MarioGame or SuperContraGame whichever we want to play in the Main class and pass the reference to GameRunner constructor in the main class.
 
We can also create Objects using the reference of GamingConsole interface and use them in the ctor of GameRunner class.
ex. GameConsole game = new MarioGame();
	GameRunner runner = new GameRunner(game);
Over here we see that game is the dependency of GameRunner class.
But instead of manually creating these objects can we ask springframework to do it???
Absolutely yes by adding @Component annotation to the classes MarioGame and GameRunner and add @Autowired annotation to the GamingConsole class variable. 
Now comment the object creation code.
Uncomment and assign a variable: ConfigurableApplicationContext context = SprinbootApplication.run(bla bla bla);

As we have commented object creation code and want Spring to create them automatically, 
use context.getBean(GameRunner.class) this will give the bean of type GameRunner.
ex.GameRunner runner = context.getBean(GameRunner.class);
runner.run(); 
---------------------------------------------------------
Now you must be having questions like:
Question 1: Whats happening in the background ? to know lets go into the logging debug level.
Identified candidate component class: file [D:\My Learning\Springboot\springboot\learn-spring-framework\target\classes\com\app\game\GameRunner.class]
Identified candidate component class: file [D:\My Learning\Springboot\springboot\learn-spring-framework\target\classes\com\app\game\MarioGame.class]
Creating shared instance of singleton bean 'gameRunner'
Creating shared instance of singleton bean 'marioGame'
Autowiring by type from bean name 'gameRunner' via constructor to bean named 'marioGame'
------------------------------------

Question 2: Spring Framework - Important Terminology
* @Componen(..): class managed by SprungFraework
* Dependency: GameRunner needs GamingConsole impl!
* Component Scan: How does Spring Framework find component classes?
* it scans packages!(@ComponentScan("com.app.blablabla")
*Dependency injection: Identify beans, their dependencies and wire
them together(provides IOC-Inversion of Control)
	* Spring Beans: An object managed by Spring Framework
	* IoC container: Manages the lifecycle of beans and dependencies
		* Types: ApplicationContext(complex), BeanFactory(Simpler features - rarely used)
	* Autowiring: Process of wiring in dependencies for a Spring Bean.
	
-------------------------------------------
Question 3: Does the SpringFramewrk really add value?
* In Game Runner Hello World App, we have very few classes.
* But real world applications are much more complex:
	* Multiple layers(Web, Business, Data etc)
	* Each layer is dependent on the layer below it!
		* Example Business Layer class talks to a Data Layer class
			* Data Layer class is a dependency of Business Layer class.
		* There are thousands of such dependencies in every application.
*  With Spring Framework:
	* Instead of FOCUSING on objects, their dependencies and wiring
		* You can focus on business logic of your aplication!
	* Spring Framework manages the lifecycle of objects:
		*Mark components using annotations: @Component (and others...)
		*Mark dependencies using @Autowired
		*Allow Spring Framework to do its magic!
*Ex: Controller>BusinessService(sum)>DataService(data)!

--------------------------------------------
Question 4: What if I want to run Super Contra game?
-> Used @Primary annotation in SuperContraGame as all the games are having component scan. 
