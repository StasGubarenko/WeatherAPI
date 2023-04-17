package Astronomy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;

public class MainAstronomy {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder builder = HttpUrl.parse("http://api.weatherapi.com/v1/astronomy.json").newBuilder();
        builder.addQueryParameter("key", "58017c49095544888d3141958231204");
        builder.addQueryParameter("q", "London");

        String url = builder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);

        Response response = call.execute();

        if (response.isSuccessful()) {
            String json = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            AstronomyInfo astronomyInfo = objectMapper.readValue(json, AstronomyInfo.class);
            System.out.println(astronomyInfo);
        } else {
            System.out.println(response.code() + " " + response.body());
        }
    }
}
