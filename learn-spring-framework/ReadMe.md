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
 
 