package Application;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner oli = new Scanner(System.in);

		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			UI.printBoard(chessMatch.getpieces());
			
			System.out.println();
			System.out.println("Source: ");
			
			ChessPosition source = UI.readChessPosition(oli);
			System.out.println();
			
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(oli);

			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		}

	}

}
