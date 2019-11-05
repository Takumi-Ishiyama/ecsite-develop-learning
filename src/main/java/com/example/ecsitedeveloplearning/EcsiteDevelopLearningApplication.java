package com.example.ecsitedeveloplearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcsiteDevelopLearningApplication {

	public static void main(String[] args) {
		/**
		デフォルトだとHTML5モードで起動する。
		Thymeleaf ver 3.x 系ではHTMLモードでの起動が推奨される。
		これを記述しておくことで、HTMLモードで起動する
		*/
		SpringApplication.run(EcsiteDevelopLearningApplication.class, args);
	}
}
