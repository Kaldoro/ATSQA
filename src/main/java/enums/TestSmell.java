package enums;

public enum TestSmell {
    ASSERTION_ROULETTE("Assertion Roulette"),
    SENSITIVE_EQUALITY("Sensitive Equality"),
    EAGER_TEST("Eager Test"),
    RESOURCE_OPTIMISM("Resource Optimism"),
    MYSTERY_GUEST("Mystery Guest"),
    GENERAL_FIXTURE("General Fixture"),
    LAZY_TEST("Lazy Test"),
    INDIRECT_TESTING("Indirect Testing"),
    TEST_CODE_DUPLICATION("Test Code Duplication");

    private String nameStr;
    TestSmell(String name) {
        this.nameStr = name;
    }

    public String getNameStr() {
        return nameStr;
    }
}