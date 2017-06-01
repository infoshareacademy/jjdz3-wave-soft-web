import WaveSoftProgram.FindingPart;
import WaveSoftProgram.parts.PartParser;
import WaveSoftProgram.parts.PlaceInCar;
import partsstorage.PartsImport;

import java.util.List;

public class Hellojava {

    //Below is just for test of feature/JZ3W-26
    //parts_ebay.json should be in src/main/resources
    /*public static void main(String[] args) {
        FindingPart part = new FindingPart();
        part.findPartMenu("parts_ebay.json");
    }*/

    public static void main(String[] args) {
        PartParser partParser = new PartParser("parts_ebay.json");

        PartsImport partsImport = new PartsImport();
        partsImport.partImport(partParser.getPlaceInCarList());
    }
}
