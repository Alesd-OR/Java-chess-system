/*Created by Alesandro de Oliveira
 * */

package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner oli = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);

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

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = oli.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
						System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
						type = oli.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}

			} catch (ChessException e) {
				System.out.println(e.getMessage());
				oli.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				oli.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}