package org.simulation;

import java.util.Random;

public class SimulationFeu {
    private static final int FORET = 1;
    private static final int ENFEU = 2;
    private static final int CENDRE = 3;


    private double PROBA;
    private int dimensionH;
    private int dimensionL;
    private int positionInitialX;
    private int positionInitialY;
    private int[][] grid;

    public SimulationFeu(double PROBA, int dimensionH, int dimensionL, int positionInitialX, int positionInitialY) {
        this.PROBA = PROBA;
        this.dimensionH = dimensionH;
        this.dimensionL = dimensionL;
        this.positionInitialX = positionInitialX;
        this.positionInitialY = positionInitialY;

    }

    /*
     * Méthode initialisationGrille permet d'initialiser le tableau
     * */
    public void initialisationGrille(){
        /*
         *initialisation grid
         * on initialise la taille du tableau
         *
         * */
        this.grid = new int[dimensionH][dimensionL];
        // on définit  la position initale du  feu
        /*
         * recherche position initiale
         * */
        this.grid[positionInitialX][positionInitialY] = ENFEU;

        for(int i= 0; i< dimensionH; i++){
            for(int j=0; j< dimensionL; j++){
                if(this.grid[i][j] != ENFEU){
                    // on marque cette position en feu
                    this.grid[i][j] = FORET;
                }
            }
        }
    }

    /*
    * Méthode simulate permet de lancer la simulation
    * l'état de moveForward permet de propager le feu ou pas
    * */
    public void simulate(){
        while(true) {
            boolean moveForward = false;
            for (int i = 0; i < dimensionH; i++) {
                for (int j = 0; j < dimensionL; j++) {
                    if (this.grid[i][j] != ENFEU) {
                        this.grid[i][j] = CENDRE;
                        moveForward = true;
                        propagateFire(this.grid, i, j);

                    }else{
                        moveForward = false;
                    }
                }
            }
            if(!moveForward) break;
        }
    }

    /*
     * Méthode propagateFire permet de lancer la propagation du feu en fonction des directions
     * @param grid représente le tableau
     * @param i la position à x
     * @param j la position à y
     * */
    private void propagateFire(int [][] grid, int i, int j) {
        Random random = new Random();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx >= 0 && nx < dimensionH && ny >= 0 && ny < dimensionL && grid[nx][ny] != ENFEU) {
                if (random.nextDouble() < PROBA) {
                    grid[nx][ny] = ENFEU;
                }
            }
        }
    }

    /*
     * Méthode printGrid permet d'afficher le tableau
     * */
    public void printGrid(){
        for(int i= 0; i< dimensionH; i++){
            for(int j=0; j< dimensionL; j++){
                System.out.print(this.grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }



}
