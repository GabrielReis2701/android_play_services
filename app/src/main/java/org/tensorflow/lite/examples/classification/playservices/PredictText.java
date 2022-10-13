package org.tensorflow.lite.examples.classification.playservices;

public class PredictText {
    private String predicttext,sinal;

    public PredictText(String predicttext, String sinal) {
        this.predicttext = predicttext;
        this.sinal = sinal;
    }

    public PredictText() {

    }

    public String getPredicttext() {
        return predicttext;
    }

    public void setPredicttext(String predicttext) {
        this.predicttext = predicttext;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }
}
