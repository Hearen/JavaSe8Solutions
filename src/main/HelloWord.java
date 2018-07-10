import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class HelloWord {
    public static void main(String... args) {

    }

    private static Map<String, Foo> filterMethod(Set<String> fooStr) {
        List<Foo> fDefs = new ArrayList<>(); // list of Foo objects
        return fDefs.stream()
                .filter(foo -> fooStr.contains(foo.getId()))
                .collect(toMap(Foo::getId, foo -> foo, (oldFoo, newFoo) -> newFoo));
    }

    public class Foo {
        String id;

        public Foo(String id0) {
            this.id = id0;
        }

        public String getId() {
            return id;
        }
    }
}
