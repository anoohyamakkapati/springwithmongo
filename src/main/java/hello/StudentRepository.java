package hello;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);

}
