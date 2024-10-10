package org.simulation;

public class Main {


    public static void main(String[] args) {
        //chargement du fichier de configuration
        SimulationConfig simulationConfig = new SimulationConfig();
        SimulationConfig.Config config = simulationConfig.load();
        if (config!=null){
            SimulationFeu simulationFeu = new SimulationFeu(config.getPROBA(), config.getDimensionH(),config.getDimensionL(),config.getPositionInitialX(), config.getPositionInitialY());
            simulationFeu.initialisationGrille();
            System.out.println("-----------Etat initial-----------");
            simulationFeu.printGrid();
            simulationFeu.simulate();
            System.out.println("-----------Etat final-----------");
            simulationFeu.printGrid();
            System.out.println("-----------Fin du programme-----------");
        }else throw new RuntimeException("Erreur de chargement du fichier de configuration");

    }
}