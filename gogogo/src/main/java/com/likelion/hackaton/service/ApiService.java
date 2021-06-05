package com.likelion.hackaton.service;

import com.likelion.hackaton.form.Api_AirForm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ApiService {

    public Api_AirForm callApi_air() throws Exception{

        StringBuffer result = new StringBuffer();

        URL url = new URL("http://apis.data.go.kr/B552584/ArpltnStatsSvc/" +
                "getCtprvnMesureLIst?itemCode=PM10&dataGubun=HOUR&pageNo=1&numOfRows=1&returnType=json" +
                "&serviceKey=dzuiZZbhGGhdYgcvkdDPwvCHAdzZ%2FEkmO0%2BAqtpTaXsZLox1We%2BTJtegsxRak6NRX6gcVp" +
                "EwrhGKayRbrDfjAQ%3D%3D&searchCondition=DAY");


        HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;
        while((returnLine = bufferedReader.readLine()) !=null)
            result.append(returnLine+"\n");
        urlConnection.disconnect();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());

        JSONObject response = (JSONObject) jsonObject.get("response");
        JSONObject body = (JSONObject) response.get("body");


        JSONArray cityArray = (JSONArray) body.get("items");
        JSONObject eachCity = (JSONObject) cityArray.get(0);

        System.out.println("seoul : " + eachCity.get("seoul"));

        Api_AirForm api_airForm = Api_AirForm.builder()
                .name("오늘의 공기")
                .seoul((String)eachCity.get("seoul"))
                .busan((String)eachCity.get("busan"))
                .gwangju((String)eachCity.get("gwangju"))
                .jeju((String)eachCity.get("jeju"))
                .dataTime((String) eachCity.get("dataTime"))
                .build();

        return api_airForm;
    }

}
