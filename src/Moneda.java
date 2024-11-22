import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.Console;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class Moneda {

   String monedaRecibida;
   String convertir;
   double monedaConversion;

    public Moneda(MonedaOmdb miMonedaOmdb) {
        this.monedaRecibida = miMonedaOmdb.base_code();
        this.convertir = miMonedaOmdb.target_code();
        this.monedaConversion = miMonedaOmdb.conversion_result();

    }

    static void cambioDeMoneda(String monedaRecibida,String convertir,int monedaConversion) throws IOException, InterruptedException {

        String direccion = "https://v6.exchangerate-api.com/v6/a2c01c59fdfb36fec062cf00/pair/"+monedaRecibida+"/"+convertir+"/"+monedaConversion;
        //System.out.println(direccion);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json =response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy
                        .UPPER_CAMEL_CASE).create();

        MonedaOmdb miMonedaOmdb = gson.fromJson(json, MonedaOmdb.class);

        System.out.println("el valor de " + monedaConversion+" ("+ miMonedaOmdb.base_code() +") "
        + "corresponde al valor final de "+miMonedaOmdb.conversion_result()+" ("+miMonedaOmdb.target_code()+")");

    }



    @Override
    public String toString() {
        return                "monedaRecibida='" + monedaRecibida + '\'' +
               ", convertir='" + convertir + '\'' +
               ", monedaConversion=" + monedaConversion +
             '}';
    }
}