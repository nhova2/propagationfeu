package org.simulation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SimulationConfig {

    public Config load() {
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/parametres.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            double PROBA = Double.parseDouble(properties.getProperty("simulation.proba"));
            int dimensionH = Integer.parseInt(properties.getProperty("simulation.dimension.h"));
            int dimensionL = Integer.parseInt(properties.getProperty("simulation.dimension.l"));
            int positionInitialX = Integer.parseInt(properties.getProperty("simulation.positionInitial.x"));
            int positionInitialY = Integer.parseInt(properties.getProperty("simulation.positionInitial.y"));
            return new Config(PROBA, dimensionH, dimensionL, positionInitialX, positionInitialY);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    class Config {
        private double PROBA;
        private int dimensionH;
        private int dimensionL;
        private int positionInitialX;
        private int positionInitialY;
        public Config(double PROBA,int dimensionH, int dimensionL,int positionInitialX, int positionInitialY) {
            this.PROBA = PROBA;
            this.dimensionH = dimensionH;
            this.dimensionL = dimensionL;
            this.positionInitialX = positionInitialX;
            this.positionInitialY = positionInitialY;
        }

        public double getPROBA() {
            return PROBA;
        }

        public void setPROBA(double PROBA) {
            this.PROBA = PROBA;
        }

        public int getDimensionH() {
            return dimensionH;
        }

        public void setDimensionH(int dimensionH) {
            this.dimensionH = dimensionH;
        }

        public int getDimensionL() {
            return dimensionL;
        }

        public void setDimensionL(int dimensionL) {
            this.dimensionL = dimensionL;
        }

        public int getPositionInitialX() {
            return positionInitialX;
        }

        public void setPositionInitialX(int positionInitialX) {
            this.positionInitialX = positionInitialX;
        }

        public int getPositionInitialY() {
            return positionInitialY;
        }

        public void setPositionInitialY(int positionInitialY) {
            this.positionInitialY = positionInitialY;
        }
    }
}
