package ProyectoFinal.DentalClinic.Login;

import ProyectoFinal.DentalClinic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        if (userRepository.findAll().isEmpty()) {
            userRepository.save(new AppUser("Fede", "fede", password, "fede@gmail.com", AppUserRoles.ADMIN));
            userRepository.save(new AppUser("Fabi", "fabi", password2, "fabi@gmail.com", AppUserRoles.USER));
        }
    }
}