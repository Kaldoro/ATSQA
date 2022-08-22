package Enums;

/**
 * https://www.w3schools.com/java/java_files_read.asp
 **/
public enum TestSmell {
    Assertion_Roulette("Assertion Roulette"),
    Sensitive_Equality("Sensitive Equality"),
    Eager_Test("Eager Test"),
    Resource_Optimism("Resource Optimism"),
    Mystery_Guest("Mystery Guest"),
    General_Fixture("General Fixture"),
    Lazy_Test("Lazy Test"),;

    private String nameStr;
    TestSmell(String name) {
        this.nameStr = name;
    }

    public String getNameStr() {
        return nameStr;
    }
}

