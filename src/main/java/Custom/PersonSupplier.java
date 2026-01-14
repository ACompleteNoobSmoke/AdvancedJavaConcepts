package Custom;

import Model.Person;

import java.util.List;

public class PersonSupplier {

    public static List<Person> getPeople() {
        return List.of(
                new Person("Alice Johnson", "Software Engineer", "alice.johnson@gmail.com", 29),
                new Person("Carla Mendes", "Product Manager", "carla.mendes@startup.co", 31),
                new Person("Daniel Smith", "Backend Developer", "daniel.smith@apiworks.com", 27),
                new Person("Esther Williams", "UX Designer", "esther.williams@designlab.io", 36),
                new Person("Felix Brown", "Data Analyst", "felix.brown@datacorp.com", 25),
                new Person("Grace Kim", "QA Engineer", "grace.kim@qualityhub.com", 33),
                new Person("Hassan Ali", "Cloud Architect", "hassan.ali@awsconsulting.com", 41),
                new Person("Ivy Chen", "Frontend Developer", "ivy.chenwebstudio.dev", 24),
                new Person("Jason Miller", "Site Reliability Engineer", "jason.miller@sreteam.io", 38),
                new Person("Kemi Adeyemi", "Cybersecurity Analyst", "kemi.adeyemi@secureit.net", 35),
                new Person("Liam O'Connor", "Technical Writer", "liam.oconnor@docspro.org", 28),
                new Person("Maria Gonzalez", "Database Administrator", "maria.gonzalez@dbmasters.com", 42),
                new Person("Noah Peterson", "Machine Learning Engineer", "noah.peterson@mlsystems.ai", 30),
                new Person("Zara Ibrahim", "IT Support Specialist", "zara.ibrahim@helpsys.io", 15)
        );
    }
}
