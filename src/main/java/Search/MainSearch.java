package Search;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.Arrays;

public class MainSearch {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder builder = HttpUrl.parse("http://api.weatherapi.com/v1/search.json").newBuilder();
        builder.addQueryParameter("key", "58017c49095544888d3141958231204");
        builder.addQueryParameter("q", "London");

        String url = builder.build().toString();

        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);

        Response response = call.execute();

        if (response.isSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = response.body().string();
            City[] cities = objectMapper.readValue(json, City[].class);
            System.out.println(Arrays.toString(cities));
        } else {
            System.out.println(response.code() + " " + response.body().string());
        }
    }
}
