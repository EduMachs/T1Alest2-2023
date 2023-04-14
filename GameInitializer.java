import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;


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
        Macaco[] macacos = Macaco.parseMacacoLines(macacosArray);

        Integer noRodadasPartida = Game.readNumRodadas(String.valueOf(listaCasos[casoDeTeste]));
        System.out.print("Número de rodadas: ");
        System.out.println(noRodadasPartida);
        Macaco.printMacacos(macacos);

        int rodadaAtual = 0;
        while ( 0 != ( noRodadasPartida - rodadaAtual)) {
            rodadaAtual = rodadaAtual + 1;
            for (int i = 0; i < macacos.length ; i++) {
                var macacoAtual = macacos[i];

                var macacoRecebePares = macacos[macacoAtual.getIndexMacacoParaPar()];
                macacoRecebePares.setNoCocosPares(macacoAtual.getNoCocosPares() + macacoRecebePares.getNoCocosPares());
                macacoAtual.setNoCocosPares(0);

                var macacoRecebeImpares = macacos[macacoAtual.getIndexMacacoParaImpar()];
                macacoRecebeImpares.setNoCocosImpares(macacoAtual.getNoCocosImpares() + macacoRecebeImpares.getNoCocosImpares());
                macacoAtual.setNoCocosImpares(0);

            }
        }

        Macaco.printMacacos(macacos);
        System.out.println("MACACO VENCEDOR: Macaco " + Game.macacoVencedor(macacos).getIndex());

    }
}