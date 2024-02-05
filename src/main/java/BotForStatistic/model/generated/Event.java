
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "e_name",
    "event_id",
    "params",
    "is_home"
})
@Generated("jsonschema2pojo")
public class Event {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("e_name")
    private String eName;
    @JsonProperty("event_id")
    private Integer eventId;
    @JsonProperty("params")
    private Params params;
    @JsonProperty("is_home")
    private Boolean isHome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Event withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("e_name")
    public String geteName() {
        return eName;
    }

    @JsonProperty("e_name")
    public void seteName(String eName) {
        this.eName = eName;
    }

    public Event witheName(String eName) {
        this.eName = eName;
        return this;
    }

    @JsonProperty("event_id")
    public Integer getEventId() {
        return eventId;
    }

    @JsonProperty("event_id")
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Event withEventId(Integer eventId) {
        this.eventId = eventId;
        return this;
    }

    @JsonProperty("params")
    public Params getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(Params params) {
        this.params = params;
    }

    public Event withParams(Params params) {
        this.params = params;
        return this;
    }

    @JsonProperty("is_home")
    public Boolean getIsHome() {
        return isHome;
    }

    @JsonProperty("is_home")
    public void setIsHome(Boolean isHome) {
        this.isHome = isHome;
    }

    public Event withIsHome(Boolean isHome) {
        this.isHome = isHome;
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

    public Event withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Event.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("eName");
        sb.append('=');
        sb.append(((this.eName == null)?"<null>":this.eName));
        sb.append(',');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("params");
        sb.append('=');
        sb.append(((this.params == null)?"<null>":this.params));
        sb.append(',');
        sb.append("isHome");
        sb.append('=');
        sb.append(((this.isHome == null)?"<null>":this.isHome));
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
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.eName == null)? 0 :this.eName.hashCode()));
        result = ((result* 31)+((this.isHome == null)? 0 :this.isHome.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.params == null)? 0 :this.params.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Event) == false) {
            return false;
        }
        Event rhs = ((Event) other);
        return (((((((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId)))&&((this.eName == rhs.eName)||((this.eName!= null)&&this.eName.equals(rhs.eName))))&&((this.isHome == rhs.isHome)||((this.isHome!= null)&&this.isHome.equals(rhs.isHome))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.params == rhs.params)||((this.params!= null)&&this.params.equals(rhs.params))));
    }

}
