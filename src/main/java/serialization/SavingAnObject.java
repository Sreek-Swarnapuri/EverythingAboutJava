package serialization;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SavingAnObject {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Sreek", 999999999);
        saveAccount(ba,"test.dat");
    }

    static void saveAccount(BankAccount ba, String fileName) {
        try(ObjectOutputStream objectStream =
                new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            objectStream.writeObject(ba);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
