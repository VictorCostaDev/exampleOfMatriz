import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int lines = sc.nextInt();
        int columns = sc.nextInt();

        int[][] matriz = new int[lines][columns];

        for (int line = 0; line < matriz.length; line++) {
            for (int column = 0; column < matriz[line].length; column++) {
                matriz[line][column] = sc.nextInt();
            }
        }

        int number = sc.nextInt();
        int indexLine = 0;
        int indexColumn = 0;

        while (true) {
            // funçao que mostra a linha e outra a coluna
            int line = searchLineOfPosition(matriz, number, indexLine, indexColumn);
            int column = searchColumnOfPosition(matriz, number, indexLine, indexColumn);
            boolean hasNumberInMatriz = hasNumberInMatriz(line, column);

            if (hasNumberInMatriz) {
                // descubra a posição
                System.out.printf("Position %d,%d:\n", line, column);

                // Função que diz se existe o esquerdo e se tiver mostrar
                if (hasLeftOfPosition(column))
                    System.out.println("Left: " + matriz[line][column - 1]);

                // função que diz se existe o direito e mostra
                if (hasRightOfPosition(column, columns))
                    System.out.println("Right: " + matriz[line][column + 1]);

                // função se diz que existe o de cima e mostra
                if (hasUpOfPosition(line))
                    System.out.println("Up: " + matriz[line - 1][column]);

                // função que diz se existe o de baixo e mostra
                if (hasDownOfPosition(line, lines))
                    System.out.println("Down: " + matriz[line + 1][column]);

                indexLine = line;
                indexColumn = ++column;

            } else {
                break;
            }

        }

        sc.close();

    }

    public static int searchLineOfPosition(int[][] matriz, int number, int indexLine, int indexColumn) {
        for (int line = indexLine; line < matriz.length; line++) {
            for (int column = indexColumn; column < matriz[line].length; column++) {
                if (matriz[line][column] == number)
                    return line;
            }
        }
        return -1;
    }

    public static int searchColumnOfPosition(int[][] matriz, int number, int indexLine, int indexColumn) {
        for (int line = indexLine; line < matriz.length; line++) {
            for (int column = indexColumn; column < matriz[line].length; column++) {
                if (matriz[line][column] == number)
                    return column;
            }
        }
        return -1;
    }

    public static boolean hasNumberInMatriz(int line, int column) {
        if (line == -1 || column == -1)
            return false;
        return true;
    }

    public static boolean hasLeftOfPosition(int column) {
        if (column - 1 < 0)
            return false;
        return true;
    }

    public static boolean hasRightOfPosition(int column, int columns) {
        int realTotalIndexColumns = --columns;
        if (column + 1 > realTotalIndexColumns)
            return false;
        return true;
    }

    public static boolean hasUpOfPosition(int line) {
        if (line + -1 < 0)
            return false;
        return true;
    }

    public static boolean hasDownOfPosition(int line, int lines) {
        int realTotalIndexLines = --lines;
        if (line + 1 > realTotalIndexLines)
            return false;
        return true;
    }

}
