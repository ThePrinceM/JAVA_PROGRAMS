import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class User {
    protected String username;
    protected String password;
    protected String mobileNumber;
    protected boolean isActive;
    protected String gender;
    protected Date createdDate;

    public User(String username, String password, String mobileNumber, boolean isActive, String gender, Date createdDate) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
        this.gender = gender;
        this.createdDate = createdDate;
    }

    public final void printUser() {
        System.out.println("Username: " + username);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Gender: " + gender);
        System.out.println("Created Date: " + createdDate);
    }

    abstract void display();
}

class StandardUser extends User {
    private String alias;
    private Date lastLogin;
    private String role;

    public StandardUser(String username, String password, String mobileNumber, boolean isActive, String gender, Date createdDate, String alias, Date lastLogin, String role) {
        super(username, password, mobileNumber, isActive, gender, createdDate);
        this.alias = alias;
        this.lastLogin = lastLogin;
        this.role = role;
    }

    @Override
    void display() {
        if (gender.equals("Female")) {
            printUser();
            System.out.println("Alias: " + alias);
            System.out.println("Last Login: " + lastLogin);
            System.out.println("Role: " + role);
        }
    }
}

class CustomUser extends User {
    private String email;
    private String securityKey;
    private String manager;

    public CustomUser(String username, String password, String mobileNumber, boolean isActive, String gender, Date createdDate, String email, String securityKey, String manager) {
        super(username, password, mobileNumber, isActive, gender, createdDate);
        this.email = email;
        this.securityKey = securityKey;
        this.manager = manager;
    }

    @Override
    void display() {
        if (createdDate.before(new Date(100, 0, 1)) && email.contains("gmail.com")) {
            printUser();
            System.out.println("Email: " + email);
            System.out.println("Manager: " + manager);
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new StandardUser("user1", "pass1", "1234567890", true, "Female", new Date(), "alias1", new Date(), "role1"));
        users.add(new CustomUser("user2", "pass2", "0987654321", true, "Male", new Date(99, 0, 1), "user2@gmail.com", "key2", "manager2"));
        for (User user : users) {
            user.display();
        }
    }
}
