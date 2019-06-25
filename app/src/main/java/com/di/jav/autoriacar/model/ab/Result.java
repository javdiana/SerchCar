
package com.di.jav.autoriacar.model.ab;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "version",
        "author",
        "date_publicated",
        "title",
        "permalink",
        "price",
        "capacity",
        "power",
        "is_new",
        "date_created",
        "make",
        "model",
        "year",
        "location",
        "characteristics",
        "photos",
        "vin",
        "description"
})
@Setter
@Getter
public class Result {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("version")
    public Integer version;
    @JsonProperty("author")
    public Author author;
    @JsonProperty("date_publicated")
    public String datePublicated;
    @JsonProperty("title")
    public String title;
    @JsonProperty("permalink")
    public String permalink;
    @JsonProperty("price")
    public List<Price> price;
    @JsonProperty("capacity")
    public Double capacity;
    @JsonProperty("power")
    public Integer power;
    @JsonProperty("is_new")
    public Boolean isNew;
    @JsonProperty("date_created")
    public String dateCreated;
    @JsonProperty("make")
    public Make make;
    @JsonProperty("model")
    public Model model;
    @JsonProperty("year")
    public Integer year;
    @JsonProperty("location")
    public Location location;
    @JsonProperty("characteristics")
    public Characteristics characteristics;
    @JsonProperty("photos")
    public List<Photo> photos = null;
    @JsonProperty("vin")
    public String vin;
    @JsonProperty("description")
    public String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
