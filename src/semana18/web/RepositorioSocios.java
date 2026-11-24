package semana18.web;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioSocios {
    private final List<Socio> socios = List.of(
            new Socio(1, "Ana", 175),
            new Socio(2, "Luis", 250),
            new Socio(3, "Marta", 80)
    );

    public String listarJson() {
        return "[" + socios.stream()
                .map(Socio::toJson)
                .collect(Collectors.joining(", ")) + "]";
    }
}