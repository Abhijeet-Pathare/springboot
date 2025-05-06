package com.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.game.GameRunner;
import com.app.game.MarioGame;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		MarioGame game = new MarioGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}

}
