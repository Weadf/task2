package hello;

import hello.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactsController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts")

    public List<Contacts> contacts (@RequestParam(value = "nameFilter", defaultValue = "not")String name) {
        List<Contacts> contacts = new ArrayList() ;
        System.out.println(name);
if (name.equals("A")){
    for (Contacts contact : contactRepository.findAll()){
        if (!contact.getName().matches("^A.*$")){
            contacts.add(contact);
        }
    }

}else if (name.equals("B")){
    for (Contacts contact : contactRepository.findAll()){
        if (!contact.getName().matches("^.*[aei].*$")){
            contacts.add(contact);
        }
    }
}
else {

        contacts = this.contactRepository.findAll();
}
return contacts;
    }
}





