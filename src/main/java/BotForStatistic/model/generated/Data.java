
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gameInfo",
    "events"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("gameInfo")
    private GameInfo gameInfo;
    @JsonProperty("events")
    private List<Event> events = new ArrayList<Event>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("gameInfo")
    public GameInfo getGameInfo() {
        return gameInfo;
    }

    @JsonProperty("gameInfo")
    public void setGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
    }

    public Data withGameInfo(GameInfo gameInfo) {
        this.gameInfo = gameInfo;
        return this;
    }

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Data withEvents(List<Event> events) {
        this.events = events;
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

    public Data withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("gameInfo");
        sb.append('=');
        sb.append(((this.gameInfo == null)?"<null>":this.gameInfo));
        sb.append(',');
        sb.append("events");
        sb.append('=');
        sb.append(((this.events == null)?"<null>":this.events));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.events == null)? 0 :this.events.hashCode()));
        result = ((result* 31)+((this.gameInfo == null)? 0 :this.gameInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.events == rhs.events)||((this.events!= null)&&this.events.equals(rhs.events))))&&((this.gameInfo == rhs.gameInfo)||((this.gameInfo!= null)&&this.gameInfo.equals(rhs.gameInfo))));
    }

}
