package Forecast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;

public class MainForecast {
    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.weatherapi.com/v1/forecast.json").newBuilder();
        urlBuilder.addQueryParameter("key", "58017c49095544888d3141958231204");
        urlBuilder.addQueryParameter("q", "London");
        urlBuilder.addQueryParameter("days", "1");
        urlBuilder.addQueryParameter("api", "no");

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);

        Response response = call.execute();

        if (response.isSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = response.body().string();
            Weather weather = objectMapper.readValue(json, Weather.class);
            System.out.println(weather);
        } else {
            System.out.println(response.code() + " " + response.body().string());
        }
    }
}
