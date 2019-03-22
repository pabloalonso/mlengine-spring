package com.bonitasoft.ml;/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.discovery.Discovery;
import com.google.api.services.discovery.model.JsonSchema;
import com.google.api.services.discovery.model.RestDescription;
import com.google.api.services.discovery.model.RestMethod;



/*
 * Sample code for doing Cloud Machine Learning Engine online prediction in Java.
 */

public class OnlinePrediction {




    public static String predict(String projectId, String modelId , String versionId, String json) throws Exception{

    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    Discovery discovery = new Discovery.Builder(httpTransport, jsonFactory, null).build();

    RestDescription api = discovery.apis().getRest("ml", "v1").execute();
    RestMethod method = api.getResources().get("projects").getMethods().get("predict");

    JsonSchema param = new JsonSchema();

    param.set(
        "name", String.format("projects/%s/models/%s/versions/%s", projectId, modelId, versionId));

    GenericUrl url =
        new GenericUrl(UriTemplate.expand(api.getBaseUrl() + method.getPath(), param, true));

    String contentType = "application/json";
    /*
    File requestBodyFile = new File("input2.txt");
    HttpContent content = new FileContent(contentType, requestBodyFile);
    */
    final byte [] contentBytes = json.getBytes();
    final HttpContent content = new ByteArrayContent(contentType, contentBytes );

    GoogleCredential credential = GoogleCredential.getApplicationDefault();
    /*
    File initialFile = new File("credentials.json");
    InputStream inputStream = new FileInputStream(initialFile);
    //GoogleCredential credential = GoogleCredential.fromStream(inputStream, httpTransport, jsonFactory);
    */

    HttpRequestFactory requestFactory = httpTransport.createRequestFactory(credential);
    HttpRequest request = requestFactory.buildRequest(method.getHttpMethod(), url, content);

    String response = request.execute().parseAsString();
    //    System.out.println(response);
    return response;
  }
}

