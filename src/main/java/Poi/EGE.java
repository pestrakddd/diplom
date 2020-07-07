package Poi;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class EGE {
    String nameSchool;
    ArrayList <Predmet> Predmets = new ArrayList<>();
}

@Getter
@Setter
class Predmet {
    String namePredmen;
    double count2;
    double count3;
    double count4;
    double count5;
}
