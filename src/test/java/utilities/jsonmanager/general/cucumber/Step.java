
package utilities.jsonmanager.general.cucumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("result")
    @Expose
    private Result__ result;
    @SerializedName("line")
    @Expose
    private Integer line;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("match")
    @Expose
    private Match__ match;
    @SerializedName("keyword")
    @Expose
    private String keyword;

    public Result__ getResult() {
        return result;
    }

    public void setResult(Result__ result) {
        this.result = result;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Match__ getMatch() {
        return match;
    }

    public void setMatch(Match__ match) {
        this.match = match;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
