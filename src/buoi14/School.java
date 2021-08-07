package buoi14;

public class School {

    public School(SchoolBuilder builder) {}

    public static class SchoolBuilder implements Builder<School> {
        @Override
        public School build() {
            return new School(this);
        }
    }
}
