package com.bonitasoft.ml;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Pablo Alonso de Linaje García
 */
@RestController
public class MLController {


    @GetMapping("/predict")
    public String predict(@RequestParam(value="projectId", defaultValue="demoforrester") String projectId,
                          @RequestParam(value="modelId", defaultValue="census_forrester_3") String modelId,
                          @RequestParam(value="versionId", defaultValue="v1") String versionId,
                          @RequestParam(value="json", defaultValue="{\"instances\": [{\"age\": 25, \"workclass\": \" Private\", \"education\": \" 11th\", \"education_num\": 7, \"marital_status\": \" Never-married\", \"occupation\": \" Machine-op-inspct\", \"relationship\": \" Own-child\", \"race\": \" Black\", \"gender\": \" Male\", \"capital_gain\": 0, \"capital_loss\": 0, \"hours_per_week\": 40, \"native_country\": \" United-States\"}]}") String json) {
        try {
            return OnlinePrediction.predict(projectId, modelId, versionId, json);
        }catch (Exception e){
            e.printStackTrace();
            return "{\"ERROR\":\""+ e.getMessage() +"\"}";
        }


    }

    @PostMapping("/predict")
    public String predict(@RequestBody MLRequest request) {
        try {
            return OnlinePrediction.predict(request.getProjectId(), request.getModelId(), request.getVersionId(), request.getJson());
        }catch (Exception e){
            return "ERROR";
        }


    }

}


