
package utilities.jsonmanager.general.cucumber;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Element {

    @SerializedName("start_timestamp")
    @Expose
    private String startTimestamp;
    @SerializedName("before")
    @Expose
    private List<Before> before = null;
    @SerializedName("line")
    @Expose
    private Integer line;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("after")
    @Expose
    private List<After> after = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;

    public String getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(String startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public List<Before> getBefore() {
        return before;
    }

    public void setBefore(List<Before> before) {
        this.before = before;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<After> getAfter() {
        return after;
    }

    public void setAfter(List<After> after) {
        this.after = after;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

}
