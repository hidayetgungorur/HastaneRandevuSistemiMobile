package com.example.bhrs.General;
import com.fasterxml.jackson.annotation.JsonProperty;
public class HeaderRequest {
    @JsonProperty("ChannelCode")
    public String channelCode;
    @JsonProperty("ChannelPassword")
    public String channelPassword;
}
