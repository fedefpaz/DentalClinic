package ProyectoFinal.DentalClinic.Controller;

import ProyectoFinal.DentalClinic.Login.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private DataLoader loader;

    @GetMapping("/")
    public String home () {
        return "<h2>Bienvenido a la aplicación de Dental Clinic</h2>";
    }

    @GetMapping("/user")
    public String user () {
        return "<h2>Bienvenido usuario/a a la aplicación de Dental Clinic</h2>";
    }

    @GetMapping("/admin")
    public String admin () {
        return "<h2>Bienvenido administrador/a a la aplicación de Dental Clinic</h2>";
    }
}
