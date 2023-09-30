package mx.com.conversorAlura.conversor;

public class ConversorMonedaLogic {

    public ConversorMonedaLogic(){
    }

    public double realizarConversion(double cantidad, String moneda) {
        if ("Dólares estadounidenses (USD) -> Pesos (MXN)".equals(moneda)) {
            return cantidad * 17.42;
        } else if ("Euros (EUR) -> Pesos (MXN)".equals(moneda)) {
            return cantidad * 18.41;
        } else if ("Libras esterlinas (GBP) -> Pesos (MXN)".equals(moneda)) {
            return cantidad * 21.25;
        } else if ("Yenes japoneses (JPY) -> Pesos (MXN)".equals(moneda)) {
            return cantidad * 0.12;
        } else if ("Won Coreano (KRW) -> Pesos (MXN)".equals(moneda)) {
            return cantidad * 0.013;
        } else if ("Pesos (MXN) -> Dólares estadounidenses (USD)".equals(moneda)) {
            return cantidad * 0.057;
        } else if ("Pesos (MXN) -> Euros (EUR)".equals(moneda)) {
            return cantidad * 0.054;
        } else if ("Pesos (MXN) -> Libras esterlinas (GBP)".equals(moneda)) {
            return cantidad * 0.047;
        } else if ("Pesos (MXN) -> Yenes japoneses (JPY)".equals(moneda)) {
            return cantidad * 8.58;
        } else if ("Pesos (MXN) -> Won Coreano (KRW)".equals(moneda)) {
            return cantidad * 77.67;
        } else {
            return 0.0;
        }
    }
}

