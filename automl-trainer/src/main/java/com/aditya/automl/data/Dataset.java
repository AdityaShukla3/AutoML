package com.aditya.automl.data;

public class Dataset {

    // features = input data (X)
    // rows = samples, columns = features
    private double[][] features;

    // labels = output data (y)
    private double[] labels;

    // constructor
    public Dataset(double[][] features, double[] labels) {
        this.features = features;
        this.labels = labels;
    }

    // getters
    public double[][] getFeatures() {
        return features;
    }

    public double[] getLabels() {
        return labels;
    }

    // helper methods
    public int getRowCount() {
        return features.length;
    }

    public int getFeatureCount() {
        return features[0].length;
    }
}
