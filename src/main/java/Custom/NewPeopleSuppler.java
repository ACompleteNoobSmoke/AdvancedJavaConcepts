package Custom;

import Model.Gender;
import Model.NewPeople;

import java.util.List;
import java.util.function.Supplier;

public class NewPeopleSuppler {

    public static Supplier<List<NewPeople>> newPeopleSupplier = () ->
            List.of(
                    new NewPeople("James", "Carter", 28, "james.carter@gmail.com", Gender.MALE),
                    new NewPeople("Aisha", "Khan", 34, "aisha.khan@yahoo.com", Gender.FEMALE),
                    new NewPeople("Miguel", "Santos", 22, "miguel.santos@hotmail.com", Gender.MALE),
                    new NewPeople("Lena", "Hoffman", 29, "lena.hoffman@gmail.com", Gender.FEMALE),
                    new NewPeople("Darnell", "Brooks", 41, "darnell.brooks@outlook.com", Gender.MALE),
                    new NewPeople("Sofia", "Martinez", 25, "sofia.martinez@gmail.com", Gender.FEMALE),
                    new NewPeople("Kenji", "Tanaka", 37, "kenji.tanaka@yahoo.jp", Gender.MALE),
                    new NewPeople("Nina", "Petrov", 31, "nina.petrov@gmail.com", Gender.FEMALE),
                    new NewPeople("Omar", "Hassan", 45, "omar.hassan@hotmail.com", Gender.MALE),
                    new NewPeople("Priya", "Raman", 27, "priya.raman@gmail.com", Gender.FEMALE),
                    new NewPeople("Marcus", "Reed", 52, "marcus.reed@outlook.com", Gender.MALE),
                    new NewPeople("Elena", "Kovacs", 36, "elena.kovacs@gmail.com", Gender.FEMALE),
                    new NewPeople("Tariq", "Johnson", 23, "tariq.johnson@gmail.com", Gender.MALE),
                    new NewPeople("Camila", "Rios", 40, "camila.rios@yahoo.com", Gender.FEMALE),
                    new NewPeople("Noah", "Bennett", 33, "noah.bennett@gmail.com", Gender.MALE),
                    new NewPeople("Fatima", "Abdul", 26, "fatima.abdul@hotmail.com", Gender.FEMALE),
                    new NewPeople("Leo", "Moretti", 48, "leo.moretti@gmail.com", Gender.MALE),
                    new NewPeople("Rina", "Chowdhury", 21, "rina.chowdhury@gmail.com", Gender.FEMALE),
                    new NewPeople("Daniel", "Park", 35, "daniel.park@gmail.com", Gender.MALE),
                    new NewPeople("Isabella", "Nguyen", 30, "isabella.nguyen@gmail.com", Gender.FEMALE)
            );

}
