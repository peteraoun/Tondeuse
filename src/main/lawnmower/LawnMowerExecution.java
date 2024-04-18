package main.lawnmower;

import main.orientation.Orientation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LawnMowerExecution {
    public static void main(String[] args) {
        try {
            //lire le fichier et attribuer les valeurs a la tendeuse en fonction des valeurs dans le fichier
            File file = new File("src/main/java/resources/input.txt");
            Scanner scanner = new Scanner(file);
            // Lire les dimensions de la pelouse
            int maxX = scanner.nextInt();
            int maxY = scanner.nextInt();

            // Traiter chaque entrée de tondeuse
            while (scanner.hasNext()) {
                // Lire la position initiale et l'orientation de la tondeuse
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Orientation orientation = Orientation.valueOf(scanner.next());
                String instructions = scanner.next();

                // Créer un objet tondeuse
                LawnMower lawnMower = new LawnMower(x, y, orientation);
                
               // Déplacer la tondeuse selon les instructions
                lawnMower.move(instructions, maxX, maxY);
                
                // Afficher la position finale de la tondeuse
                System.out.println(lawnMower.getPosition());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}