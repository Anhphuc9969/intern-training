import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class User {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

class Address {

    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}

public class OptionalEx {
    public static String getStreetPreJava8() {
        User user = getUser();
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                String street = address.getStreet();
                if (street != null) {
                    return street;
                }
            }
        }
        return "not specified";
    }

    public static String getStreetJava8() {
        Optional<User> user = Optional.ofNullable(getUser());

        return user.map(User::getAddress)
                .map(Address::getStreet)
                .orElse("not specified");
    }

    private static User getUser() {
        User user=new User();

        Address address=new Address();
        address.setStreet("Thanh Hóa");
        user.setAddress(address);
        return user;
    }

    private static List<String> getList() {
        return null;
    }

    private static Optional<List<String>> getList2() {
        return Optional.ofNullable(null);
    }

    public static void main(String [] args){

//        System.out.println("___here is getAddressPreJava8: "+OptionalEx.getStreetPreJava8());
//        System.out.println("___here is getAddressJava8: "+OptionalEx.getStreetJava8());


        /*filter*/
//        Optional<String> me = Optional.of("gpcoder");
//        Optional<String> emptyOptional = Optional.empty();
//
//        //Filter on Optional
//        System.out.println(me.filter(g -> g.equals("GPCODER"))); //Optional.empty
//        System.out.println(me.filter(g -> g.equalsIgnoreCase("gpcoder"))); //Optional[gpcoder]
//        System.out.println(emptyOptional.filter(g -> g.equalsIgnoreCase("gpcoder"))); //Optional.empty

        /*orElse*/
        // Pre java 8
        List<String> list = getList();
        List<String> listOpt = list != null ? list : new ArrayList<>();

        // Java 8
        List<String> listOpt2 = getList2().orElse(new ArrayList<>());
        List<String> listOpt3 = getList2().orElseGet(() -> new ArrayList<>());

    }

}
