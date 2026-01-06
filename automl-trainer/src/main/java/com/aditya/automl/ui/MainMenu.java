package com.aditya.automl.ui;

import com.aditya.automl.data.Dataset;
import com.aditya.automl.data.DatasetLoader;

public class MainMenu {
    public static void main(String[] args) throws Exception {

        // CSV load
        Dataset dataset = DatasetLoader.loadFromCSV(
    "C:/Users/adity/.vscode/ML/AutoML/automl-trainer/data.csv"
);


        // simple verification
        System.out.println("Rows: " + dataset.getRowCount());
        System.out.println("Features per row: " + dataset.getFeatureCount());
    }
}
