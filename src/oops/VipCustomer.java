package oops;

public class VipCustomer {
    private String name;
    private int limit;
    private String email;

    public VipCustomer() {
        this("Default Name",0,"default@emial.com");
        System.out.println("empty constructor");
    }

    @Override
    public String toString() {
        return "VipCustomer{" +
                "name='" + name + '\'' +
                ", limit=" + limit +
                ", email='" + email + '\'' +
                '}';
    }

    public VipCustomer(String name, int limit){
        this(name,limit,"default@email.com");
        System.out.println("Two args constructor");
    }
    public VipCustomer(String name, int limit, String email){
        this.name = name;
        this.limit = limit;
        this.email = email;
        System.out.println("All args constructor");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
