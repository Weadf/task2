package hello;


import java.math.BigInteger;

public class Contacts {


    BigInteger id;
    String name;


    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Contacts(BigInteger id, String name ) {
        this.id = id;
        this.name = name;

    }

}