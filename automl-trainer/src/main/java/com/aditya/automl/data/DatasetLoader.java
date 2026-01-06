package com.aditya.automl.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {

    /**
     * CSV format assumption:
     * - First row = header
     * - Last column = label (output)
     * - Remaining columns = features (inputs)
     */
    public static Dataset loadFromCSV(String filePath) throws IOException {

        List<double[]> featureList = new ArrayList<>();
        List<Double> labelList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        // skip header
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");

            int n = tokens.length;

            double[] features = new double[n - 1];
            for (int i = 0; i < n - 1; i++) {
                features[i] = Double.parseDouble(tokens[i].trim());
            }

            double label = Double.parseDouble(tokens[n - 1].trim());

            featureList.add(features);
            labelList.add(label);
        }

        br.close();

        // convert List -> array
        double[][] X = featureList.toArray(new double[0][]);
        double[] y = new double[labelList.size()];
        for (int i = 0; i < labelList.size(); i++) {
            y[i] = labelList.get(i);
        }

        return new Dataset(X, y);
    }
}
