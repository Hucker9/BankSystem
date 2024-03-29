package com.digi.banksystem.model.responsedto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({
        "country",
        "city",
        "street",
        "house",
        "user",
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {

    @JsonIgnore
    private int address_id;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("house")
    private String house;
    @JsonProperty("user")
    private UserResponseDTO userResponseDTO;
}