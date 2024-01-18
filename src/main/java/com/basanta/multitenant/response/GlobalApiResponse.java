package com.basanta.multitenant.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalApiResponse implements Serializable {
    private boolean status;
    private String message;
    private Object data;

    public GlobalApiResponse( String message, Object data) {
        this.status = true;
        this.message = message;
        this.data = data;
    }
}