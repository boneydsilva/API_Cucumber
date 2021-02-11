
package utilities.jsonmanager.general.cucumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Before {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("match")
    @Expose
    private Match match;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

}
