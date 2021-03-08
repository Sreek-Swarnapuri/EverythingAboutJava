package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SavingAnObject {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Sreek", 999999999);
        BankAccountWithSerialization ba1 = new BankAccountWithSerialization("Sreek", 999999999);
        BankAccountWithSerialization ba2 = new BankAccountWithSerialization("Pandu", 999999999);
        //Saving a normal bank Account
        saveAccount(ba,"Sreek.dat");

        //Saving an Account Group
        AccountGroup group = new AccountGroup();
        group.addAccount(ba1);
        group.addAccount(ba2);
        //Saving an object
        saveAccountGroup(group,"Swarnapuri.dat");
        //Retrieving an object
        AccountGroup loadedGroup = loadGroup("Swarnapuri.dat");
        System.out.println("Account group balance: " +loadedGroup.getTotalAmount());

    }

    static void saveAccount(BankAccount ba, String fileName) {
        try(ObjectOutputStream objectStream =
                new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            objectStream.writeObject(ba);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void saveAccountGroup(AccountGroup group, String fileName) {
        try(ObjectOutputStream objectStream =
                    new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            objectStream.writeObject(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static AccountGroup loadGroup(String fileName)
            {
        AccountGroup g = null;
        try(ObjectInputStream in =
                new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            g = (AccountGroup) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g;
    }

}
