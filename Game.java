import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Game {


    public static File[] pegarArquivos() {
        File folder = new File("casos_teste");
        return folder.listFiles();
    }

    public static void listarArquivos() {
        var files = pegarArquivos();
        for (int i = 0; i < files.length ; i++) {
                System.out.println(i + " - " + files[i]);
        }
    }

    public static void ler() {
    String fileName = "file.txt";
    String content = "";

    try {
        content = Files.readString(Paths.get(fileName));
    } catch (
    IOException e) {
        e.printStackTrace();
    }
        System.out.println("File content:\n" + content);
}

    public static boolean casoDeTesteValido(Integer value) {
        var stringValue = Integer.toString(value);
        String regex = "[0-8]";
        return stringValue.matches(regex);
    }

    public static String[] readLinesFromFile(String filename) throws IOException {
        int noLinhas = countLines(filename);
        String[] linesArray = new String[noLinhas - 1]; // subtract 1 to ignore the first line
        int count = 0;

        boolean firstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip the first line
                }
                linesArray[count] = line;
                count++;
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return linesArray;
    }


    public static int countLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }

    public static int readNumRodadas(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String firstLine = reader.readLine();
        reader.close();

        // Get the numerical value after "Fazer" keyword
        int startIndex = firstLine.indexOf("Fazer") + "Fazer".length();
        int endIndex = firstLine.indexOf("rodadas");
        String numRodadasStr = firstLine.substring(startIndex, endIndex).trim();
        int numRodadas = Integer.parseInt(numRodadasStr);

        return numRodadas;
    }

    public static Macaco macacoVencedor(Macaco[] macacos) {
        Macaco highestCocosMacaco = null;
        int highestCocosSum = Integer.MIN_VALUE;

        for (Macaco macaco : macacos) {
            int cocosSum = macaco.getNoCocosPares() + macaco.getNoCocosImpares();

            if (cocosSum > highestCocosSum) {
                highestCocosMacaco = macaco;
                highestCocosSum = cocosSum;
            }
        }

        return highestCocosMacaco;
    }



}