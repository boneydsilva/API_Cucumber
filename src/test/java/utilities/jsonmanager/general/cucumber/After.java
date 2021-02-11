
package utilities.jsonmanager.general.cucumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class After {

    @SerializedName("result")
    @Expose
    private Result_ result;
    @SerializedName("match")
    @Expose
    private Match_ match;

    public Result_ getResult() {
        return result;
    }

    public void setResult(Result_ result) {
        this.result = result;
    }

    public Match_ getMatch() {
        return match;
    }

    public void setMatch(Match_ match) {
        this.match = match;
    }

}
