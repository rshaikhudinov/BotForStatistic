
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "home",
    "away",
    "score_period"
})
@Generated("jsonschema2pojo")
public class Score {

    @JsonProperty("home")
    private Integer home;
    @JsonProperty("away")
    private Integer away;
    @JsonProperty("score_period")
    private String scorePeriod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("home")
    public Integer getHome() {
        return home;
    }

    @JsonProperty("home")
    public void setHome(Integer home) {
        this.home = home;
    }

    public Score withHome(Integer home) {
        this.home = home;
        return this;
    }

    @JsonProperty("away")
    public Integer getAway() {
        return away;
    }

    @JsonProperty("away")
    public void setAway(Integer away) {
        this.away = away;
    }

    public Score withAway(Integer away) {
        this.away = away;
        return this;
    }

    @JsonProperty("score_period")
    public String getScorePeriod() {
        return scorePeriod;
    }

    @JsonProperty("score_period")
    public void setScorePeriod(String scorePeriod) {
        this.scorePeriod = scorePeriod;
    }

    public Score withScorePeriod(String scorePeriod) {
        this.scorePeriod = scorePeriod;
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

    public Score withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Score.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("home");
        sb.append('=');
        sb.append(((this.home == null)?"<null>":this.home));
        sb.append(',');
        sb.append("away");
        sb.append('=');
        sb.append(((this.away == null)?"<null>":this.away));
        sb.append(',');
        sb.append("scorePeriod");
        sb.append('=');
        sb.append(((this.scorePeriod == null)?"<null>":this.scorePeriod));
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
        result = ((result* 31)+((this.scorePeriod == null)? 0 :this.scorePeriod.hashCode()));
        result = ((result* 31)+((this.away == null)? 0 :this.away.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.home == null)? 0 :this.home.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Score) == false) {
            return false;
        }
        Score rhs = ((Score) other);
        return (((((this.scorePeriod == rhs.scorePeriod)||((this.scorePeriod!= null)&&this.scorePeriod.equals(rhs.scorePeriod)))&&((this.away == rhs.away)||((this.away!= null)&&this.away.equals(rhs.away))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.home == rhs.home)||((this.home!= null)&&this.home.equals(rhs.home))));
    }

}
