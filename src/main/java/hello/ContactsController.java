package hello;

import hello.dao.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Contacts> contacts(@RequestParam(value = "nameFilter", defaultValue = "not") String name) {
        List<Contacts> contacts;
        if (name.equals("A")) {
           contacts = sortContacts("^A.*$");

        } else if (name.equals("B")) {

            contacts = sortContacts("^.*[aei].*$");
        } else {


            contacts = this.contactRepository.findAll();
        }
        return contacts;
    }


    private List<Contacts> sortContacts( String regExp){
        List<Contacts> contacts = new ArrayList();

        for (Contacts contact : contactRepository.findAll()) {
            if (!contact.getName().matches(regExp)) {
                contacts.add(contact);
            }
        }
        return contacts;
    }
}





