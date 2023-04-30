package Current;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;

public class MainCurrent {
    public static void main(String[] args) throws IOException {
        //Создаем клиента
        OkHttpClient client = new OkHttpClient();

        //Настраиваем addQueryParameter для URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.weatherapi.com/v1/current.json").newBuilder();
        urlBuilder.addQueryParameter("key", "private_key");
        urlBuilder.addQueryParameter("q", "Омск");

        String url = urlBuilder.build().toString();

        //Создаем запрос
        Request request = new Request.Builder()
                .url(url)
                .build();

        //Совершаем запрос
        Call call = client.newCall(request);

        //Получаем ответ
        Response response = call.execute();

        //Проверяем ответ
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
