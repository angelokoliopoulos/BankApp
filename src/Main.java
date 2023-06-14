import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.JointAccount;
import gr.aueb.cf.model.User;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User kolios = new User("Angelo","Kolios","556677");
        User Marinka = new User("Marina","Marinochka","557788");
        Account koliosAccount = new Account(kolios,"GR12345",48500);




        printUserDetails(Marinka);
        }

        public static void printUserDetails(User user){
             System.out.println(user.toString());
        }

    }
