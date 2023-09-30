package mx.com.conversorAlura.conversor;

public class ConversorTemperaturaLogic {
    public ConversorTemperaturaLogic() {
    }

    public double realizarConversion(double temperatura, String unidad) {
        if ("Fahrenheit (°F) -> Celsius (°C)".equals(unidad)) {
            return (temperatura - 32) * 5 / 9;
        } else if ("Kelvin (K) -> Celsius (°C)".equals(unidad)) {
            return temperatura - 273.15;
        } else if ("Celsius (°C) -> Fahrenheit (°F)".equals(unidad)) {
            return (temperatura * 9 / 5) + 32;
        } else if ("Celsius (°C) -> Kelvin (K)".equals(unidad)) {
            return temperatura + 273.15;
        } else {
            return 0.0; 
        }
    }
}