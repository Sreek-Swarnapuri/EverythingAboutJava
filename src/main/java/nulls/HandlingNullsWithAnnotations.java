package nulls;

import org.springframework.lang.NonNull;

public class HandlingNullsWithAnnotations {

    @NonNull
    public Integer defaultId;

    public void setDefaultId(Integer id) {
        // IntelliJ / IDE throws a warning stating null is assigned to a value that is annotated with @NotNull
        this.defaultId = null;
    }

    @NonNull
    public Integer getDefaultId() {
        return null;
    }

    public static void main(String[] args) {
        HandlingNullsWithAnnotations h = new HandlingNullsWithAnnotations();

        h.setDefaultId(1);
    }

}
