package com.elmarrakchy.billservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private String id;
    private String name;
    private String email;

    @JsonProperty("_links")
    private void unpackLinks(Object links) {
        String href = ((LinkedHashMap<?, ?>) ((LinkedHashMap<?, ?>) links).get("self")).get("href").toString();
        this.id = href.substring(href.lastIndexOf("/") + 1);
    }
}