package org.soyphea.k8s.srevice;
import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;

@Service
public class UserService {

    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));

    public static void main(String[] args) {
        try
        {
            Cipher c1 = Cipher.getInstance("DES"); // Noncompliant: DES works with 56-bit keys allow attacks via exhaustive search
        }
        catch(NoSuchAlgorithmException|NoSuchPaddingException e)
        {
        }
    }

    public List<User> getUser(String containName) {
        String inputPasword = "en duro!!!! nooo!!";

        String query = "SELECT * FROM users WHERE user = '" + containName + "' AND pass = '" + inputPasword + "'"; // Unsafe

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }

}
