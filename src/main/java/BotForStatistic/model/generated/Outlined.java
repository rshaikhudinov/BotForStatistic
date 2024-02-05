
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icon",
    "score"
})
@Generated("jsonschema2pojo")
public class Outlined {

    @JsonProperty("icon")
    private String icon;
    @JsonProperty("score")
    private String score;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Outlined withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    public Outlined withScore(String score) {
        this.score = score;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Outlined withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Outlined.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.icon == null)? 0 :this.icon.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Outlined) == false) {
            return false;
        }
        Outlined rhs = ((Outlined) other);
        return ((((this.icon == rhs.icon)||((this.icon!= null)&&this.icon.equals(rhs.icon)))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
