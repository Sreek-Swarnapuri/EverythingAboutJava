package meta_data_and_annotations.customannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Used to specify that this annotation can be used at Runtime
//  specifically used by application developers
@Retention(RetentionPolicy.RUNTIME)
// Used to specify where this annotation can be declared
//    ElementType.TYPE - specifies it is for only classes.
@Target(ElementType.TYPE)
public @interface WorkHandler {

    boolean useThreadPool();

}
