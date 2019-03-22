package com.bonitasoft.ml;

/**
 * @author Pablo Alonso de Linaje García
 */
public class MLRequest {
    private String projectId;
    private String modelId;
    private String versionId;
    private String json;

    public MLRequest(){
        super();
    }
    public MLRequest(String projectId, String modelId , String versionId, String json){
        this.setProjectId(projectId);
        this.setModelId(modelId);
        this.setVersionId(versionId);
        this.setJson(json);
    }

    public String getProjectId() {
        return projectId;
    }

    public String getModelId() {
        return modelId;
    }

    public String getVersionId() {
        return versionId;
    }

    public String getJson() {
        return json;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
