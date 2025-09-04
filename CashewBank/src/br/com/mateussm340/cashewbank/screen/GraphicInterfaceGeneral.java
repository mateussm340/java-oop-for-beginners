package br.com.mateussm340.cashewbank.screen;

public class GraphicInterfaceGeneral {
    public void generateSequenceAsteriskAutomatic() {
        int limitMax = 50;
        String asteriskMessage = "*";
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i <= limitMax; i++) {
            stringBuffer.append(asteriskMessage);
        }

        System.out.println(stringBuffer);
    }
}