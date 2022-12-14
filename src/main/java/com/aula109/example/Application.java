package com.aula109.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	StudentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args){

		repo.save(new Student("Jade", 17));
		repo.save(new Student("Joyce", 16));
		repo.save(new Student("Maria", 15));
		repo.save(new Student("Carlos", 18));
		repo.save(new Student("Lola", 14));

		System.out.println("\n-->Lista de alunos:\n");

		for (Student sudent : repo.findAll()) {
			System.out.println("\n-->Dados do aluno:\n");
			System.out.println(sudent.toString());
		}

		Student student = repo.findByName("Maria");
		System.out.println("\n-->Procurando Maria:\n");
		System.out.println(student.toString());

	}

}