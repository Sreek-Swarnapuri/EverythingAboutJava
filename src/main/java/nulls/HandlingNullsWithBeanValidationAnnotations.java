package nulls;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class HandlingNullsWithBeanValidationAnnotations {

    public static void main(String[] args) {
        BookDTO book = new BookDTO();
        System.out.println(book(book));
    }

    // To perform the validation, we would need to add @Valid annotation for validating
    public static String book(@Valid BookDTO input) {
        return input.getAuthor();
    }

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BookDTO {

    private Long id;

    @NotNull(message = "Author should not be null")
    private String author;

    @NotNull(message = "Title should not be null")
    private String title;

    private List<@NotNull String> tags;

    private Integer pages;

    private String isbn10;

}
