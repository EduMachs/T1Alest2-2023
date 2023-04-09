import java.util.ArrayList;
import java.util.List;

public class Macaco {
    private int index;
    private Macaco par;
    private Macaco impar;
    private ArrayList<Long> numbers;

    public Macaco(int index) {
        this.index = index;
        this.numbers = new ArrayList<>();
    }

    public void setPar(Macaco par) {
        this.par = par;
    }

    public void setImpar(Macaco impar) {
        this.impar = impar;
    }

    public void addNumber(long number) {
        this.numbers.add(number);
    }


    public int getIndex() {
        return index;
    }

    public Macaco getPar() {
        return par;
    }

    public Macaco getImpar() {
        return impar;
    }

    public ArrayList<Long> getNumbers() {
        return numbers;
    }

    public static Macaco parseMacacoLine(String line) {
        String[] tokens = line.split("\\s+");

        int index = Integer.parseInt(tokens[1]);

        Macaco macaco = new Macaco(index);

        for (int i = 2; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("par")) {
                int parIndex = Integer.parseInt(tokens[i + 2]);
                macaco.setPar(new Macaco(parIndex));
            } else if (token.equals("impar")) {
                int imparIndex = Integer.parseInt(tokens[i + 2]);
                macaco.setImpar(new Macaco(imparIndex));
            } else if (token.equals(":")) {
                int numValues = Integer.parseInt(tokens[i + 1]);

                for (int j = i + 2;j <= i + 2 + numValues; j++) {
                    try {
                        macaco.getNumbers().add(Long.parseLong(tokens[j]));
                    } catch (NumberFormatException e) {
                    }
                }
                break;
            }
        }

        return macaco;
    }

    public static List<Macaco> parseMacacoLines(String[] lines) {
        List<Macaco> macacos = new ArrayList<>();

        for (String line : lines) {
            Macaco macaco = parseMacacoLine(line);
            macacos.add(macaco);
        }

        return macacos;
    }


    public static void printMacacos(List<Macaco> macacos) {
        for (Macaco macaco : macacos) {
            System.out.println(macaco.toString());
        }
    }



    @Override
    public String toString() {
        return "Macaco{" +
                "index=" + index +
                ", par=" + par +
                ", impar=" + impar +
                ", numbers=" + numbers +
                '}';
    }
}
