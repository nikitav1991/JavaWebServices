/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceprovider;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author NikitaVenugopal
 */
@WebService(serviceName = "Project3WebService")
public class Project3WebService {

    /**
     * This is a sample web service operation
     */
    private LinkedList<String> ll = new LinkedList<>();
    private final BigInteger e2 = new BigInteger("65537");
    private final BigInteger n2 = new BigInteger("3377327302978002291107433340277921174658072226617639935915850494211665206881371542569295544217959391533224838918040006450951267452102275224765075567534720584260948941230043473303755275736138134129921285428767162606432396231528764021925639519");

    private final BigInteger e1 = new BigInteger("65537");
    private final BigInteger n1 = new BigInteger("2688520255179015026237478731436571621031218154515572968727588377065598663770912513333018006654248650656250913110874836607777966867106290192618336660849980956399732967369976281500270286450313199586861977623503348237855579434471251977653662553");

    /**
     * Web service operation
     */
    @WebMethod(operationName = "highTemperature")
    public String highTemperature(@WebParam(name = "sensorID") String sensorID, @WebParam(name = "timeStamp") String timeStamp, @WebParam(name = "type") String type, @WebParam(name = "temperature") String temperature, @WebParam(name = "signature") String signature) throws NoSuchAlgorithmException {
        try {
            String toSign = sensorID + timeStamp + type + temperature;
            byte[] sign = getHash(toSign.getBytes());
            byte[] toSend = new byte[sign.length + 1];
            toSend[0] = (byte) 0x01;
            System.arraycopy(sign, 0, toSend, 1, sign.length);

            BigInteger toDec = new BigInteger(signature);
            BigInteger clear = toDec.modPow(e1, n1);
            byte[] bdecrypt = clear.toByteArray();
            byte[] decrypt_short = new byte[bdecrypt.length - 1];
            System.arraycopy(bdecrypt, 1, decrypt_short, 0, decrypt_short.length);

            if (Arrays.equals(sign, decrypt_short)) // clear.toByteArray();
            {
                ll.add(sensorID + " " + temperature + " High" +" "+ type+ " "+timeStamp);
                return "Temperature: "+temperature+"º"+type+"-High Temperature has been successfully recorded from sensor " + sensorID;
            } else {
                return "invalid signature method";
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException a) {
            return "Signature could not be verified";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "lowTemperature")
    public String lowTemperature(@WebParam(name = "sensorID") String sensorID, @WebParam(name = "timeStamp") String timeStamp, @WebParam(name = "type") String type, @WebParam(name = "temperature") String temperature, @WebParam(name = "signature") String signature) throws NoSuchAlgorithmException {
        try {
            String toSign = sensorID + timeStamp + type + temperature;
            byte[] sign = getHash(toSign.getBytes());
            byte[] toSend = new byte[sign.length + 1];
            toSend[0] = (byte) 0x01;
            
            System.arraycopy(sign, 0, toSend, 1, sign.length);
            
            BigInteger toDec = new BigInteger(signature);
            
            BigInteger clear = toDec.modPow(e2, n2);
            byte[] bdecrypt = clear.toByteArray();
            
            byte[] decrypt_short = new byte[bdecrypt.length - 1];
            System.arraycopy(bdecrypt, 1, decrypt_short, 0, decrypt_short.length);

            if (Arrays.equals(sign, decrypt_short)) {
                ll.add(sensorID + " " + temperature + " Low" +" "+type+ " "+timeStamp);
                return "Temperature: "+temperature+"º"+type+"-Low Temperature has been successfully recorded from sensor " + sensorID;
            } else {
                return "invalid signature method";
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException a) {
            return "Signature could not be verified";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTemperatures")
    public String getTemperatures() {

        try {
            String allTemps = "";
            String[] tempArray = new String[6];
            Iterator<String> itr = ll.iterator();
            while (itr.hasNext()) {
                tempArray = itr.next().split(" ");
                allTemps += "\n" + tempArray[1]+"º"+tempArray[3]+" "+tempArray[2]+" temperature recorded at "+tempArray[4]+" "+tempArray[5];

            }
            return allTemps;
        } catch (NoSuchElementException n) {
            return "No recorded temperatures";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLastTemperature")
    public String getLastTemperature(@WebParam(name = "sensorID") String sensorID) {

        try {
            LinkedList<String> llCopy = new LinkedList<String>();
            Iterator<String> itr = ll.iterator();
            String[] tempArray = new String[6];
            while (itr.hasNext()) {
                tempArray = itr.next().split(" ");
                if (tempArray[0].equals(sensorID)) {
                    llCopy.add(tempArray[1]+"º"+tempArray[3]+" "+tempArray[2]+" temperature at "+tempArray[4]+" "+tempArray[5]);
                }
            }

            return llCopy.getLast();
        } catch (NoSuchElementException n) {
            return "No recorded temperatures by sensor " + sensorID;
        }
           // }
        //   } else {
        //    return "No recorded temperature";
        //  }
    }

    private static byte[] getHash(byte[] toSign) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(toSign);
        byte[] byteData = md.digest();
        return byteData;
    }
}
