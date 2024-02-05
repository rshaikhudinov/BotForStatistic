
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "timeevent",
    "score",
    "minutes",
    "outlined",
    "team"
})
@Generated("jsonschema2pojo")
public class Params {

    @JsonProperty("name")
    private String name;
    @JsonProperty("timeevent")
    private String timeevent;
    @JsonProperty("score")
    private String score;
    @JsonProperty("minutes")
    private String minutes;
    @JsonProperty("outlined")
    private Outlined outlined;
    @JsonProperty("team")
    private String team;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Params withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("timeevent")
    public String getTimeevent() {
        return timeevent;
    }

    @JsonProperty("timeevent")
    public void setTimeevent(String timeevent) {
        this.timeevent = timeevent;
    }

    public Params withTimeevent(String timeevent) {
        this.timeevent = timeevent;
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

    public Params withScore(String score) {
        this.score = score;
        return this;
    }

    @JsonProperty("minutes")
    public String getMinutes() {
        return minutes;
    }

    @JsonProperty("minutes")
    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public Params withMinutes(String minutes) {
        this.minutes = minutes;
        return this;
    }

    @JsonProperty("outlined")
    public Outlined getOutlined() {
        return outlined;
    }

    @JsonProperty("outlined")
    public void setOutlined(Outlined outlined) {
        this.outlined = outlined;
    }

    public Params withOutlined(Outlined outlined) {
        this.outlined = outlined;
        return this;
    }

    @JsonProperty("team")
    public String getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(String team) {
        this.team = team;
    }

    public Params withTeam(String team) {
        this.team = team;
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

    public Params withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Params.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("timeevent");
        sb.append('=');
        sb.append(((this.timeevent == null)?"<null>":this.timeevent));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("minutes");
        sb.append('=');
        sb.append(((this.minutes == null)?"<null>":this.minutes));
        sb.append(',');
        sb.append("outlined");
        sb.append('=');
        sb.append(((this.outlined == null)?"<null>":this.outlined));
        sb.append(',');
        sb.append("team");
        sb.append('=');
        sb.append(((this.team == null)?"<null>":this.team));
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
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.outlined == null)? 0 :this.outlined.hashCode()));
        result = ((result* 31)+((this.minutes == null)? 0 :this.minutes.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.timeevent == null)? 0 :this.timeevent.hashCode()));
        result = ((result* 31)+((this.team == null)? 0 :this.team.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Params) == false) {
            return false;
        }
        Params rhs = ((Params) other);
        return ((((((((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score)))&&((this.outlined == rhs.outlined)||((this.outlined!= null)&&this.outlined.equals(rhs.outlined))))&&((this.minutes == rhs.minutes)||((this.minutes!= null)&&this.minutes.equals(rhs.minutes))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.timeevent == rhs.timeevent)||((this.timeevent!= null)&&this.timeevent.equals(rhs.timeevent))))&&((this.team == rhs.team)||((this.team!= null)&&this.team.equals(rhs.team))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
