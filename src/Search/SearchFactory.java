package Search;

public class SearchFactory {
    private SearchFactory() {
    }

    public static final Search getSearch(String searchType) {
        switch (searchType) {
            case "HCM":
                return new SearchByLocationHCM();
            case "HN":
                return new SearchByLocationHN();
            case "price":
                return new SearchByPrice();
            default:
                throw new IllegalArgumentException("This search type is unsupported");
        }
    }
}
