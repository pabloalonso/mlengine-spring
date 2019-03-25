package com.bonitasoft.ml;

/**
 * @author Pablo Alonso de Linaje García
 */
public class OnlinePredictionTest {
    public static void main(String[] args) throws Exception {
        String projectId = "demoforrester";
        String modelId = "census_forrester_3";
        String versionId = "v1";
        String json = "{\"instances\": [{\"age\": 25, \"workclass\": \" Private\", \"education\": \" 11th\", \"education_num\": 7, \"marital_status\": \" Never-married\", \"occupation\": \" Machine-op-inspct\", \"relationship\": \" Own-child\", \"race\": \" Black\", \"gender\": \" Male\", \"capital_gain\": 0, \"capital_loss\": 0, \"hours_per_week\": 40, \"native_country\": \" United-States\"}]}";
        System.out.println(json);
        String output = new OnlinePrediction().predict(projectId,modelId,versionId,json);
        System.out.println(output);
    }
}
