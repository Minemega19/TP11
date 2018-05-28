package tp10;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;


public class Bataille {
private Pokemon p1,p2;

public Bataille(Pokemon p1, Pokemon p2) {
	this.p1 = p1;
	this.p2 = p2;
}

public Pokemon getP1() {
	return p1;
}

public Pokemon getP2() {
	return p2;
}
public void run() {
	
		Scanner lecteur = new Scanner(System.in);
		System.out.println();
			
			boolean batailleFinie = false;
		
			while (!batailleFinie) {
				if (p1.sEstEvanoui() || p2.sEstEvanoui()) {
					batailleFinie = true;
				}
				if(!batailleFinie) {
					p1.regarderAttaques();
					System.out.println("Pour pokemon" +p1.getNom() + ", choisissez l'index de votre attaque contre le pokemon " + p2.getNom());
					int reponseIndex = lecteur.nextInt();
					while (reponseIndex < 0 || reponseIndex > p1.getSesAttaques().size()) {
						System.out.println("Refaites votre choix.");
						reponseIndex = lecteur.nextInt();
					}
					p1.utiliseAttaque(reponseIndex, p2);
					if (p2.sEstEvanoui()) {
						batailleFinie = true;
					}
				}
				
				if(!batailleFinie && !p2.sEstEvanoui()) {
					p2.regarderAttaques();
					System.out.println("Pour pokemon" +p2.getNom() + ", choisissez l'index votre attaque contre le pokemon " + p1.getNom());
					int reponseIndex = lecteur.nextInt();
					while (reponseIndex < 0 || reponseIndex > p2.getSesAttaques().size()) {
						System.out.println("Refaites votre choix.");
						reponseIndex = lecteur.nextInt();
					}
					p2.utiliseAttaque(reponseIndex, p1);
					if (p1.sEstEvanoui()) {
						batailleFinie = true;
					}
				}
			}

			if (p1.sEstEvanoui()) {
				System.out.println("Le vainqueur est " + p2.getNom());
			}
			else {
				System.out.println("Le vainqueur est " + p1.getNom());
			}
			
			p1.resetAttaques();
			p2.resetAttaques();
			
}
}
