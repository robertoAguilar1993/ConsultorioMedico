package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidades, contiene metodos que son utilizadas en la mayoria de las clases para validaciones
 * @author Alex
 */
public class Util {

    public static boolean validateString(String value){
        return value !=null && !ConsultorioMedicoConst.STRING_EMPTY.equals(value);
    }

    public static boolean validateFloat(String value){
        try{
            Float.parseFloat(value);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static boolean validateInteger(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static List<String> getHorasCompletas(String horaInicio, String horaFinal){
        List<String> listHora = new ArrayList<String>();
        String horaRecorrida = horaInicio ;
        int hora = Integer.parseInt(horaInicio.substring(0, 2));
        String tiempo = horaInicio.substring(3, 5);

       while ( !horaRecorrida.equals(horaFinal)) {

           String horaActual = hora < 10 ?  "0" + hora: hora +"";

           if ( "12".equals(horaActual) ) {
               tiempo = ConsultorioMedicoConst.PM;
               hora = 0;
           }
           
           horaRecorrida = horaActual + " " + tiempo;
           listHora.add(horaRecorrida);
           hora ++;
       }

        return  listHora;
    }
    
    public static List<String> getHorasByMedias(String horaInicio, String horaFinal){
        List<String> listHora = new ArrayList<String>();
        String horaRecorrida = horaInicio ;
        String mediaHora = "" ;
        String horaCompeta = "" ;
        int hora = Integer.parseInt(horaInicio.substring(0, 2));
        String tiempo = horaInicio.substring(3, 5);

       while ( !horaRecorrida.equals(horaFinal)) {

           String horaActual = hora < 10 ?  "0" + hora: hora +"";

           if ( "12".equals(horaActual) ) {
               tiempo = ConsultorioMedicoConst.PM;
               hora = 0;
           }
           
           horaCompeta = horaActual + ":00 " + tiempo;
           listHora.add(horaCompeta);
           mediaHora = horaActual + ":30 " + tiempo;
           listHora.add(mediaHora);
           horaRecorrida = horaActual + " " + tiempo;
           hora ++;
       }

        return  listHora;
    }
    

    public static void main(String[] args) {
        List<String>  horas =  getHorasByMedias("03 AM", "08 AM");
        for(String value: horas){
            System.out.println(value);
        }
    }

    /**
     Entrada 11 AM;
     SALIDA 3 PM;

     RESULTADO;
     11 AM
     12 PM
     01 PM
     02 PM
     03 PM
     */
}
