package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner oli = new Scanner(System.in);

		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getpieces());

				System.out.println();
				System.out.println("Source: ");

				ChessPosition source = UI.readChessPosition(oli);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getpieces(), possibleMoves);
				System.out.println();

				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(oli);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				oli.nextLine();
			}
			 catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					oli.nextLine();
			 }
		}
	}
}