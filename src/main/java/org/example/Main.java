package org.example;

interface ProjectValidator {
    boolean isValid(String projectCode);
}
class BasicProjectValidator implements ProjectValidator {
    @Override
    public boolean isValid(String projectCode) {
        return projectCode != null && !projectCode.isBlank();

    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProjectValidator validator = new BasicProjectValidator();


        String sampleCode = "Map-101";
        boolean result = validator.isValid(sampleCode);
        System.out.println("Is the Project code valid?" + result);
    }
}