/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3task1client;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 *
 * @author NikitaVenugopal
 */
public class Project3Task1Client {

    /**
     * @param args the command line arguments
     */
    private final BigInteger e1 = new BigInteger("65537");
    private final BigInteger d1 = new BigInteger("339177647280468990599683753475404338964037287357290649639740920420195763493261892674937712727426153831055473238029100340967145378283022484846784794546119352371446685199413453480215164979267671668216248690393620864946715883011485526549108913");
    private final BigInteger n1 = new BigInteger("2688520255179015026237478731436571621031218154515572968727588377065598663770912513333018006654248650656250913110874836607777966867106290192618336660849980956399732967369976281500270286450313199586861977623503348237855579434471251977653662553");
    private final BigInteger e2 = new BigInteger("65537");
    private final BigInteger d2 = new BigInteger("3056791181023637973993616177812006199813736824485077865613630525735894915491742310306893873634385114173311225263612601468357849028784296549037885481727436873247487416385339479139844441975358720061511138956514526329810536684170025186041253009");
    private final BigInteger n2 = new BigInteger("3377327302978002291107433340277921174658072226617639935915850494211665206881371542569295544217959391533224838918040006450951267452102275224765075567534720584260948941230043473303755275736138134129921285428767162606432396231528764021925639519");

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws webserviceprovider.NoSuchAlgorithmException_Exception
     */
    public static void main(String[] args) throws java.security.NoSuchAlgorithmException, NoSuchAlgorithmException_Exception {

        Project3Task1Client p = new Project3Task1Client();

        String type = "Celsius";
        System.out.println("->" + p.recordTemperature("1", p.GetCurrentTimeStamp(), type, "50.67", true,true));
        System.out.println("->" + p.recordTemperature("2", p.GetCurrentTimeStamp(), type, "25.56", true,false));
        System.out.println("->" + p.recordTemperature("1", p.GetCurrentTimeStamp(), type, "34.08", true,true));
        System.out.println("->" + p.recordTemperature("1", p.GetCurrentTimeStamp(), type, "45.08", false,true));
        System.out.println("\nTemperatures recorded by the sensors:" + p.getTemperatures());
        System.out.println("\nLast temperature recorded by sensor 1: " + p.getLastTemperature("1"));

    }

    private String getTemperatures() {
        project3task1client.Project3WebService_Service service = new project3task1client.Project3WebService_Service();
        project3task1client.Project3WebService port = service.getProject3WebServicePort();
        return port.getTemperatures();
    }

    private String getLastTemperature(String sensorID) {
        project3task1client.Project3WebService_Service service = new project3task1client.Project3WebService_Service();
        project3task1client.Project3WebService port = service.getProject3WebServicePort();

        return port.getLastTemperature(sensorID);
    }

    private String GetCurrentTimeStamp() {
        java.util.Date date = new java.util.Date();
        //System.out.println(new Timestamp(date.getTime()).toString());
        return new Timestamp(date.getTime()).toString();
    }

    private String recordTemperature(String sensorID, String timeStamp, String type, String temperature, boolean valid, boolean high) throws java.security.NoSuchAlgorithmException, NoSuchAlgorithmException_Exception {
        String toSign = sensorID + timeStamp + type + temperature;
        byte[] sign = getHash(toSign.getBytes());
        byte[] toSend = new byte[sign.length + 1];
        if (valid) {
            toSend[0] = (byte) 0x01;
        } else {
            toSend[0] = (byte) 0xAF;
        }
        System.arraycopy(sign, 0, toSend, 1, sign.length);
        BigInteger m = new BigInteger(toSend);

        project3task1client.Project3WebService_Service service = new project3task1client.Project3WebService_Service();
        project3task1client.Project3WebService port = service.getProject3WebServicePort();

        if (high) {
            return port.highTemperature(sensorID, timeStamp, type, temperature, String.valueOf(m.modPow(d1, n1)));
        } else  {
            return port.lowTemperature(sensorID, timeStamp, type, temperature, String.valueOf(m.modPow(d2, n2)));
        }
      
    }

    private static byte[] getHash(byte[] toSign) throws java.security.NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(toSign);
        byte[] byteData = md.digest();
        return byteData;
    }

}
