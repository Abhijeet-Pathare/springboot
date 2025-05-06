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
1) Whats happening in the background ? to know lets go into the logging debug level.
Identified candidate component class: file [D:\My Learning\Springboot\springboot\learn-spring-framework\target\classes\com\app\game\GameRunner.class]
Identified candidate component class: file [D:\My Learning\Springboot\springboot\learn-spring-framework\target\classes\com\app\game\MarioGame.class]
Creating shared instance of singleton bean 'gameRunner'
Creating shared instance of singleton bean 'marioGame'
Autowiring by type from bean name 'gameRunner' via constructor to bean named 'marioGame'