
package BotForStatistic.model.generated;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "division_name",
    "division_id",
    "date",
    "score",
    "liveMatchMNHL",
    "sport",
    "teams",
    "iframe"
})
@Generated("jsonschema2pojo")
public class GameInfo {

    @JsonProperty("division_name")
    private String divisionName;
    @JsonProperty("division_id")
    private Integer divisionId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("score")
    private Score score;
    @JsonProperty("liveMatchMNHL")
    private String liveMatchMNHL;
    @JsonProperty("sport")
    private String sport;
    @JsonProperty("teams")
    private Teams teams;
    @JsonProperty("iframe")
    private Iframe iframe;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("division_name")
    public String getDivisionName() {
        return divisionName;
    }

    @JsonProperty("division_name")
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public GameInfo withDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    @JsonProperty("division_id")
    public Integer getDivisionId() {
        return divisionId;
    }

    @JsonProperty("division_id")
    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public GameInfo withDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public GameInfo withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("score")
    public Score getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Score score) {
        this.score = score;
    }

    public GameInfo withScore(Score score) {
        this.score = score;
        return this;
    }

    @JsonProperty("liveMatchMNHL")
    public String getLiveMatchMNHL() {
        return liveMatchMNHL;
    }

    @JsonProperty("liveMatchMNHL")
    public void setLiveMatchMNHL(String liveMatchMNHL) {
        this.liveMatchMNHL = liveMatchMNHL;
    }

    public GameInfo withLiveMatchMNHL(String liveMatchMNHL) {
        this.liveMatchMNHL = liveMatchMNHL;
        return this;
    }

    @JsonProperty("sport")
    public String getSport() {
        return sport;
    }

    @JsonProperty("sport")
    public void setSport(String sport) {
        this.sport = sport;
    }

    public GameInfo withSport(String sport) {
        this.sport = sport;
        return this;
    }

    @JsonProperty("teams")
    public Teams getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public GameInfo withTeams(Teams teams) {
        this.teams = teams;
        return this;
    }

    @JsonProperty("iframe")
    public Iframe getIframe() {
        return iframe;
    }

    @JsonProperty("iframe")
    public void setIframe(Iframe iframe) {
        this.iframe = iframe;
    }

    public GameInfo withIframe(Iframe iframe) {
        this.iframe = iframe;
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

    public GameInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GameInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("divisionName");
        sb.append('=');
        sb.append(((this.divisionName == null)?"<null>":this.divisionName));
        sb.append(',');
        sb.append("divisionId");
        sb.append('=');
        sb.append(((this.divisionId == null)?"<null>":this.divisionId));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("liveMatchMNHL");
        sb.append('=');
        sb.append(((this.liveMatchMNHL == null)?"<null>":this.liveMatchMNHL));
        sb.append(',');
        sb.append("sport");
        sb.append('=');
        sb.append(((this.sport == null)?"<null>":this.sport));
        sb.append(',');
        sb.append("teams");
        sb.append('=');
        sb.append(((this.teams == null)?"<null>":this.teams));
        sb.append(',');
        sb.append("iframe");
        sb.append('=');
        sb.append(((this.iframe == null)?"<null>":this.iframe));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.teams == null)? 0 :this.teams.hashCode()));
        result = ((result* 31)+((this.divisionName == null)? 0 :this.divisionName.hashCode()));
        result = ((result* 31)+((this.liveMatchMNHL == null)? 0 :this.liveMatchMNHL.hashCode()));
        result = ((result* 31)+((this.divisionId == null)? 0 :this.divisionId.hashCode()));
        result = ((result* 31)+((this.iframe == null)? 0 :this.iframe.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.sport == null)? 0 :this.sport.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GameInfo) == false) {
            return false;
        }
        GameInfo rhs = ((GameInfo) other);
        return ((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.teams == rhs.teams)||((this.teams!= null)&&this.teams.equals(rhs.teams))))&&((this.divisionName == rhs.divisionName)||((this.divisionName!= null)&&this.divisionName.equals(rhs.divisionName))))&&((this.liveMatchMNHL == rhs.liveMatchMNHL)||((this.liveMatchMNHL!= null)&&this.liveMatchMNHL.equals(rhs.liveMatchMNHL))))&&((this.divisionId == rhs.divisionId)||((this.divisionId!= null)&&this.divisionId.equals(rhs.divisionId))))&&((this.iframe == rhs.iframe)||((this.iframe!= null)&&this.iframe.equals(rhs.iframe))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.sport == rhs.sport)||((this.sport!= null)&&this.sport.equals(rhs.sport))));
    }

}
