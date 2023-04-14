import java.util.ArrayList;
import java.util.List;

public class Macaco {
    private int index;
    private int indexMacacoParaPar;
    private int indexMacacoParaImpar;
    private int noCocosPares;
    private int noCocosImpares;

    public Macaco(int index) {
        this.index = index;
    }

    public void setIndexMacacoParaPar(int indexMacacoParaPar) {
        this.indexMacacoParaPar = indexMacacoParaPar;
    }

    public void setIndexMacacoParaImpar(int indexMacacoParaImpar) {
        this.indexMacacoParaImpar = indexMacacoParaImpar;
    }

    public void setNoCocosPares(int noCocosPares) {
        this.noCocosPares = noCocosPares;
    }

    public void setNoCocosImpares(int noCocosImpares) {
        this.noCocosImpares = noCocosImpares;
    }

    public int getIndex() {
        return index;
    }

    public int getIndexMacacoParaPar() {
        return indexMacacoParaPar;
    }

    public int getIndexMacacoParaImpar() {
        return indexMacacoParaImpar;
    }

    public int getNoCocosPares() {
        return noCocosPares;
    }

    public int getNoCocosImpares() {
        return noCocosImpares;
    }

    public static Macaco parseMacacoLine(String line) {
        String[] tokens = line.split("\\s+");

        int index = Integer.parseInt(tokens[1]);

        Macaco macaco = new Macaco(index);

        for (int i = 2; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("par")) {
                int parIndex = Integer.parseInt(tokens[i + 2]);
                macaco.setIndexMacacoParaPar(parIndex);
            } else if (token.equals("impar")) {
                int imparIndex = Integer.parseInt(tokens[i + 2]);
                macaco.setIndexMacacoParaImpar(imparIndex);
            } else if (token.equals(":")) {
                int numValues = Integer.parseInt(tokens[i + 1]);

                int evenCount = 0;
                int oddCount = 0;

                for (int j = i + 2; j <= i + 2 + numValues; j++) {
                    try {
                        long value = Long.parseLong(tokens[j]);

                        if (value % 2 == 0) {
                            evenCount++;
                        } else {
                            oddCount++;
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                macaco.setNoCocosPares(evenCount);
                macaco.setNoCocosImpares(oddCount);

                break;
            }
        }

        return macaco;
    }

    public static Macaco[] parseMacacoLines(String[] lines) {
        List<Macaco> macacos = new ArrayList<>();

        for (String line : lines) {
            Macaco macaco = parseMacacoLine(line);
            macacos.add(macaco);
        }

        return macacos.toArray(new Macaco[0]);
    }


    public static void printMacacos(Macaco[] macacos) {
        for (Macaco macaco : macacos) {
            System.out.println(macaco.toString());
        }
    }

    @Override
    public String toString() {
        return "Macaco{" +
                "index=" + index +
                ", indexMacacoParaPar=" + indexMacacoParaPar +
                ", indexMacacoParaImpar=" + indexMacacoParaImpar +
                ", noCocosPares=" + noCocosPares +
                ", noCocosImpares=" + noCocosImpares +
                '}';
    }
}