package com.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.game.GameRunner;
import com.app.game.MarioGame;
import com.app.game.PacmanGame;
import com.app.game.SuperContraGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//		MarioGame game = new MarioGame();
//		SuperContraGame game = new SuperContraGame();
		PacmanGame game = new PacmanGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}

}
