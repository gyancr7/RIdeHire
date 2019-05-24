package request;

import io.dropwizard.jackson.JsonSnakeCase;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@JsonSnakeCase
@NoArgsConstructor
public class InputDetails {

    @NotNull private int latitude, longitude;
    @NotNull private Double radius;

}
