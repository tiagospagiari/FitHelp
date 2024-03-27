/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author tiago
 */
//      public enum  MacroNutriente {
//        PROTEINA, 
//        GORDURA,
//        CARBOIDRATO
public enum MacroNutriente {
    CARBOIDRATO("CARBOIDRATO"),
    PROTEINA("PROTEINA"),
    GORDURA("GORDURA");

    public final String label;

    private MacroNutriente(String label) {
        this.label = label;
    }
    public static MacroNutriente valueOfLabel(String label) {
    for (MacroNutriente e : values()) {
        if (e.label.equals(label)) {
            return e;
        }
    }
    return null;
}
}
