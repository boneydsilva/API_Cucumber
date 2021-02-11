
package utilities.jsonmanager.general.cucumber;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match__ {

    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("arguments")
    @Expose
    private List<Argument> arguments = null;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

}
