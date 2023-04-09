import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

public class GameInitializer {

    public static void iniciaJogo() throws IOException {
        iniciaJogo(0);
    }

    public static void iniciaJogo(int casoDeTeste) throws IOException {

        if (!Game.casoDeTesteValido(casoDeTeste)) {
            throw new InvalidParameterException();
        }

        File[] listaCasos = Game.pegarArquivos();
        String[] macacosArray = Game.readLinesFromFile(String.valueOf(listaCasos[casoDeTeste]));
        Integer noRodadas = Game.readNumRodadas(String.valueOf(listaCasos[casoDeTeste]));
        List<Macaco> macacos = Macaco.parseMacacoLines(macacosArray);
        System.out.print("Número de rodadas: ");
        System.out.println(noRodadas);
        Macaco.printMacacos(macacos);
    }
}