import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
              
        Scanner sc = new Scanner(System.in);
        
        try {
        
        System.out.println("Insira a quantidade de temperaturas a serem convertidas:");
        int x = sc.nextInt();
        double tempOri[] = new double[x];
        double tempDes[] = new double[x];
        
        System.out.println("Escolha a unidade de origem (digite 1 para Celsius, 2 para Kelvin e 3 para Farenheit):");
        int uniOrigem = sc.nextInt();
        String nomeOrigem = null;
        switch (uniOrigem) {
            case 1 -> nomeOrigem = "Celsius";
            case 2 -> nomeOrigem = "Kelvin";
            case 3 -> nomeOrigem = "Fahrenheit";
            default -> {
            }
        }
        
        System.out.println("Escolha a unidade de destino (digite 1 para Celsius, 2 para Kelvin e 3 para Farenheit):");
        int uniDestino = sc.nextInt();
        String nomeDestino = null;
        switch (uniDestino) {
            case 1 -> nomeDestino = "Celsius";
            case 2 -> nomeDestino = "Kelvin";
            case 3 -> nomeDestino = "Fahrenheit";
            default -> {
            }
        }
        
        if ((uniDestino>3) || (uniDestino<1) || (uniOrigem>3) || (uniOrigem<1)) {
            throw new Exception();
        }
        
        for (int i=0;i<x;i++) {
            System.out.println("Insira o valor da temperatura #" + (i+1) + " a ser convertida:");
            double tempOrigem = sc.nextDouble();
            double tempDestino = tempOrigem;
            
            if ((uniOrigem == 1) && (uniDestino == 2)) {
                tempDestino = tempOrigem + 273.15;
            } else if ((uniOrigem == 1) && (uniDestino == 3)) {
                tempDestino = (tempOrigem * 1.8) + 32;
            } else if ((uniOrigem == 2) && (uniDestino == 1)) {
                tempDestino = tempOrigem - 273.15;
            } else if ((uniOrigem == 2) && (uniDestino == 3)) {
                tempDestino = (1.8 * (tempOrigem - 273.15)) + 32;
            } else if ((uniOrigem == 3) && (uniDestino == 1)) {
                tempDestino = (tempOrigem - 32) / 1.8;
            } else if ((uniOrigem == 3) && (uniDestino == 2)) {
                tempDestino = ((tempOrigem - 32) / 1.8) + 273.15;
            }
                        
            tempOri[i] = tempOrigem;
            tempDes[i] = tempDestino;

        }      
        
                
        double somaOri = 0;       
        for (int i = 0 ; i < x; i++) {
            somaOri += tempOri[i];
        }
        
        double somaDes = 0;       
        for (int i = 0 ; i < x; i++) {
            somaDes += tempDes[i];
        }

        for (int i = 0 ; i < x; i++) {
        System.out.printf("\n%.0fº %s = %.0fº %s.",tempOri[i],nomeOrigem,tempDes[i],nomeDestino);
        }
        
        System.out.printf("\nA média das temperaturas originais é %.0fº %s.",(somaOri/x),nomeOrigem);
        System.out.printf("\nA média das temperaturas convertidas é %.0fº %s.",(somaDes/x),nomeDestino);
        
        } catch (Exception e) {
            System.out.println("Ocorreu um erro. Tente novamente.");
            
        }
    }
}
