
package utilities.jsonmanager.general.cucumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Argument {

    @SerializedName("val")
    @Expose
    private String val;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
