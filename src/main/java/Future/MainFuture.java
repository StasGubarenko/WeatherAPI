package Future;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;

public class MainFuture {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder builder = HttpUrl.parse("http://api.weatherapi.com/v1/future.json").newBuilder();
        builder.addQueryParameter("key", "58017c49095544888d3141958231204");
        builder.addQueryParameter("dt", "2023-05-15");
        builder.addQueryParameter("q", "London");

        String url = builder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);

        Response response = call.execute();

        if (response.isSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = response.body().string();
            Future future = objectMapper.readValue(json, Future.class);
            System.out.println(future);
        } else {
            System.out.println(response.code() + " " + response.body().string());
        }
    }
}
