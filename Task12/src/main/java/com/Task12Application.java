package com;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@SpringBootApplication
public class Task12Application {
	static String __arg1;
	static String __arg2;

	public static void main(String[] args) {
		__arg1 =  "C:/Users/Daniil/text.txt"; // args[0]
		__arg2 =  "C:/Users/Daniil/hashed.hash"; // args[1]
		SpringApplication.run(Task12Application.class, args);
	}

	@Component
	public static class A {
		final File txt = new File(__arg1);
		final File hash = new File(__arg2);

		@SneakyThrows
		@PostConstruct
		public void st() {
			StringBuilder writ = new StringBuilder();
			if(txt.exists()){
				FileReader reader = new FileReader(txt);
				while (reader.read() != -1){
					writ.append(reader.getEncoding());
				}
				reader.close();
			}
			else
				writ = new StringBuilder("null");
			assert hash.exists() || hash.createNewFile();

			FileWriter writer = new FileWriter(hash);
			writer.write(String.valueOf(txt.exists() ? writ.toString().hashCode() : writ.toString()));
			writer.close();
		}

		@PreDestroy public void en() {
			txt.delete();
		}
	}
}
