
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "video",
    "timeStart",
    "timesh"
})
@Generated("jsonschema2pojo")
public class Iframe {

    @JsonProperty("video")
    private String video;
    @JsonProperty("timeStart")
    private String timeStart;
    @JsonProperty("timesh")
    private String timesh;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("video")
    public String getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(String video) {
        this.video = video;
    }

    public Iframe withVideo(String video) {
        this.video = video;
        return this;
    }

    @JsonProperty("timeStart")
    public String getTimeStart() {
        return timeStart;
    }

    @JsonProperty("timeStart")
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public Iframe withTimeStart(String timeStart) {
        this.timeStart = timeStart;
        return this;
    }

    @JsonProperty("timesh")
    public String getTimesh() {
        return timesh;
    }

    @JsonProperty("timesh")
    public void setTimesh(String timesh) {
        this.timesh = timesh;
    }

    public Iframe withTimesh(String timesh) {
        this.timesh = timesh;
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

    public Iframe withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Iframe.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("video");
        sb.append('=');
        sb.append(((this.video == null)?"<null>":this.video));
        sb.append(',');
        sb.append("timeStart");
        sb.append('=');
        sb.append(((this.timeStart == null)?"<null>":this.timeStart));
        sb.append(',');
        sb.append("timesh");
        sb.append('=');
        sb.append(((this.timesh == null)?"<null>":this.timesh));
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
        result = ((result* 31)+((this.video == null)? 0 :this.video.hashCode()));
        result = ((result* 31)+((this.timeStart == null)? 0 :this.timeStart.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.timesh == null)? 0 :this.timesh.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Iframe) == false) {
            return false;
        }
        Iframe rhs = ((Iframe) other);
        return (((((this.video == rhs.video)||((this.video!= null)&&this.video.equals(rhs.video)))&&((this.timeStart == rhs.timeStart)||((this.timeStart!= null)&&this.timeStart.equals(rhs.timeStart))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.timesh == rhs.timesh)||((this.timesh!= null)&&this.timesh.equals(rhs.timesh))));
    }

}
