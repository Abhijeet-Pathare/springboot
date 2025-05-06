package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.game.GameRunner;
import com.app.game.GamingConsole;
import com.app.game.MarioGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =
		SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//		MarioGame game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();
//		PacmanGame game = new PacmanGame();
		
//		GamingConsole game = new MarioGame(); //1
//		GameRunner runner = new GameRunner(game); //2
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
	}

}
