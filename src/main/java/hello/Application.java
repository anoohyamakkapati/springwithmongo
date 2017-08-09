package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;



    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();


        repository.save(new Student("Anoohya", "Makka"));
        repository.save(new Student("Varun", "Makkapati"));


        System.out.println("Students found with findAll():");
        System.out.println("-------------------------------");
        for (Student student : repository.findAll()) {
            System.out.println(student);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Student found with findByFirstName('Anoohya'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Anoohya"));

        System.out.println("Students found with findByLastName('Makkapati'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByLastName("Makkapati"));
        /*for (Student student : repository.findByLastName("Makkapati")) {
            System.out.println(student);
        }*/

    }

}
