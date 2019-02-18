package testutil;

import lombok.Builder;

@Builder
public class UserInput {
    private String startTimeInput;
    private String endTimeInput;
    private String familyInput;

    public static UserInputBuilder defaultValues() {
        return new UserInputBuilder().startTimeInput("5:00pm\n").endTimeInput("4:00am\n").familyInput("A");
    }

    @Override
    public String toString() {
        return startTimeInput + endTimeInput + familyInput;
    }
}
