package org.soyphea.k8s.srevice;
import org.soyphea.k8s.domain.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.h2.security.SHA256;

@Service
public class UserService {

    List<User> users = Arrays.asList(new User(1, "Dara"), new User(2, "Seyha"));

    public List<User> getUser(String containName) {
        String password = "estoy en duro";
        String inputString = "en duro!!!! nooo!!";
        byte[] key         = inputString.getBytes();

        String hashedPass  = SHA256.getHMAC(key, message);  // Noncompliant

        return users.stream().filter(user -> user.getName().contains(containName)).collect(Collectors.toList());
    }
  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");
    PrintWriter out = resp.getWriter();
    out.write("Hello " + name); // Noncompliant
  }

}
