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
            // mostra a linha
            int line = searchLineOfPosition(matriz, number, indexLine, indexColumn);
            // mostra a coluna
            int column = searchColumnOfPosition(matriz, number, indexLine, indexColumn);
            // se existi o numero do user na matriz
            boolean hasNumberInMatriz = hasNumberInMatriz(line, column);

            if (hasNumberInMatriz) {
                // Mostra a posicao
                System.out.printf("Position %d,%d:\n", line, column);

                // diz se existe um numero a esquerda
                if (hasLeftOfPosition(column)) System.out.println("Left: " + matriz[line][column - 1]);

                // diz se existe um numero a direita
                if (hasRightOfPosition(column, columns)) System.out.println("Right: " + matriz[line][column + 1]);

                // diz se existe um numero em cima
                if (hasUpOfPosition(line)) System.out.println("Up: " + matriz[line - 1][column]);

                // diz se existe um numero em baixo
                if (hasDownOfPosition(line, lines)) System.out.println("Down: " + matriz[line + 1][column]);

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
                if (matriz[line][column] == number) return line;
            }
        }
        return -1;
    }

    public static int searchColumnOfPosition(int[][] matriz, int number, int indexLine, int indexColumn) {
        for (int line = indexLine; line < matriz.length; line++) {
            for (int column = indexColumn; column < matriz[line].length; column++) {
                if (matriz[line][column] == number) return column;
            }
        }
        return -1;
    }

    public static boolean hasNumberInMatriz(int line, int column) {
        if (line == -1 || column == -1) return false;
        return true;
    }

    public static boolean hasLeftOfPosition(int column) {
        if (column - 1 < 0) return false;
        return true;
    }

    public static boolean hasRightOfPosition(int column, int columns) {
        int realTotalIndexColumns = --columns;
        if (column + 1 > realTotalIndexColumns) return false;
        return true;
    }

    public static boolean hasUpOfPosition(int line) {
        if (line + -1 < 0) return false;
        return true;
    }

    public static boolean hasDownOfPosition(int line, int lines) {
        int realTotalIndexLines = --lines;
        if (line + 1 > realTotalIndexLines) return false;
        return true;
    }
}
