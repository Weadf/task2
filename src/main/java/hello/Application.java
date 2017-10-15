package hello;

import hello.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.sql.DataSource;


import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

   // @Qualifier("dataSource")
  // @Qualifier




    @Autowired
    private ContactRepository contactRepository;
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Display all customers...");
        List<Contacts> list = contactRepository.findAll();
        list.forEach(x -> System.out.println(x.getName()));
    }
}
