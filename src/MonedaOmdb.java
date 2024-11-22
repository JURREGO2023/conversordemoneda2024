import com.google.gson.annotations.SerializedName;


public record MonedaOmdb(@SerializedName("base_code")
                         String base_code,
                         @SerializedName("target_code")
                         String target_code,
                         @SerializedName("conversion_result")
                         double conversion_result) {

}
