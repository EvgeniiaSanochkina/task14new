
    public class NotFoundException extends RuntimeException {
        public NotFoundException(int id) {
            super("Товар с " + id + " не найден");
        }
    }


